import React, { useState, useEffect } from 'react';
import { SafeAreaView, StatusBar, Text, View } from 'react-native';
import LoadingWrapper from './components/loading/LoadingWrapper';
import Greeting from './components/Greeting';

const App = () => {
  const [isLoading, setIsLoading] = useState(true);
  const [data, setData] = useState(null);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      setIsLoading(true);
      // Simulating API call
      await new Promise(resolve => setTimeout(resolve, 2000));
      setData('Data loaded');
    } catch (error) {
      console.error('Error fetching data:', error);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <>
      <StatusBar barStyle="dark-content" />
      <LoadingWrapper isLoading={isLoading}>
        <SafeAreaView style={{ flex: 1 }}>
          <Greeting />
        </SafeAreaView>
      </LoadingWrapper>
    </>
    
  );
};

export default App;
