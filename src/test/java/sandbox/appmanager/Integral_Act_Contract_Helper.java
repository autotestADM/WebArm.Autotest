package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Integral_Act_Contract_Helper extends HelperBase {

    public Integral_Act_Contract_Helper(WebDriver webd) {
        super(webd);
    }

    public void typeDatePeriod() {
        click(By.xpath("//span[@title='Календарь']"));
        dropDown(By.xpath("//div[@class='drp-calendar left']//select[@class='yearselect']"), "2021");
        dropDown(By.xpath("//div[@class='drp-calendar left']//select[@class='monthselect']"), "0");
        click(By.xpath("//button[text()='Применить']"));
    }
}
