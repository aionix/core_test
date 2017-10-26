package stqa.pft.sandbox.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import stqa.pft.sandbox.appmanager.ApplicationManager;

import static org.testng.Assert.fail;

/**
 * Created by Artem.Buchynskyi on 24.10.2017.
 */
public class TestBase {

    protected ApplicationManager app = new ApplicationManager(BrowserType.CHROME);


    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }


}
