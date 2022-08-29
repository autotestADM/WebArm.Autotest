package sandbox.tests;

import org.junit.Test;
import sandbox.model.M_aupcmp;

/**
 * Сравнение 51020 | Учетного показателя и 51070 (формирование 51075)
 */

public class Aupcmp extends TestBase {

    @Test
    public void testAvailableAllElements(){
    }
    @Test
    public void testDownloadFiles(){
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().fillForm(new M_aupcmp().withStartDate("01.06.2022").withFinishDate("30.06.2022").withSection("108"));
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles()+"\\NewRegulations\\FMARIENE-PTATENER\\51020_202206_FMARIENE-PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles()+"\\NewRegulations\\FMARIENE-PTATENER\\51075_4716016979_20220826142646_FMARIENE_PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles()+"\\NewRegulations\\FMARIENE-PTATENER\\UP_FMARIENE_PTATENER.xls");

    }


}
