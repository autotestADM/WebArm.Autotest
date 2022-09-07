package sandbox.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import sandbox.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() throws Exception {
        app.init();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        app.stop();
    }

}
