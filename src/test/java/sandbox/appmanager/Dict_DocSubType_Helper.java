package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sandbox.model.M_Dict_DocSubType;

public class Dict_DocSubType_Helper extends HelperBase {

    public Dict_DocSubType_Helper(WebDriver webd) {
        super(webd);
    }

    public void fillForm(M_Dict_DocSubType docSubType) {
        typeDrop(By.xpath("//input[@name='filter']"), docSubType.getType());
        type(By.xpath("//input[@name='title']"), docSubType.getSubtype());
        dropDown(By.xpath("//select[@name='timezones']"), docSubType.getTimeZone());
        if (!docSubType.getProcessingMethod().isEmpty()) {
            dropDown(By.xpath("//select[@name = 'documentprocessmethodid']"), docSubType.getProcessingMethod());
        }
    }

    public void modificationDocument() {
        click(By.xpath("//*[text()= 'WebDriver'][1]/following::a/i[@title='Редактировать']"));
    }
}
