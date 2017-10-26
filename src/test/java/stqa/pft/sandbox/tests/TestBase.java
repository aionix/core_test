package stqa.pft.sandbox.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import stqa.pft.sandbox.appmanager.ApplicationManager;

import static org.testng.Assert.fail;

/**
 * Created by Artem.Buchynskyi on 24.10.2017.
 */
public class TestBase {

    public ApplicationManager app = new ApplicationManager(BrowserType.CHROME);


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }


}
