import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

const Greeting = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Hello World!</Text>
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

export default Greeting;