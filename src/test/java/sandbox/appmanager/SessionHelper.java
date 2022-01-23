package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver webd) {
        super(webd);
    }

    public void chooseDB(String DB) {
        click(By.id("header-title"));
//        clickWithWait(By.xpath("//li[@id='header-db']/span/i"));
        click(By.cssSelector("svg.svgicon-header-database > use"));
        clickWithWait(By.linkText(DB));
        webd.navigate().refresh();
    }

    public void login(String user, String password) {
        type(By.id("username"),user);
        type(By.id("password"),password);
        click(By.id("cbrememberme"));
        click(By.xpath("//button[@type='submit']"));
    }
}
