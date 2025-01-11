import {useState, useEffect} from 'react';
import setupTracing from '../utils/tracing';

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

export default useTracing;
