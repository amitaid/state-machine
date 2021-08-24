package com.exercise.machine;

public abstract class StateMachine<E> {

    private State<E> state;

    public StateMachine(State<E> initialState) {
        this.state = initialState;
    }

    public String getState() {
        return this.state.getName();
    }

    public void event(E event) {
        this.state = state.nextState(event);
        this.state.enterState(event);
    }

}
