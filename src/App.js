import React from 'react';
import { SafeAreaView, StatusBar } from 'react-native';
import Greeting from './components/Greeting';

const App = () => {
  return (
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView style={{ flex: 1 }}>
        <Greeting />
      </SafeAreaView>
    </>
  );
};

export default App;
