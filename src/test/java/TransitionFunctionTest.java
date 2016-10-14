import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransitionFunctionTest {
    @Test
    public void transitionFunctionShouldAddTransitions() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();

        transitionFunction.addTransition(new State("q1"),"1",new State("q2"));
        transitionFunction.addTransition(new State("q2"),"0",new State("q1"));

        assertEquals(transitionFunction.nextStateOf(new State("q1"),"1"),new State("q2"));
        assertEquals(transitionFunction.nextStateOf(new State("q2"),"0"),new State("q1"));
    }

    @Test
    public void transitionFunctionShouldValidWhenTransitionFunctionHasAllStateTransitionForAllAlphabets() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();
        ArrayList<String> alphabets = new ArrayList<String>();
        ArrayList<State> states = new ArrayList<State>();
        alphabets.add("0");
        alphabets.add("1");
        states.add(new State("q1"));
        states.add(new State("q2"));

        transitionFunction.addTransition(new State("q1"),"1",new State("q2"));
        transitionFunction.addTransition(new State("q1"),"0",new State("q1"));
        transitionFunction.addTransition(new State("q2"),"1",new State("q2"));
        transitionFunction.addTransition(new State("q2"),"0",new State("q1"));

        assertTrue(transitionFunction.isValid(alphabets,states));

    }
    @Test
    public void transitionFunctionShouldNotValidWhenTransitionFunctionDoNotHasAllStateTransitionForAllAlphabets() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();
        ArrayList<String> alphabets = new ArrayList<String>();
        ArrayList<State> states = new ArrayList<State>();
        alphabets.add("0");
        alphabets.add("1");
        states.add(new State("q1"));
        states.add(new State("q2"));

        transitionFunction.addTransition(new State("q1"),"1",new State("q2"));
        transitionFunction.addTransition(new State("q1"),"0",new State("q1"));
        transitionFunction.addTransition(new State("q2"),"0",new State("q2"));
        transitionFunction.addTransition(new State("q2"),"0",new State("q1"));

        assertFalse(transitionFunction.isValid(alphabets,states));

    }
}