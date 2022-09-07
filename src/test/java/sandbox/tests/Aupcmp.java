package sandbox.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sandbox.model.M_aupcmp;
import sandbox.tables.aupcmp.T_aupcmp;

import java.time.Duration;
import java.util.List;

/**
 * Сравнение 51020 | Учетного показателя и 51070 (формирование 51075)
 */

public class Aupcmp extends TestBase {

    @Test
    public void testAvailableAllElements() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().checkDefaultDate();
    }

    @Test
    public void checkDefaultSection() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().checkDefaultSection();
    }

    @Test
    public void checkDefaultAup1() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().checkDefaultAup1();
    }


    @Test
    public void checkDefaultCheck_aup_2() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().checkDefaultCheck_aup_2();
    }

    @Test
    public void checkDefaultAup2() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().checkDefaultAup2();
    }

    @Test
    public void checkDefaultProfile_TP() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().checkDefaultProfile_TP();
    }


    @Test
    public void testDownloadFiles() throws InterruptedException {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().setDate("01.06.2022", "30.06.2022");
        app.getAupcmp_helper().fillForm(new M_aupcmp().withSection("108"));
        int tableCountpre = app.getAupcmp_helper().checkTableCount("'sectionaupcompare_filelist'");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles() + "\\NewRegulations\\FMARIENE-PTATENER\\51020_202206_FMARIENE-PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles() + "\\NewRegulations\\FMARIENE-PTATENER\\51075_4716016979_20220826142646_FMARIENE_PTATENER.xml");
        app.getAupcmp_helper().downloadFile(
                "uploadfile",
                app.getPathOfTestFiles() + "\\NewRegulations\\FMARIENE-PTATENER\\UP_FMARIENE_PTATENER.xls");
        Thread.sleep(2000);
//        List<T_aupcmp> fileList = app.getAupcmp_helper().getFileList();
        int tableCountafter = app.getAupcmp_helper().checkTableCount("'sectionaupcompare_filelist'");
        Assert.assertEquals(tableCountpre + 3, tableCountafter);
    }


    @Test
    public void testTable() {
        app.getNavigationHelper().gotoReports("Формирование 51075. Сравнение 51020 и УП");
        app.getAupcmp_helper().setDate("01.06.2022", "30.06.2022");
        app.getAupcmp_helper().fillForm(new M_aupcmp().withSection("108"));
        List<T_aupcmp> fileList = app.getAupcmp_helper().getFileList();
        Assert.assertEquals("51020", fileList.get(0).getTypeOfFile());
        Assert.assertEquals("51075", fileList.get(1).getTypeOfFile());
        Assert.assertEquals("УП", fileList.get(2).getTypeOfFile());
        Assert.assertEquals(app.getAupcmp_helper().checkTableCount("'sectionaupcompare_filelist'"), fileList.size());
    }

}
