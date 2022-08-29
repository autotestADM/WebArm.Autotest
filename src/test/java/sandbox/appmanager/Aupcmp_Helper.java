package sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sandbox.model.M_aupcmp;

import java.time.Duration;

public class Aupcmp_Helper extends HelperBase {
    public Aupcmp_Helper(WebDriver webd) {
        super(webd);
    }

    public void fillForm(M_aupcmp m_aupcmp) {

        if (!m_aupcmp.getStartDate().isEmpty() || !m_aupcmp.getFinishDate().isEmpty()) {
            setDate(m_aupcmp);                                                                            // Установка даты
        }

        if (!m_aupcmp.getSection().isEmpty()) {
            typeDrop(By.xpath("//input[@name='filter']"), m_aupcmp.getSection());                         // Ввод сечения
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uploadfile']")));      // Ожидание доступности кнопким загрузки файлов - обязательно!!!
        dropDown(By.xpath("//select[@name='busrelation1']"), m_aupcmp.getAup_1());

        if (m_aupcmp.getCheck_aup_2()) {
            click(By.name("checkrelation2"));
            dropDown(By.xpath("//select[@name='busrelation2']"), m_aupcmp.getAup_2());
        }

        dropDown(By.xpath("//select[@name='tpprofile']"), m_aupcmp.getProfile_TP());
    }

    private void setDate(M_aupcmp m_aupcmp) {
        type(By.xpath("//input[@id='sectionaupcompare_pp_dperiodfrom']"), m_aupcmp.getStartDate());
        type(By.xpath("//input[@id='sectionaupcompare_pp_dperiodto']"), m_aupcmp.getFinishDate());
    }

}
