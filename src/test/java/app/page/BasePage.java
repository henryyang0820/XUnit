package app.page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static AndroidDriver<WebElement> driver;

    public static WebElement findElement(By by) {
        //todo: 递归是更好的
        //todo: 如果定位的元素是动态变化位置

        System.out.println(by);
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            handleAlert();

            return driver.findElement(by);
        }
    }

    public static void click(By by) {
        //todo: 递归是更好的

        System.out.println(by);
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            handleAlert();

            click(by);
        }
    }

//    public static List<WebElement> findElements(By by) {
//        System.out.println(by);
//        return driver.findElements(by);
//    }

    static void handleAlert() {
        By tips = By.id("com.bravolinks.erp_client:id/tv_deco");
        List<By> alertBoxs = new ArrayList<>();
        //todo: 不需要所有的都判断是否存在
        By guidePage = By.id("com.bravolinks.erp_client:id/vp_guide");
        alertBoxs.add(tips);
        alertBoxs.add(guidePage);
//        alertBoxs.add(By.xpath("dddd"));

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert -> {
            List<WebElement> ads = driver.findElements(alert);
            Dimension size = driver.manage().window().getSize();
            if (alert.equals(guidePage)) {
                new TouchAction(driver).press(PointOption.point(800, 720)).moveTo(PointOption.point(100, 720)).release().perform();
            } else {
                System.out.println(tips.toString());
                if (alert.equals(tips)) {
                    System.out.println("snb_tip found");

                    try {
                        if (driver.findElements(tips).size() >= 1) {
                            new TouchAction(driver).tap(PointOption.point(size.width / 2, size.height / 2)).perform();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("snb_tip clicked");
                    }
                } else if (ads.size() >= 1) {
                    ads.get(0).click();
                }
            }
        });
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private static void handleAlertByPageSource() {
        //todo: xpath匹配， 标记 定位
        String xml = driver.getPageSource();
        List<String> alertBoxs = new ArrayList<>();
        alertBoxs.add("xxx");
        alertBoxs.add("yyy");

        alertBoxs.forEach(alert -> {
            if (xml.contains(alert)) {
                driver.findElement(By.id(alert)).click();
            }
        });

    }

}