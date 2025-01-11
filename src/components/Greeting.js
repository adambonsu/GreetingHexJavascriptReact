import React, {useState, useEffect} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import {greet} from '@adambonsu/greeting-hex-javascript';
import {
  SimpleSpanProcessor,
  WebTracerProvider,
} from '@opentelemetry/sdk-trace-web';
import {OTLPTraceExporter} from '@opentelemetry/exporter-trace-otlp-http';
import {trace} from '@opentelemetry/api';

const setupTracing = operationName => {
  const provider = new WebTracerProvider();
  const exporter = new OTLPTraceExporter({
    url: 'https://<otel-collector-ip>:4318/v1/traces',
  });
  provider.addSpanProcessor(new SimpleSpanProcessor(exporter));
  provider.register();
  return trace.getTracer(operationName);
};

const useTracing = operationName => {
  const tracer = setupTracing('greeting-component');
  const [span, setSpan] = useState(null);

  useEffect(() => {
    const newSpan = tracer.startSpan(operationName);
    setSpan(newSpan);
    return () => newSpan.end();
  }, [operationName]);
  return span;
};

const Greeting = () => {
  const [greeting, setGreeting] = useState('');
  const span = useTracing('greeting-render');

  useEffect(() => {
    try {
      const generatedGreeting = greet();
      setGreeting(generatedGreeting);
      if (span) {
        span.setAttributes({
          'greeting.text': generatedGreeting,
          'greeting.length': generatedGreeting.length,
          'greeting.timestamp': new Date().toISOString(),
          'greeting.component': 'Greeting',
        });
      }
    } catch (error) {
      if (span) {
        span.recordException(error);
        span.setStatus({code: 2, message: error.message});
      }
      console.error('Error generating greeting:', error);
    }
  }, [span]);

  return (
    <View style={styles.container}>
      <Text style={styles.text} accessibilityLabel="greeting" testID="greeting">
        {greeting}
      </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
    padding: 20,
  },
  text: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#333',
    textAlign: 'center',
  },
});

export {styles};
export default Greeting;
