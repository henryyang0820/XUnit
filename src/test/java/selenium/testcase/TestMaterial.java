package selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.pages.App;

public class TestMaterial {
    public static App app;
    @BeforeClass
    public static void beforeAll()  {
        app=new App();
        app.loginWithCookie();

    }

    @Test
    public void addPhotoAndWord() throws InterruptedException {
        String title = "标题"+System.currentTimeMillis();
        app.toManageMaterial().addPandW(title);

    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }
}
