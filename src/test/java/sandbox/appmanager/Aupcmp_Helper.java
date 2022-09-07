package sandbox.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sandbox.model.M_aupcmp;
import sandbox.tables.aupcmp.T_aupcmp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Aupcmp_Helper extends HelperBase {
    public Aupcmp_Helper(WebDriver webd) {
        super(webd);
    }

    public void fillForm(M_aupcmp m_aupcmp) {

        if (m_aupcmp.getSection() != null) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='uploadfile']")));      // Ожидание доступности кнопким загрузки файлов - обязательно!!!
            typeDrop(By.xpath("//input[@name='filter']"), m_aupcmp.getSection());                         // Ввод сечения
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='uploadfile']")));      // Ожидание доступности кнопким загрузки файлов - обязательно!!!
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
        List<WebElement> elements = webd.findElements(By.xpath("//select[@name='busrelation1']/option"));
        Assert.assertEquals("2", element.getDomProperty("value"));
        Assert.assertEquals(elements.size(), 3);
        Assert.assertEquals(elements.get(0).getText(), "Профиль АТС");
        Assert.assertEquals(elements.get(1).getText(), "Контрольный ПСИ");
        Assert.assertEquals(elements.get(2).getText(), "Профиль ИА");
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
        List<WebElement> elements = webd.findElements(By.xpath("//select[@name='tpprofile']/option"));
        Assert.assertEquals("0", element.getDomProperty("value"));
        Assert.assertEquals(elements.size(), 2);
        Assert.assertEquals(elements.get(0).getText(), "ОРЭМ");
        Assert.assertEquals(elements.get(1).getText(), "Перспектива");
    }

    public List<T_aupcmp> getFileList() {
        List<WebElement> tableLine = webd.findElements(By.xpath("//table[@id='sectionaupcompare_filelist']/tbody/tr[@tabindex='0']"));
        List<WebElement> tableRow = webd.findElements(By.xpath("//table[@id='sectionaupcompare_filelist']/tbody/tr[1]/th"));
        List<T_aupcmp> documents = new ArrayList<>();


        for (int i = 1; i < tableLine.size() + 1; i++) {
            List<WebElement> oneLine = new ArrayList<>();
            for (int j = 1; j < tableRow.size() + 1; j++) {
                WebElement currentElement = webd.findElement(By.xpath(
                        "//table[@id='sectionaupcompare_filelist']/tbody/tr[@tabindex='0'][" + i + "]/td[" + j + "]"));
                oneLine.add(currentElement);
            }

            T_aupcmp t_aupcmp = new T_aupcmp();
            t_aupcmp.withId(oneLine.get(0).getText());
            t_aupcmp.withTypeOfFile(oneLine.get(1).getText());
            t_aupcmp.withPeriod(oneLine.get(2).getText());
            t_aupcmp.withFile(oneLine.get(3).getText());
            t_aupcmp.withDate(oneLine.get(4).getText());
            t_aupcmp.withUser(oneLine.get(5).getText());
            documents.add(t_aupcmp);
        }

        return documents;
    }

    public int checkTableCount(String tableId) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id=" + tableId + "]/tbody/tr"), 0));
        return webd.findElements(By.xpath("//table[@id=" + tableId + "]/tbody/tr[@tabindex='0']")).size();
    }

    public Boolean checkPeriodOfReport() {
        String startDate = webd.findElement(By.xpath("//input[@id='sectionaupcompare_pp_dperiodfrom']")).getDomProperty("value");
        String finishDate = webd.findElement(By.xpath("//input[@id='sectionaupcompare_pp_dperiodto']")).getDomProperty("value");
        click(By.xpath("//button[@type='submit']"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='periodpicker-readonly']/div")));
        List<WebElement> period = webd.findElements(By.xpath("//div[@class='periodpicker-readonly']/div"));
        return startDate.equals(period.get(0).getText()) && finishDate.equals(period.get(2).getText());
    }
    public String getAlertText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sectionaupcompare_fileerror_form")));
        String alertText = webd.findElement(By.id("sectionaupcompare_fileerror_body")).getText();
        click(By.xpath("//form[@id='sectionaupcompare_fileerror_form']/div/div/div/button"));
        return alertText;
    }
}
