package Test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CreationDocument {
    private WebDriver webd;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        webd = new ChromeDriver();
        webd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webd.get("http://172.17.52.10/account/login?ReturnUrl=%2F");
        webd.findElement(By.id("username")).click();
        webd.findElement(By.id("username")).clear();
        webd.findElement(By.id("username")).sendKeys("test-sotnikov");
        webd.findElement(By.id("password")).clear();
        webd.findElement(By.id("password")).sendKeys("12345");
        webd.findElement(By.id("cbrememberme")).click();
        webd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void testCreationDocument() throws Exception {
        webd.findElement(By.xpath("//div[@id='header-title']/a/h1")).click();
        webd.findElement(By.xpath("//ul[@id='topmenu']/li[3]/span")).click();
//        driver.findElement(By.xpath("//a[@href='/DTO_Info_Document/viewlist']")).click();
        webd.findElement(By.linkText("Реестр документов")).click();
        webd.findElement(By.linkText("Создать")).click();
        webd.findElement(By.id("info_document_edit_docno")).click();
        webd.findElement(By.id("info_document_edit_docno")).clear();
        webd.findElement(By.id("info_document_edit_docno")).sendKeys("Тест1");
        webd.findElement(By.xpath("//button[@type='submit']")).click();
        webd.findElement(By.linkText("Назад")).click();
    }

    @After
    public void tearDown() throws Exception {
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