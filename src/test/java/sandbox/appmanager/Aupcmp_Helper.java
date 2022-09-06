package sandbox.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sandbox.model.M_aupcmp;
import sandbox.tables.aupcmp.T_aupcmp;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Aupcmp_Helper extends HelperBase {
    public Aupcmp_Helper(WebDriver webd) {
        super(webd);
    }

    public void fillForm(M_aupcmp m_aupcmp) {

        if (m_aupcmp.getSection() != null) {
            typeDrop(By.xpath("//input[@name='filter']"), m_aupcmp.getSection());                         // Ввод сечения
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='uploadfile']")));      // Ожидание доступности кнопким загрузки файлов - обязательно!!!
        }
        dropDown(By.xpath("//select[@name='busrelation1']"), m_aupcmp.getAup_1());

        if (m_aupcmp.getCheck_aup_2()) {
            click(By.name("checkrelation2"));
            dropDown(By.xpath("//select[@name='busrelation2']"), m_aupcmp.getAup_2());
        }

        dropDown(By.xpath("//select[@name='tpprofile']"), m_aupcmp.getProfile_TP());
    }

    public void setDate(String startDate, String finishDate) {
        type(By.xpath("//input[@id='sectionaupcompare_pp_dperiodfrom']"), startDate);
        type(By.xpath("//input[@id='sectionaupcompare_pp_dperiodto']"), finishDate);
    }

    public void checkDefaultDate() {
        String startDate = webd.findElement(By.xpath("//input[@id='sectionaupcompare_pp_dperiodfrom']")).getDomProperty("value");
        String finishDate = webd.findElement(By.xpath("//input[@id='sectionaupcompare_pp_dperiodto']")).getDomProperty("value");
        LocalDate today = LocalDate.now();
        System.out.println(startDate + " " + finishDate);
        LocalDate preStartDate = today.withDayOfMonth(1).minusMonths(1);
        LocalDate preFinishDate = preStartDate.withDayOfMonth(preStartDate.lengthOfMonth());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if (today.getDayOfMonth() < 20) {
            Assert.assertEquals("Fail START date", preStartDate.format(dateTimeFormatter), startDate);
            Assert.assertEquals("Fail FINISH date", preFinishDate.format(dateTimeFormatter), finishDate);
        } else {
            Assert.assertEquals("Fail START date", today.withDayOfMonth(1).format(dateTimeFormatter), startDate);
            Assert.assertEquals("Fail FINISH date", today.format(dateTimeFormatter), finishDate);
        }
    }

    public void checkDefaultSection() {
        WebElement element = webd.findElement(By.xpath("//div[@id='sectionaupcompare_section_id_selected']/*/span"));
        Assert.assertEquals("", element.getDomProperty("innerText"));
    }

    public void checkDefaultAup1() {
        WebElement element = webd.findElement(By.xpath("//select[@id='sectionaupcompare_busrelation1']"));
        Assert.assertEquals("2", element.getDomProperty("value"));
    }

    public void checkDefaultAup2() {
        WebElement elementAup2 = webd.findElement(By.xpath("//select[@id='sectionaupcompare_busrelation2']"));
        WebElement elementCheckAup2 = webd.findElement(By.xpath("//input[@id='sectionaupcompare_checkrelation2']"));
        if (elementCheckAup2.getDomProperty("checked").equals("false")) {
            Assert.assertEquals("", elementAup2.getDomProperty("value"));
        } else {
            Assert.assertEquals("2", elementAup2.getDomProperty("value"));
        }
    }

    public void checkDefaultCheck_aup_2() {
        WebElement element = webd.findElement(By.xpath("//input[@id='sectionaupcompare_checkrelation2']"));
        Assert.assertEquals("false", element.getDomProperty("checked"));
    }

    public void checkDefaultProfile_TP() {
        WebElement element = webd.findElement(By.xpath("//select[@id='sectionaupcompare_tpprofile']"));
        Assert.assertEquals("0", element.getDomProperty("value"));
    }

    public void checkTable() {

        List<WebElement> tableLine = webd.findElements(By.xpath("//table[@id='sectionaupcompare_filelist']/tbody/tr"));
        List<WebElement> tableRow = webd.findElements(By.xpath("//table[@id='sectionaupcompare_filelist']/tbody/tr[1]/th"));
        System.out.println("Строк: " + tableLine.size());
        System.out.println("Столбцов: " + tableRow.size());
        tableLine.get(1).getText();
        List<T_aupcmp> documents = new ArrayList<>();


        for (int i = 1; i < tableRow.size() + 1; i++) {
            WebElement curentElement = webd.findElement(By.xpath(
                    "//table[@id='sectionaupcompare_filelist']/tbody/tr[1]/th[" + i + "]"));
            System.out.print(curentElement.getText() + " | ");
        }
        System.out.println();
        for (int i = 2; i < tableLine.size()+1; i++) {
            for (int j = 1; j < tableRow.size()+1; j++) {
                WebElement curentlemrnt = webd.findElement(By.xpath(
                        "//table[@id='sectionaupcompare_filelist']/tbody/tr[" + i + "]/td[" + j + "]"));
                System.out.print(curentlemrnt.getText() + " | ");
            }
            System.out.println();
        }

    }
}
