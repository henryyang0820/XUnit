import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJUnit4DemoChirldren extends TestJUnit4Demo{

    @BeforeClass
    public static void beforeAllTestCasesChirldren(){
        System.out.println("TestJUnit4DemoChirldren beforeAllTest");
    }
    @AfterClass
    public static void afterAllTestCasesChirldren(){
        System.out.println("TestJUnit4DemoChirldren afterAllTestCases");
    }
    @Before
    public void beforeMethodChirldren(){
        System.out.println("TestJUnit4DemoChirldren I am @before");

    }
    @After
    public void afterMethodChirldren(){
        System.out.println("TestJUnit4DemoChirldren I am @after");
    }
    @Test
    public void testDemo3Chirldren(){
        System.out.println("TestJUnit4DemoChirldren testDemo3");
        assertTrue(false);
    }
    @Test
    public void testDemo1Chirldren(){
        System.out.println("TestJUnit4DemoChirldren testDemo1");
        assertTrue(true);

    }
    @Test
    public void testDemo2Chirldren(){
        System.out.println("TestJUnit4DemoChirldren testDemo2");
        assertTrue(false);
    }
}

