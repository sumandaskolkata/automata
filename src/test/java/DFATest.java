import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void shouldReturnADFAWithFollowingValue() throws Exception {
        ArrayList<State> states = new ArrayList<State>();
        ArrayList<String> alphabets = new ArrayList<String>();
        TransitionFunction transitionFunction = new TransitionFunction();

        State initialState = new State("q1");
        ArrayList<State> finalStates = new ArrayList<State>();
        finalStates.add(new State("q3"));

        states.add(new State("q1"));
        states.add(new State("q2"));
        states.add(new State("q3"));

        alphabets.add("0");
        alphabets.add("1");

        transitionFunction.addTransition(new State("q1"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q1"), "1", new State("q2"));
        transitionFunction.addTransition(new State("q2"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q2"), "1", new State("q3"));
        transitionFunction.addTransition(new State("q3"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q3"), "1", new State("q3"));


        DFA dfa = DFA.DFABuilder.builder()
                .states(states)
                .alphabets(alphabets)
                .transitionFunction(transitionFunction)
                .initialState(initialState)
                .finalStates(finalStates)
                .build();

        assertTrue(dfa.canRecognizeString("010101011111"));
    }

    @Test(expected = Exception.class)
    public void shouldThrowAnExceptionIfInitialStateDoNotBelongInStates() throws Exception {
        ArrayList<State> states = new ArrayList<State>();
        ArrayList<String> alphabets = new ArrayList<String>();
        TransitionFunction transitionFunction = new TransitionFunction();

        State initialState = new State("q5");
        ArrayList<State> finalStates = new ArrayList<State>();
        finalStates.add(new State("q3"));

        states.add(new State("q1"));
        states.add(new State("q2"));
        states.add(new State("q3"));

        alphabets.add("0");
        alphabets.add("1");

        transitionFunction.addTransition(new State("q1"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q1"), "1", new State("q2"));
        transitionFunction.addTransition(new State("q2"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q2"), "1", new State("q3"));
        transitionFunction.addTransition(new State("q3"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q3"), "1", new State("q3"));


        DFA.DFABuilder.builder()
                .states(states)
                .alphabets(alphabets)
                .transitionFunction(transitionFunction)
                .initialState(initialState)
                .finalStates(finalStates)
                .build();
    }

    @Test(expected = Exception.class)
    public void shouldThrowAnExceptionIfFinalStatesDoNotBelongInStates() throws Exception {
        ArrayList<State> states = new ArrayList<State>();
        ArrayList<String> alphabets = new ArrayList<String>();
        TransitionFunction transitionFunction = new TransitionFunction();

        State initialState = new State("q1");
        ArrayList<State> finalStates = new ArrayList<State>();
        finalStates.add(new State("q9"));

        states.add(new State("q1"));
        states.add(new State("q2"));
        states.add(new State("q3"));

        alphabets.add("0");
        alphabets.add("1");

        transitionFunction.addTransition(new State("q1"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q1"), "1", new State("q2"));
        transitionFunction.addTransition(new State("q2"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q2"), "1", new State("q3"));
        transitionFunction.addTransition(new State("q3"), "0", new State("q1"));
        transitionFunction.addTransition(new State("q3"), "1", new State("q3"));


        DFA.DFABuilder.builder()
                .states(states)
                .alphabets(alphabets)
                .transitionFunction(transitionFunction)
                .initialState(initialState)
                .finalStates(finalStates)
                .build();

    }
}
