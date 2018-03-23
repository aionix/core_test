package stqa.pft.sandbox.tests;

import org.testng.ITestContext;
import org.testng.annotations.*;
import stqa.pft.sandbox.appmanager.ApplicationManager;
import stqa.pft.sandbox.helpers.MyTestListener;
import stqa.pft.sandbox.model.BrowserType;
import java.io.IOException;
import static stqa.pft.sandbox.model.BrowserType.*;

@Listeners(MyTestListener.class)
public class TestBase {

    public ApplicationManager app =
            new ApplicationManager(System
                    .getProperty("browser", BrowserType.CHROME), System.getProperty("target", "qa"));


    @BeforeMethod()
    public void setUp(ITestContext context) throws IOException {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }


}
