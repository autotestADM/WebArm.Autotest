package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver webd) {
        super(webd);
    }

    WebDriverWait webWait = new WebDriverWait(webd, Duration.ofSeconds(10));

    public void gotoRegisterOfDocuments() {
        click(By.xpath("//ul[@id='topmenu']/li[3]/span"));
        clickWithWait(By.linkText("Реестр документов"));

    }

    public void gotoNSI(String locator) {
        click(By.xpath("//ul[@id='topmenu']/li[1]/span"));
        click(By.linkText(locator));
    }

    public void gotoData(String locator) {
        click(By.xpath("//ul[@id='topmenu']/li[2]/span"));
        click(By.linkText(locator));
    }

    public void gotoReports(String locator) {
        click(By.xpath("//ul[@id='topmenu']/li[3]/span"));
        click(By.linkText(locator));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(text(),'Сформировать отчет по сравнению')]")));
    }

    public void gotoPlans(String locator) {
        click(By.xpath("//ul[@id='topmenu']/li[4]/span"));
        click(By.linkText(locator));
    }

    public void gotoIntegration(String locator) {
        click(By.xpath("//ul[@id='topmenu']/li[5]/span"));
        click(By.linkText(locator));
    }


}
