package selenium.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.linkText;

public class App extends BasePage {

    public App loginWithCookie() {
        String url = "https://work.weixin.qq.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1406, 877));
        driver.findElement(linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "42351602663264511"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "8DFD-5olxbVx4RGaioEu3QDYSeFRYj-sSDJtIMnfujqu-vgIfBhM5cNjXE_sCGLU"));
        driver.navigate().refresh();
        return this;
    }

    public ConTactPage toContact() {
        return new ConTactPage();
    }

    public ConTactPage toAddMember() {
        findElement(linkText("添加成员")).click();
        return new ConTactPage();
    }
}
