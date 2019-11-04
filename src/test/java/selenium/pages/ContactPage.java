package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class ContactPage extends BasePage{
    public ContactPage add(String username, String id, String phone){
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;

    }

    public ContactPage delete(String keyword){
        findElement(By.id("memberSearchInput")).clear();
        findElement(By.id("memberSearchInput")).sendKeys(keyword);
        try{
            waitClickable(By.linkText("编辑"), 2);
        }catch (Exception e){
            System.out.println("not found");
            return this;
        }

        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();

        return this;
    }

    public ContactPage deleteCurrentPage(){
//        findElement(By.cssSelector(".ww_checkbox")).click();
//        Select select=new Select(findElement(By.cssSelector(".ww_checkbox")));
//        select.getFirstSelectedOption().click();
//        select.selectByIndex(0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitClickable(By.cssSelector(".ww_checkbox"));
        List<WebElement> elements=driver.findElements(By.cssSelector(".ww_checkbox"));
        for(int i=1;i<elements.size();i++){
            System.out.println(i);
            elements.get(i).click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }

    public void importFromFile(String path){
        findElement(By.partialLinkText("批量导入/导出")).click();
        findElement(By.linkText("文件导入")).click();
        findElement(By.id("js_upload_file_input"), 0).sendKeys(path);
        findElement(By.id("submit_csv")).click();
        findElement(By.linkText("完成")).click();
    }

    public void list(){

    }

    public HashMap<String, String> getUserInfo(String keyword){
        //todo:
        return new HashMap<>();
    }

    public ContactPage addDept(String name){
        findElement(By.cssSelector(".jstree-contextmenu-hover")).click();
        findElement(By.cssSelector(".vakata-context-hover > a")).click();
        findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        findElement(By.linkText("确定")).click();
        return this;
    }

    public ContactPage delDept(){
        //先点下外面大的,再点竖的三个点
        findElement((By.xpath("//li/ul/li[2]/a"))).click();
        findElement((By.xpath("//li[2]/a/span"))).click();
        findElement(By.xpath("(//a[contains(text(),'删除')])[3]")).click();
        findElement(By.linkText("确定")).click();
        return this;
    }

    public ContactPage promotePerson(){
        findElement(By.linkText("田猫科技")).click();
        findElement(By.xpath("//li/a/span")).click();
        findElement(By.xpath("(//a[contains(text(),'设置上级')])[2]")).click();
        findElement(By.linkText("杨晓龙")).click();

        findElement((By.xpath("//a[contains(.,'确认')]"))).click();
        return this;
    }

    public ContactPage updateDept(String name ){
        findElement(By.linkText("田猫科技")).click();
        findElement(By.cssSelector(".jstree-contextmenu-hover")).click();
        findElement(By.xpath("(//a[contains(text(),'修改名称')])[2]")).click();
        findElement(By.xpath("//input[@name='name']")).sendKeys(name);
        findElement(By.linkText("保存")).click();
        return this;
    }
}
