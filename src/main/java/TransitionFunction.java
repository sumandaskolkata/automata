import java.util.*;

public class TransitionFunction {
    private final HashMap<State, HashMap<String, State>> transition;

    public TransitionFunction() {
        transition = new HashMap<State, HashMap<String, State>>();
    }

    public void addTransition(State state, String alphabet, State nextState) {
        if (transition.containsKey(state)) {
            HashMap<String, State> stringStateHashMap = transition.get(state);
            stringStateHashMap.put(alphabet, nextState);
        } else {
            HashMap<String, State> newTransition = new HashMap<String, State>();
            newTransition.put(alphabet, nextState);
            transition.put(state, newTransition);
        }
    }

    public boolean isValid(ArrayList<String> alphabets, ArrayList<State> states) {
        return transition.keySet().containsAll(states) && hasAllAlphabets(alphabets, states);
    }

    private boolean hasAllAlphabets(ArrayList<String> alphabets, ArrayList<State> states) {
        for (State state : states) {
            if (!transition.get(state).keySet().containsAll(alphabets)) {
                return false;
            }
        }
        return true;
    }

    public State nextStateOf(State currentState, String alphabet) {
        return transition.get(currentState).get(alphabet);
    }

    @Override
    public String toString() {
        return "TransitionFunction{" +
                "transition=" + transition +
                '}';
    }
}
