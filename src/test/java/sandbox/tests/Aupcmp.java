package sandbox.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sandbox.model.M_DTO_Info_Document;
import sandbox.model.M_aupcmp;

import java.sql.Time;

/**
 * Сравнение 51020 | Учетного показателя и 51070 (формирование 51075)
 */

public class Aupcmp extends TestBase {

    @Test
    public void testAvailableAllElements(){

    }
    @Test
    public void testDate(){
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().fillForm(new M_aupcmp().withSection("108").withStartDate("01.06.2022").withFinishDate("30.06.2022").withCheck_aup_2(true));
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                "D:\\Work\\IT Energy\\WebArm.Autotest\\Resources\\Testfiles\\NewRegulations\\FMARIENE-PTATENER\\51020_202206_FMARIENE-PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                "D:\\Work\\IT Energy\\WebArm.Autotest\\Resources\\Testfiles\\NewRegulations\\FMARIENE-PTATENER\\51075_4716016979_20220826142646_FMARIENE_PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                "D:\\Work\\IT Energy\\WebArm.Autotest\\Resources\\Testfiles\\NewRegulations\\FMARIENE-PTATENER\\UP_FMARIENE_PTATENER.xls");

    }


}
