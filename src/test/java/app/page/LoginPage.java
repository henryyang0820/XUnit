package app.page;

import org.openqa.selenium.By;

/**
 * Created by Prowess on 2019/11/13.
 */
public class LoginPage extends BasePage{
    public HomePage login(String name, String pwd){
        findElement(By.id("com.bravolinks.erp_client:id/et_user")).sendKeys(name);
        findElement(By.id("com.bravolinks.erp_client:id/et_pass")).sendKeys(pwd);
        click(By.id(("com.bravolinks.erp_client:id/bt_login")));
        return new HomePage();
    }
    public String getText(){
        return findElement(By.id("tv_message_content")).getText();
    }
}
