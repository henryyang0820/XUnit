import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

@RunWith(Parameterized.class)
public class TestParam {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2}, {3, 4}, {4, 6}, {3, 3}, {5, 7}
        });
    }

    @Parameterized.Parameter
    public int actInt;
    @Parameterized.Parameter(1)
    public int expectInt;

    @Test
    public void testDemo() {
        assertThat("demo", actInt, equalTo(expectInt));
    }
}
