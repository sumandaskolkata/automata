public class State {

    private final String stateName;

    public State(String stateName) {

        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateName='" + stateName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        return stateName != null ? stateName.equals(state.stateName) : state.stateName == null;

    }

    @Override
    public int hashCode() {
        return stateName != null ? stateName.hashCode() : 0;
    }
}
