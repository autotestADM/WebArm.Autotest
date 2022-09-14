package sandbox.appmanager;

import com.sun.jdi.Locatable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HelperBase {
    protected WebDriver webd;
    protected WebDriverWait wait;

    protected HelperBase(WebDriver webd) {
        this.webd = webd;
        this.wait = new WebDriverWait(webd, Duration.ofSeconds(5),Duration.ofMillis(1000L));
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
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
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement webElement = webd.findElement(locator);
        webElement.sendKeys(text);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//label[contains(text(),'%s')]", text))));
        webd.findElement(By.xpath(String.format("//label[contains(text(),'%s')]", text))).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void type(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
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
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(By.name(nameOfLocator))));
        wait.until(ExpectedConditions.elementToBeClickable(By.name(nameOfLocator)));
        WebElement webElement = webd.findElement(By.name(nameOfLocator));
        webElement.sendKeys(pathOfFile);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.name(nameOfLocator)));
    }
    public WebDriver getWebd() {
        return webd;
    }
}
