package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver webd) {
        super(webd);
    }

    public void chooseDB(String DB) {
        click(By.id("header-title"));
        click(By.id("header-db"));
        click(By.linkText(DB));
    }

    public void login(String user, String password) {
        type(By.id("username"),user);
        type(By.id("password"),password);
        click(By.id("cbrememberme"));
        click(By.xpath("//button[@type='submit']"));
    }
}
