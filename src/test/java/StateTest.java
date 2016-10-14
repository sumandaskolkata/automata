import com.google.common.truth.Truth;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {
    @Test
    public void twoStateShouldBeEqualWHenTheyHaveSameName() throws Exception {
        State q1 = new State("q1");
        State another = new State("q1");
        Truth.assertThat(q1.equals(another));
    }
}