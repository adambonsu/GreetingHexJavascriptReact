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

export default setupTracing;
