package selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.pages.App;

public class TestDept {
    public static App app;
    @BeforeClass
    public static void beforeAll()  {
        app=new App();
        app.loginWithCookie();

    }

    @Test
    public void addDept(){
        String name = "部门"+ System.currentTimeMillis();
        app.toContact().addDept(name);
    }

    @Test
    public void delDept(){
        app.toContact().delDept();
    }

    @Test
    public void PromoteP(){
        app.toContact().promotePerson();
    }

    @Test
    public void updateName(){
        String name="天猫科技"+System.currentTimeMillis();
        app.toContact().updateDept(name);
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }
}
