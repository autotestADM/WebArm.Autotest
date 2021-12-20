package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver webd;

    public SessionHelper(WebDriver webd) {
        this.webd = webd;
    }
    public void chooseDB(String DB) {
        webd.findElement(By.id("header-title")).click();
        webd.findElement(By.id("header-db")).click();
        webd.findElement(By.linkText(DB)).click();
    }

    public void login(String user, String password) {
        webd.findElement(By.id("username")).click();
        webd.findElement(By.id("username")).clear();
        webd.findElement(By.id("username")).sendKeys(user);
        webd.findElement(By.id("password")).clear();
        webd.findElement(By.id("password")).sendKeys(password);
        webd.findElement(By.id("cbrememberme")).click();
        webd.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
