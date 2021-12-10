package Test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class FirstTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void test() throws Exception {
        driver.get("http://172.17.52.10/account/login?ReturnUrl=%2F");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test-sotnikov");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("cbrememberme")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@id='header-title']/a/h1")).click();
        driver.findElement(By.xpath("//ul[@id='topmenu']/li[3]/span")).click();
//        driver.findElement(By.xpath("//a[@href='/DTO_Info_Document/viewlist']")).click();
        driver.findElement(By.linkText("Реестр документов")).click();
        driver.findElement(By.linkText("Создать")).click();
        driver.findElement(By.id("info_document_edit_docno")).click();
        driver.findElement(By.id("info_document_edit_docno")).clear();
        driver.findElement(By.id("info_document_edit_docno")).sendKeys("Тест1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("Назад")).click();
    }

//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
}