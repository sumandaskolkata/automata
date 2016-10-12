import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransitionFunctionTest {
    @Test
    public void transitionFunctionShouldAddTransitions() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();

        transitionFunction.addTransition("q1","1","q2");
        transitionFunction.addTransition("q2","0","q1");

        assertEquals(transitionFunction.nextStateOf("q1","1"),"q2");
        assertEquals(transitionFunction.nextStateOf("q2","0"),"q1");
    }

    @Test
    public void transitionFunctionShouldValidWhenTransitionFunctionHasAllStateTransitionForAllAlphabets() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();
        ArrayList<String> alphabets = new ArrayList<String>();
        ArrayList<String> states = new ArrayList<String>();
        alphabets.add("0");
        alphabets.add("1");
        states.add("q1");
        states.add("q2");

        transitionFunction.addTransition("q1","1","q2");
        transitionFunction.addTransition("q1","0","q1");
        transitionFunction.addTransition("q2","1","q2");
        transitionFunction.addTransition("q2","0","q1");

        assertTrue(transitionFunction.isValid(alphabets,states));

    }
    @Test
    public void transitionFunctionShouldNotValidWhenTransitionFunctionHasAllStateTransitionForAllAlphabets() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();
        ArrayList<String> alphabets = new ArrayList<String>();
        ArrayList<String> states = new ArrayList<String>();
        alphabets.add("0");
        alphabets.add("1");
        states.add("q1");
        states.add("q2");

        transitionFunction.addTransition("q1","1","q2");
        transitionFunction.addTransition("q1","0","q1");
        transitionFunction.addTransition("q2","0","q2");
        transitionFunction.addTransition("q2","0","q1");

        assertFalse(transitionFunction.isValid(alphabets,states));
    }
}