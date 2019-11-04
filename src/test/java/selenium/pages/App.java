package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class App extends BasePage {

    public App loginWithCookie()  {
        String url = "https://work.weixin.qq.com/";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("pageLoadStrategy", "none");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();
//        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "42351602662459829"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "8DFD-5olxbVx4RGaioEu3eH0VoYiFcVQMM9pe7-ksWhvFwaQ6hfU7pBTW7f0iTKk"));
        driver.navigate().refresh();
        return this;
    }

    public ContactPage toContact() {
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();

    }

    public ContactPage toAddMember() {
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }

    public BroadcastPage toGroupMessage() {
        findElement(By.linkText("管理工具")).click();
        findElement(By.cssSelector(".ww_icon_AppGroupMessageBig")).click();
        return new BroadcastPage();
    }
}
