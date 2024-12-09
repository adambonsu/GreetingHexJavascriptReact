import React from 'react';
import { render, screen } from '@testing-library/react-native';
import LoadingIndicator from '../LoadingIndicator';

describe('LoadingIndicator', () => {
    it('renders correctly', () => {
        render(<LoadingIndicator />);
        const loadingElement = screen.getByLabelText('Loading');
        expect(loadingElement).toBeTruthy();
    });

    it('has correct accessibility properties', () => {
        render(<LoadingIndicator />);
        const loadingElement = screen.getByLabelText('Loading');
        expect(loadingElement).toHaveAccessibilityState({ busy: true});
    });

    it('uses default colour when not provided', () => {
        render(<LoadingIndicator />);
        const activityIndicator = screen.getByTestId('loadingIndicator');
        expect(activityIndicator.props.color).toBe('#0000ff');
    })

    it('uses custom colour when provided', () => {
        render(<LoadingIndicator color="#ff9999"/>);
        const activityIndicator = screen.getByTestId('loadingIndicator');
        expect(activityIndicator.props.color).toBe('#ff9999');
    })

    it('uses default size when not provided', () => {
        render(<LoadingIndicator />);
        const activityIndicator = screen.getByTestId('loadingIndicator');
        expect(activityIndicator.props.size).toBe('large');
    })

    it('uses custom size when provided', () => {
        render(<LoadingIndicator size="small"/>);
        const activityIndicator = screen.getByTestId('loadingIndicator');
        expect(activityIndicator.props.size).toBe('small');
    })

    it('applies correct styles to container', () => {
        const { getByLabelText } = render(<LoadingIndicator />);
        const container = getByLabelText('Loading');
        expect(container.props.style).toEqual(
            expect.objectContaining({
                flex: 1,
                justifyContent: 'center',
                alignItems: 'center',
            })
        );
    });
});
