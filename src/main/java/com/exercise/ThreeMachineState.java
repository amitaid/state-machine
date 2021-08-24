package com.exercise;

import com.exercise.machine.State;

import java.lang.reflect.Constructor;

public class ThreeMachineState {

    static class Initial extends State<ThreeMachineEvent> {

        public Initial() {
            super("Initial");
        }

        @Override
        public State<ThreeMachineEvent> nextState(ThreeMachineEvent event) {
            switch (event) {
                case A:
                    return new OneA();
                case B:
                    return new OneB();
                default:
                    throw new IllegalArgumentException(); // Should never get here
            }
        }
    }

    static class OneA extends State<ThreeMachineEvent> {

        public OneA() {
            super("OneA");
        }

        @Override
        public State<ThreeMachineEvent> nextState(ThreeMachineEvent event) {
            switch (event) {
                case A:
                    return new TwoA();
                case B:
                    return new OneB();
                default:
                    throw new IllegalArgumentException(); // Should never get here
            }
        }
    }

    static class OneB extends State<ThreeMachineEvent> {

        public OneB() {
            super("OneB");
        }

        @Override
        public State<ThreeMachineEvent> nextState(ThreeMachineEvent event) throws IllegalArgumentException {
            switch (event) {
                case A:
                    return new OneA();
                case B:
                    return new TwoB();
                default:
                    throw new IllegalArgumentException(); // Should never get here
            }
        }
    }

    static class TwoA extends State<ThreeMachineEvent> {

        public TwoA() {
            super("TwoA");
        }

        @Override
        public State<ThreeMachineEvent> nextState(ThreeMachineEvent event) {
            switch (event) {
                case A:
                    return new ThreeA();
                case B:
                    return new OneB();
                default:
                    throw new IllegalArgumentException(); // Should never get here
            }
        }
    }

    static class TwoB extends State<ThreeMachineEvent> {

        public TwoB() {
            super("TwoB");
        }

        @Override
        public State<ThreeMachineEvent> nextState(ThreeMachineEvent event) {
            switch (event) {
                case A:
                    return new OneA();
                case B:
                    return new ThreeB();
                default:
                    throw new IllegalArgumentException(); // Should never get here
            }
        }
    }

    static class ThreeA extends State<ThreeMachineEvent> {

        public ThreeA() {
            super("ThreeA");
        }

        @Override
        public State<ThreeMachineEvent> nextState(ThreeMachineEvent event) {
            switch (event) {
                case A:
                    return new ThreeA();
                case B:
                    return new OneB();
                default:
                    throw new IllegalArgumentException(); // Should never get here
            }
        }

        @Override
        public void enterState(ThreeMachineEvent event) {
            System.out.println("Three A's received!");
        }
    }

    static class ThreeB extends State<ThreeMachineEvent> {

        public ThreeB() {
            super("ThreeB");
        }

        @Override
        public State<ThreeMachineEvent> nextState(ThreeMachineEvent event) {
            switch (event) {
                case A:
                    return new OneA();
                case B:
                    return new ThreeB();
                default:
                    throw new IllegalArgumentException(); // Should never get here
            }
        }

        @Override
        public void enterState(ThreeMachineEvent event) {
            System.out.println("Three B's received!");
        }
    }

    @SuppressWarnings("unchecked")
    public static State<ThreeMachineEvent> fromName(String name) {
        try {
            Class<?> clazz = Class.forName(name);
            Constructor<?> ctor = clazz.getConstructor();
            Object object = ctor.newInstance();
            return (State<ThreeMachineEvent>) object;
        } catch (Exception e) {
            throw new IllegalArgumentException("No state could be created from: " + name);
        }
    }
}
