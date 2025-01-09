import React, {useEffect} from 'react';
import {SafeAreaView, StatusBar} from 'react-native';
import setupTelemetry from './config/telemetryConfig';
import Greeting from './components/Greeting';

const App = () => {
  useEffect(() => {
    const provider = setupTelemetry();
    return () => {
      provider.shutdown();
    };
  }, []);

  return (
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView style={{flex: 1}}>
        <Greeting />
      </SafeAreaView>
    </>
  );
};

export default App;
