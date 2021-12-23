package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver webd) {
        super(webd);
    }

    public void gotoRegisterOfDocuments() {
        click(By.xpath("//ul[@id='topmenu']/li[3]/span"));
//        driver.findElement(By.xpath("//a[@href='/DTO_Info_Document/viewlist']")).click(); - другой способ поиска локатора
        click(By.linkText("Реестр документов"));
    }
}
