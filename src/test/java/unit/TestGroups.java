package unit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class TestGroups {
    @Test
    @Category({SlowGroup.class, FastGroup.class})
    public void testSlowDemo1() {
        assertTrue(false);
    }

    @Category(SlowGroup.class)
    @Test
    public void testSlowDemo2() {
        assertEquals("test diff",100,10);
        assertTrue(false);
    }

    @Test
    @Category(SlowGroup.class)
    public void testSlowDemo3() {
        assertThat("obj is closer to 10",10.0,anyOf(closeTo(10.1,0.1),equalTo(9.0)));
    }

    @Test
    @Category(FastGroup.class)
    public void testSlowDemo4() {
        assertTrue(false);
    }


}
