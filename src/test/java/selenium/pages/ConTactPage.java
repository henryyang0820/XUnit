package selenium.pages;

import org.openqa.selenium.By;

public class ConTactPage extends BasePage{
    public ConTactPage add(String username, String acctid, String phone){
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(acctid);
        findElement(By.name("mobile")).sendKeys(phone);
        return this;
    }

    public void list(){

    }
}
