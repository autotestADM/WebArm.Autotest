package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver webd) {
        super(webd);
    }

    public void gotoRegisterOfDocuments() {
        click(By.xpath("//ul[@id='topmenu']/li[3]/span"));
        clickWithWait(By.linkText("Реестр документов"));
//        clickWithWait(By.xpath("//a[@href='/DTO_Info_Document/viewlist']"));
    }


}
