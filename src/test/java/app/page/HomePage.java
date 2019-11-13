package app.page;

import org.openqa.selenium.By;

/**
 * Created by Prowess on 2019/11/13.
 */
public class HomePage extends BasePage{
    public LoginPage loginOut(){
        click(By.id("com.bravolinks.erp_client:id/iv_user_bar"));
        click(By.id("com.bravolinks.erp_client:id/bt_exit_login"));
        return new LoginPage();
    }
}
