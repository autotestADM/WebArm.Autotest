package sandbox.appmanager;

import com.sun.jdi.Locatable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {
    protected WebDriver webd;
    protected WebDriverWait wait;

    protected HelperBase(WebDriver webd) {
        this.webd = webd;
        this.wait = new WebDriverWait(webd, Duration.ofSeconds(5));
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    protected void click(By locator) {
        webd.findElement(locator).click();
    }

    protected void clickWithWait(By locator) {
        new WebDriverWait(webd, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        click(locator);
    }

    protected void dropDown(By locator, String text) {
//        click(locator);
        if (text != null) {
            new Select(webd.findElement(locator)).selectByValue(text);
        }
    }

    protected void typeDrop(By locator, String text) {
        webd.findElement(locator).sendKeys(text);
        webd.findElement(By.xpath(String.format("//label[contains(text(),'%s')]", text))).click();

    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            webd.findElement(locator).clear();
            webd.findElement(locator).sendKeys(text);
        }
    }

    protected boolean isAlertPresent() {
        try {
            webd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void initCreation() {
        click(By.linkText("Создать"));
    }

    public void submitCreation() {
        click(By.xpath("//button[@type ='submit']"));
    }

    public void goBack() {
        click(By.linkText("Назад"));
    }

    public void search(String text) {
        type(By.xpath("//input[@class='filterInput']"), text);
    }

    public void downloadFile(String nameOfLocator, String pathOfFile) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name(nameOfLocator)));
        WebElement webElement = webd.findElement(By.name(nameOfLocator));
        webElement.sendKeys(pathOfFile);
    }

    public WebDriver getWebd() {
        return webd;
    }
}
