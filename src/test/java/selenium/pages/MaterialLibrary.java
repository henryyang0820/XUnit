package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MaterialLibrary extends BasePage {

    public MaterialLibrary addPandW(String title) throws InterruptedException, AWTException {
        String path = System.getProperty("user.dir") + "\\src\\15648964.jpg";
        findElement(By.linkText("图文")).click();
        Thread.sleep(100);
        findElement(By.linkText("添加图文")).click();
        Thread.sleep(100);
        driver.switchTo().frame("ueditor_0");
        findElement(By.cssSelector(".msg_mpNewsEditor_frameBody")).sendKeys("正文");
        driver.switchTo().defaultContent();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        ((JavascriptExecutor) (driver)).executeScript("arguments[0].scrollTo(0, 500)", findElement(By.id("js_mpNews_editor_wrap")));
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        findElement(By.id("AttachFrame")).click();

        //上传附件的input标签找不到,用robot解决.不加sleep会出现不能复制路径到上传窗口的情况
        Thread.sleep(1000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        findElement(By.linkText("添加封面图")).click();
        findElement(By.xpath("//*[@class='cropper_mainImgContainer']//input"),0).sendKeys(path);
        Thread.sleep(1000);
        findElement(By.linkText("确定")).click();
        findElement(By.linkText("完成")).click();
        return this;
    }
}
