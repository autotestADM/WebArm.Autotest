package sandbox.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;

public class ApplicationManager {
    private WebDriver webd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private DocumentHelper documentHelper;
    private String browser = "Ya";

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public ApplicationManager() {
    }

    public void init() {
        if (browser.equals("Ya")) {
            System.setProperty("webdriver.chrome.driver", "tools\\yandexdriver.exe");
        } else if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webd = new ChromeDriver(options);
        webd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webd.get("http://172.17.52.10/account/login?ReturnUrl=%2F");
        documentHelper = new DocumentHelper(webd);
        navigationHelper = new NavigationHelper(webd);
        sessionHelper = new SessionHelper(webd);
        sessionHelper.login("test-sotnikov", "12345");
        sessionHelper.chooseDB("231");

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
