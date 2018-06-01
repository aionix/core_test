package stqa.pft.sandbox.tests;

import org.testng.ITestContext;
import org.testng.annotations.*;
import stqa.pft.sandbox.appmanager.ApplicationManager;
import stqa.pft.sandbox.listeners.MyTestListener;
import stqa.pft.sandbox.model.BrowserType;
import java.io.IOException;

@Listeners(MyTestListener.class)
public class TestBase {

    protected ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", BrowserType.FIREFOX), System.getProperty("target", "qa"));


    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext context) throws IOException {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void cleanBeforeMethod(){
        if(app.driver != null){
            app.driver.manage().deleteAllCookies();
            app.openLoginPage();
        }

    }



}
