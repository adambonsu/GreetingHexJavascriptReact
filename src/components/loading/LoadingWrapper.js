import React from 'react';
import { View } from 'react-native';
import Loadingindicator from './LoadingIndicator';

const LoadingWrapper = ({ isLoading, children }) => {
    return (
        <View aria-busy={isLoading} aria-live="polite">
            {isLoading ? <Loadingindicator/> : children}
        </View>
    );
};

export default LoadingWrapper;