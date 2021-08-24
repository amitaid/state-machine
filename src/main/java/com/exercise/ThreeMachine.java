package com.exercise;

import com.exercise.machine.StateMachine;

public class ThreeMachine extends StateMachine<ThreeMachineEvent> {

    public ThreeMachine() {
        super(new ThreeMachineState.Initial());
    }

    public ThreeMachine(String initialState) {
        super(ThreeMachineState.fromName(initialState));
    }


    public static void main(String[] args) {
        ThreeMachine machine = new ThreeMachine();

        machine.event(ThreeMachineEvent.A); // One A
        machine.event(ThreeMachineEvent.A); // Two A
        machine.event(ThreeMachineEvent.A); // Should print A
        machine.event(ThreeMachineEvent.A); // Should print A
        machine.event(ThreeMachineEvent.B); // One B
        machine.event(ThreeMachineEvent.B); // Two B
        machine.event(ThreeMachineEvent.A); // One A
        machine.event(ThreeMachineEvent.B); // One B
        machine.event(ThreeMachineEvent.B); // Two B
        machine.event(ThreeMachineEvent.B); // Should print B

        String savedState = machine.getState(); // Save/load this wherever

        ThreeMachine loadedMachine = new ThreeMachine(savedState); // Should load into ThreeB state
        loadedMachine.event(ThreeMachineEvent.B); // Should print B
    }
}
