import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFA {

    private final ArrayList<State> states;
    private final ArrayList<String> alphabets;
    private final State initialState;
    private final ArrayList<State> finalStates;
    private final TransitionFunction transitionFunction;
    private State currentState;

    private DFA(ArrayList<State> states, ArrayList<String> alphabets, State initialState, ArrayList<State> finalStates, TransitionFunction transitionFunction) {

        this.states = states;
        this.alphabets = alphabets;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitionFunction = transitionFunction;
        this.currentState = initialState;
    }

    public boolean canRecognizeString(String string) throws Exception {
        List<String> strings = Arrays.asList(string.split(""));
        validateAlphabet(strings);
        transitAllAlphabets(strings);
        return finalStates.contains(currentState);
    }

    private void transitAllAlphabets(List<String> strings) {
        for (String alphabet : strings) {
            currentState = transitionFunction.nextStateOf(currentState, alphabet);
        }
    }

    private void validateAlphabet(List<String> strings) throws Exception {
        if (!alphabets.containsAll(strings)) {
            throw new Exception("non valid alphabet exception");
        }
    }

    @Override
    public String toString() {
        return "DFA{" +
                "states=" + states +
                ", alphabets=" + alphabets +
                ", initialState='" + initialState + '\'' +
                ", finalStates=" + finalStates +
                ", transitionFunction=" + transitionFunction +
                ", currentState='" + currentState + '\'' +
                '}';
    }

    public static class DFABuilder {
        private ArrayList<State> states;
        private ArrayList<String> alphabates;
        private State initialState;
        private ArrayList<State> finalStates;
        private TransitionFunction transitionFunction;

        public static DFABuilder builder() {
            return new DFA.DFABuilder();
        }

        public DFABuilder states(ArrayList<State> states) {
            this.states = states;
            return this;
        }

        public DFABuilder alphabets(ArrayList<String> alphabets) {
            this.alphabates = alphabets;
            return this;
        }

        public DFABuilder initialState(State initailState) {

            this.initialState = initailState;
            return this;
        }

        public DFABuilder finalStates(ArrayList<State> finalStates) {
            this.finalStates = finalStates;
            return this;
        }

        public DFABuilder transitionFunction(TransitionFunction transitions) {
            this.transitionFunction = transitions;
            return this;
        }

        public DFA build() throws Exception {
            validateInputs();
            return new DFA(states, alphabates, initialState, finalStates, transitionFunction);
        }


        private void validateInputs() throws Exception {
            if (!(isValidInitialState() && areValidFinalStates() && isValidTransitionFunction())) {
                throw new Exception("not a valid input");
            }
        }

        private boolean isValidTransitionFunction() {
            return transitionFunction.isValid(alphabates, states);
        }

        private boolean areValidFinalStates() {
            return states.containsAll(finalStates);
        }

        private boolean isValidInitialState() {
            return states.contains(initialState);
        }
    }
}
