package sandbox.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {
    private WebDriver webd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private DocumentHelper documentHelper;
    private Dict_DocSubType_Helper docSubType_helper;
    private Integral_Act_Contract_Helper integralActContractHelper;
    private Aupcmp_Helper aupcmp_helper;
    private String browser = "Ya";


    public String getPathOfTestFiles() {
        return "D:\\Work\\IT Energy\\WebArm.Autotest\\Resources\\Testfiles";
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public ApplicationManager() {
    }

    public Dict_DocSubType_Helper getDocSubType_helper() {
        return docSubType_helper;
    }

    public Integral_Act_Contract_Helper getIntegralActContractHelper() {
        return integralActContractHelper;
    }

    public Aupcmp_Helper getAupcmp_helper() {
        return aupcmp_helper;
    }

    public void init() {
        if (browser.equals("Ya")) {
            System.setProperty("webdriver.chrome.driver", "Resources\\yandexdriver.exe");
        } else if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webd = new ChromeDriver(options);
        webd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webd.get("http://172.17.52.10/account/login?ReturnUrl=%2F");
        documentHelper = new DocumentHelper(webd);
        navigationHelper = new NavigationHelper(webd);
        docSubType_helper = new Dict_DocSubType_Helper(webd);
        integralActContractHelper = new Integral_Act_Contract_Helper(webd);
        aupcmp_helper = new Aupcmp_Helper(webd);
        sessionHelper = new SessionHelper(webd);
        sessionHelper.login("test-sotnikov", "12345");
        sessionHelper.chooseDB("235");

    }

    public void stop() {
        webd.quit();
    }

    public DocumentHelper getDocumentHelper() {
        return documentHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }


}
