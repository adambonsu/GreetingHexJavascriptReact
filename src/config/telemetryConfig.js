import {OTLPTraceExporter} from '@opentelemetry/exporter-trace-otlp-http';
import {BasicTracerProvider} from '@opentelemetry/sdk-trace-base';
import {Resource} from '@opentelemetry/resources';
import {SemanticResourceAttributes} from '@opentelemetry/semantic-conventions'; // This is deprecated. Is there an alternative?
import {SimpleSpanProcessor} from '@opentelemetry/sdk-trace-base';
import {HONEYCOMB_API_KEY} from '@env';

const setupTelemetry = () => {
  const exporter = new OTLPTraceExporter({
    url: 'https://api.honeycomb.io/v1/traces',
    headers: {
      'x-honeycomb-team': `${HONEYCOMB_API_KEY}`,
      'x-honeycomb-dataset': 'greeting-hex-javascript-react-native',
    },
  });

  const provider = new BasicTracerProvider({
    resource: new Resource({
      [SemanticResourceAttributes.SERVICE_NAME]:
        'greeting-hex-javascript-react',
    }),
  });

  provider.addSpanProcessor(new SimpleSpanProcessor(exporter));
  provider.register();

  return provider;
};

export default setupTelemetry;
