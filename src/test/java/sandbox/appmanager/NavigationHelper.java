package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver webd;

    public NavigationHelper(WebDriver webd) {
        this.webd = webd;
    }

    public void gotoRegisterOfDocuments() {
        webd.findElement(By.xpath("//ul[@id='topmenu']/li[3]/span")).click();
//        driver.findElement(By.xpath("//a[@href='/DTO_Info_Document/viewlist']")).click();
        webd.findElement(By.linkText("Реестр документов")).click();
    }
}
