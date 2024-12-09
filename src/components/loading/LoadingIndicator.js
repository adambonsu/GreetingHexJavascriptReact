import React from 'react'; 
import { View, ActivityIndicator, StyleSheet } from 'react-native';

const LoadingIndicator = ({ size = 'large', color = '#0000ff' }) => (
    <View style={styles.container} accessibilityLabel="Loading" aria-busy={true}>
      <ActivityIndicator size={size} color={color} testID="loadingIndicator" />
    </View>
);

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
});

export default LoadingIndicator;