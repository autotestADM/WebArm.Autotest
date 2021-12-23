package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected WebDriver webd;

    public HelperBase(WebDriver webd) {
        this.webd = webd;
    }

    protected void click(By locator) {
        webd.findElement(locator).click();
    }

    protected void dropDown(By locator, String text) {
        click(locator);
        if (text != null) {
            new Select(webd.findElement(locator)).selectByVisibleText(text);
        }
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            webd.findElement(locator).clear();
            webd.findElement(locator).sendKeys(text);
        }
    }

    public boolean isAlertPresent() {
        try {
            webd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
