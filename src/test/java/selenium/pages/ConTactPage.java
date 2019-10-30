package selenium.pages;

import org.openqa.selenium.By;

public class ConTactPage {
    public ConTactPage add(String username, String acctid, String phone){
        App.driver.findElement(By.name("username")).sendKeys(username);
        App.driver.findElement(By.name("acctid")).sendKeys(acctid);
        App.driver.findElement(By.name("mobile")).sendKeys(phone);
        return this;
    }

    public void list(){

    }
}
