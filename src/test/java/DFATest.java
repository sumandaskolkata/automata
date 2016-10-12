import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void shouldReturnADFAWithFollowingValue() throws Exception {
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<String> alphabets = new ArrayList<String>();
        TransitionFunction transitionFunction = new TransitionFunction();

        String initialState = "q1";
        ArrayList<String> finalStates = new ArrayList<String>();
        finalStates.add("q3");

        states.add("q1");
        states.add("q2");
        states.add("q3");

        alphabets.add("0");
        alphabets.add("1");

        transitionFunction.addTransition("q1", "0", "q1");
        transitionFunction.addTransition("q1", "1", "q2");
        transitionFunction.addTransition("q2", "0", "q1");
        transitionFunction.addTransition("q2", "1", "q3");
        transitionFunction.addTransition("q3", "0", "q1");
        transitionFunction.addTransition("q3", "1", "q3");


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
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<String> alphabets = new ArrayList<String>();
        TransitionFunction transitionFunction = new TransitionFunction();

        String initialState = "q5";
        ArrayList<String> finalStates = new ArrayList<String>();
        finalStates.add("q3");

        states.add("q1");
        states.add("q2");
        states.add("q3");

        alphabets.add("0");
        alphabets.add("1");

        transitionFunction.addTransition("q1", "0", "q1");
        transitionFunction.addTransition("q1", "1", "q2");
        transitionFunction.addTransition("q2", "0", "q1");
        transitionFunction.addTransition("q2", "1", "q3");
        transitionFunction.addTransition("q3", "0", "q1");
        transitionFunction.addTransition("q3", "1", "q3");


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
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<String> alphabets = new ArrayList<String>();
        TransitionFunction transitionFunction = new TransitionFunction();

        String initialState = "q1";
        ArrayList<String> finalStates = new ArrayList<String>();
        finalStates.add("q9");

        states.add("q1");
        states.add("q2");
        states.add("q3");

        alphabets.add("0");
        alphabets.add("1");

        transitionFunction.addTransition("q1", "0", "q1");
        transitionFunction.addTransition("q1", "1", "q2");
        transitionFunction.addTransition("q2", "0", "q1");
        transitionFunction.addTransition("q2", "1", "q3");
        transitionFunction.addTransition("q3", "0", "q1");
        transitionFunction.addTransition("q3", "1", "q3");


        DFA.DFABuilder.builder()
                .states(states)
                .alphabets(alphabets)
                .transitionFunction(transitionFunction)
                .initialState(initialState)
                .finalStates(finalStates)
                .build();
    }
}
