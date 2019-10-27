package unit;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJUnit4DemoChirldren2 extends TestJUnit4Demo{

    @BeforeClass
    public static void beforeAllTestCasesChirldren2(){
        System.out.println("unit.TestJUnit4DemoChirldren2 beforeAllTest");
    }
    @AfterClass
    public static void afterAllTestCasesChirldren2(){
        System.out.println("unit.TestJUnit4DemoChirldren2 afterAllTestCases");
    }
    @Before
    public void beforeMethodChirldren2(){
        System.out.println("unit.TestJUnit4DemoChirldren2 I am @before");

    }
    @After
    public void afterMethodChirldren2(){
        System.out.println("unit.TestJUnit4DemoChirldren2 I am @after");
    }
    @Test
    public void testDemo3Chirldren2(){
        System.out.println("unit.TestJUnit4DemoChirldren2 testDemo3");
        assertTrue(false);
    }
    @Test
    public void testDemo1Chirldren2(){
        System.out.println("unit.TestJUnit4DemoChirldren2 testDemo1");
        assertTrue(true);

    }
    @Test
    public void testDemo2Chirldren2(){
        System.out.println("unit.TestJUnit4DemoChirldren2 testDemo2");
        assertTrue(false);
    }
}

