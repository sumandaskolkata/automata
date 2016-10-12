import java.util.*;

public class TransitionFunction {
    private final HashMap<String, HashMap<String, String>> transition;

    public TransitionFunction() {
        transition = new HashMap<String, HashMap<String, String>>();
    }

    public void addTransition(String state, String alphabet, String nextState) {
        if (transition.containsKey(state)) {
            HashMap<String, String> stringStringHashMap = transition.get(state);
            stringStringHashMap.put(alphabet, nextState);
        } else {
            HashMap<String, String> newTransition = new HashMap<String, String>();
            newTransition.put(alphabet, nextState);
            transition.put(state, newTransition);
        }
    }

    public boolean isValid(ArrayList<String> alphabets, ArrayList<String> states) {
        return transition.keySet().containsAll(states) && hasAllAlphabets(alphabets, states);
    }

    private boolean hasAllAlphabets(ArrayList<String> alphabets, ArrayList<String> states) {
        for (String state : states) {
            if (!transition.get(state).keySet().containsAll(alphabets)) {
                return false;
            }
        }
        return true;
    }

    public String nextStateOf(String currentState, String alphabet) {
        return transition.get(currentState).get(alphabet);
    }

    @Override
    public String toString() {
        return "TransitionFunction{" +
                "transition=" + transition +
                '}';
    }
}
