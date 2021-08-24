package com.exercise;

/**
 * Enum for a finite set of events
 */
public enum ThreeMachineEvent {
    A, B;

    // Can hold data if needed
    private final String data;

    ThreeMachineEvent() {
        this.data = null;
    }

    ThreeMachineEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
