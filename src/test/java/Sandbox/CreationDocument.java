package Sandbox;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class CreationDocument {
    private WebDriver webd;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        webd = new ChromeDriver();
        webd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webd.get("http://172.17.52.10/account/login?ReturnUrl=%2F");
        login("test-sotnikov", "12345");
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

    @Test
    public void testCreationDocument() {
        gotoRegisterOfDocuments();
        initDocumentCreation();
        fillDocumentForm(new DocData("Отклонения (инициативы)", "Тест1"));
        submitDocumentCreation();
        returnRegisterofDocuments();
    }

    private void returnRegisterofDocuments() {
        webd.findElement(By.linkText("Назад")).click();
    }

    private void submitDocumentCreation() {
        webd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private void fillDocumentForm(DocData docData) {
        webd.findElement(By.id("info_document_edit_docno")).click();
        webd.findElement(By.id("info_document_edit_docno")).clear();
        webd.findElement(By.id("info_document_edit_docno")).sendKeys(docData.numberOfDdocument());
        webd.findElement(By.id("info_document_edit_doctype_id")).click();
        new Select(webd.findElement(By.id("info_document_edit_doctype_id"))).selectByVisibleText(docData.typeOfDocument());
    }

    private void initDocumentCreation() {
        webd.findElement(By.linkText("Создать")).click();
    }

    private void gotoRegisterOfDocuments() {
        webd.findElement(By.xpath("//ul[@id='topmenu']/li[3]/span")).click();
//        driver.findElement(By.xpath("//a[@href='/DTO_Info_Document/viewlist']")).click();
        webd.findElement(By.linkText("Реестр документов")).click();
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