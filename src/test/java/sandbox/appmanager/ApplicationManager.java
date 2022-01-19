package sandbox.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    private WebDriver webd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private DocumentHelper documentHelper;


    public void init() {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        webd = new ChromeDriver();
        webd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webd.get("http://172.17.52.10/account/login?ReturnUrl=%2F");
        documentHelper = new DocumentHelper(webd);
        navigationHelper = new NavigationHelper(webd);
        sessionHelper = new SessionHelper(webd);
        sessionHelper.login("test-sotnikov", "12345");
//        sessionHelper.chooseDB("231");

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
