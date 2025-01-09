import React, {useState, useEffect} from 'react';
import {View, Text, StyleSheet} from 'react-native';
import {greet} from '@adambonsu/greeting-hex-javascript';
import {trace} from '@opentelemetry/api';

const Greeting = () => {
  const [greeting, setGreeting] = useState('');
  useEffect(() => {
    const tracer = trace.getTracer('greeting-component');
    const span = tracer.startSpan('greeting-render');
    try {
      const generatedGreeting = greet();
      setGreeting(generatedGreeting);
      span.setAttributes({
        'greeting.text': greeting,
        'greeting.length': greeting.length,
      });
    } finally {
      span.end();
    }
  }, []);

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
  },
  text: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#333',
  },
});

export {styles};
export default Greeting;
