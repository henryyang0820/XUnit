package app.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Prowess on 2019/11/12.
 */
public class App extends BasePage{
   public static LoginPage start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.bravolinks.erp_client");
        desiredCapabilities.setCapability("appActivity", "com.bravolinks.erp.supplier.ui.splash.SplashActivity");
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("deviceName", "android");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        //速度会比较慢
//        By adsLocator=By.id("xxx");
//        List<WebElement> ads=driver.findElements(adsLocator);
//        if(ads.size()>=1){
//            ads.get(0).click();
//        }
        click(By.id("com.bravolinks.erp_client:id/bt_enter"));
        return new LoginPage();
    }

}
