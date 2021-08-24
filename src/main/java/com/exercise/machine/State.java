package com.exercise.machine;

public abstract class State<E> {

    public final String NAME;

    public State(String name) {
        this.NAME = name;
    }

    /**
     * Core functionality: Return next state based on current state + event
     */
    public abstract State<E> nextState(E event);

    /**
     * Optional method to perform when entering a state
     */
    public void enterState(E event) {}

    public String getName() {
        return this.getClass().getName();
    }
}
