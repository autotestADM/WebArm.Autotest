package Sandbox;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestBase {
    protected WebDriver webd;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        webd = new ChromeDriver();
        webd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webd.get("http://172.17.52.10/account/login?ReturnUrl=%2F");
        login("test-sotnikov", "12345");
//        chooseDB("231");
    }

    private void chooseDB(String DB) {
        webd.findElement(By.id("header-title")).click();
        webd.findElement(By.id("header-db")).click();
        webd.findElement(By.linkText(DB)).click();
    }

    private void login(String user, String password) {
        webd.findElement(By.id("username")).click();
        webd.findElement(By.id("username")).clear();
        webd.findElement(By.id("username")).sendKeys(user);
        webd.findElement(By.id("password")).clear();
        webd.findElement(By.id("password")).sendKeys(password);
        webd.findElement(By.id("cbrememberme")).click();
        webd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    protected void returnRegisterofDocuments() {
        webd.findElement(By.linkText("Назад")).click();
    }

    protected void submitDocumentCreation() {
        webd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    protected void fillDocumentForm(DocData docData) {
        webd.findElement(By.id("info_document_edit_docno")).click();
        webd.findElement(By.id("info_document_edit_docno")).clear();
        webd.findElement(By.id("info_document_edit_docno")).sendKeys(docData.numberOfDdocument());
        webd.findElement(By.id("info_document_edit_doctype_id")).click();
        new Select(webd.findElement(By.id("info_document_edit_doctype_id"))).selectByVisibleText(docData.typeOfDocument());
    }

    protected void initDocumentCreation() {
        webd.findElement(By.linkText("Создать")).click();
    }

    protected void gotoRegisterOfDocuments() {
        webd.findElement(By.xpath("//ul[@id='topmenu']/li[3]/span")).click();
//        driver.findElement(By.xpath("//a[@href='/DTO_Info_Document/viewlist']")).click();
        webd.findElement(By.linkText("Реестр документов")).click();
    }

    protected void deleteDocument() {
        webd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                "'ТЕСТ Сотников Александр Игоревич'])[2]/following::*[name()='svg'][2]")).click();
        webd.findElement(By.id("deletebtn")).click();
    }

    @After
    public void tearDown() {
        webd.quit();
    }

    private boolean isAlertPresent() {
        try {
            webd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
