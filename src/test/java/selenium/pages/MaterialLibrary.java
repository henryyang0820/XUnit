package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class MaterialLibrary extends BasePage{
    public MaterialLibrary addPandW(String title) throws InterruptedException {
        System.out.println("todo");
        findElement(By.linkText("图文")).click();
        Thread.sleep(100);
        findElement(By.linkText("添加图文")).click();
        Thread.sleep(1000);
        driver.switchTo().frame("ueditor_0");
        findElement(By.cssSelector(".msg_mpNewsEditor_frameBody")).sendKeys("正文");
        driver.switchTo().defaultContent();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
//        抄的2楼 王不迟 #2
        ((JavascriptExecutor)(driver)).executeScript("arguments[0].scrollTo(0, 500)",findElement(By.id("js_mpNews_editor_wrap"),0));
//        findElement(By.xpath("//*[@id=\"AttachFrame\"]/input")).sendKeys("C:/Users/Administrator/Desktop/DL1A6139.JPG");
        //todo
        findElement(By.name("uploadImageFile")).sendKeys("C:/Users/Administrator/Desktop/DL1A6139.JPG");
        Thread.sleep(2000);
        findElement(By.linkText("完成")).click();
        return this;
    }
}
