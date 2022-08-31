package sandbox.tests;

import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import sandbox.model.M_aupcmp;

/**
 * Сравнение 51020 | Учетного показателя и 51070 (формирование 51075)
 */

public class Aupcmp extends TestBase {

    @Test
    public void testAvailableAllElements() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
//        app.getAupcmp_helper().fillForm(new M_aupcmp().withSection("108"));
        app.getAupcmp_helper().checkDefaultDate();
        app.getAupcmp_helper().checkDefaultSection();
        app.getAupcmp_helper().checkDefaultAup1();
        app.getAupcmp_helper().checkDefaultCheck_aup_2();
        app.getAupcmp_helper().checkDefaultAup2();
        app.getAupcmp_helper().checkDefaultProfile_TP();

    }

    @Test
    public void testDownloadFiles() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().setDate("01.06.2022","30.06.2022");
        app.getAupcmp_helper().fillForm(new M_aupcmp().withSection("108"));
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles() + "\\NewRegulations\\FMARIENE-PTATENER\\51020_202206_FMARIENE-PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles() + "\\NewRegulations\\FMARIENE-PTATENER\\51075_4716016979_20220826142646_FMARIENE_PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles() + "\\NewRegulations\\FMARIENE-PTATENER\\UP_FMARIENE_PTATENER.xls");
    }


}
