package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class App extends BasePage{

    public App loginWithCookie(){
        String url =  "https://work.weixin.qq.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1406,877));
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid","25456003672219405"));
        driver.manage().addCookie(new Cookie("wwrtx.sid","8DFD-5olxbVx4RGaioEu3WRjc8BsMB2oiu306VHdDzpiHvpe4p-3tfSXj-tFqP9A"));
        driver.navigate().refresh();
        return this;
    }

    public ContactPage toContactPage(){
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }
    public ContactPage toAddMember(){
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }
}
