import React from 'react';
import { render, waitFor } from '@testing-library/react-native';
import LoadingWrapper from '../LoadingWrapper';

describe('LoadingWrapper', () => {
    it('should display the loading indicator when isLoading is true', () => {
        const { getByTestId } = render(
            <LoadingWrapper isLoading={true}>
                <Text>Content</Text>
            </LoadingWrapper>
        );
        expect(getByTestId('loadingIndicator')).toBeDefined();
    });

    it('should display children when isLoading is false', () => {
        const { getByText, queryByTestId } = render(
            <LoadingWrapper isLoading={false}>
                <Text>Content</Text>
            </LoadingWrapper>
        );
        expect(getByText('Content')).toBeDefined();
        expect(queryByTestId('loadingIndicator')).toBeNull();
    });

    it('should have correct accessibility properties', () => {
        const { getByLabelText } = render(
            <LoadingWrapper isLoading={true}>
                <Text>Content</Text>
            </LoadingWrapper>
        );
        const loadingElement = getByLabelText('Loading');
        expect(loadingElement).toHaveAccessibilityState({ busy: true });
    });
});