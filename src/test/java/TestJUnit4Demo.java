import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJUnit4Demo {

    @BeforeClass
    public static void beforeAllTestCases(){
        System.out.println("beforeAllTest");
    }
    @AfterClass
    public static void afterAllTestCases(){
        System.out.println("afterAllTestCases");
    }
    @Before
    public void beforeMethod(){
        System.out.println("I am @before");

    }
    @After
    public void afterMethod(){
        System.out.println("I am @after");
    }
    @Test
    public void testDemo3(){
        System.out.println("testDemo3");
        assertTrue(false);
    }
    @Test
    public void testDemo1(){
        System.out.println("testDemo1");
        assertTrue(true);

    }
    @Test
    public void testDemo2(){
        System.out.println("testDemo2");
        assertTrue(false);
    }
}

