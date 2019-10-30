package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class App {
    public static WebDriver driver;
    public ConTactPage toContact(){
        return new ConTactPage();
    }
    public ConTactPage toAddMember(){
        driver.findElement(By.linkText("添加成员")).click();
        return new ConTactPage();
    }
}
