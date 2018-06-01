package stqa.pft.sandbox.tests.groupsTests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Description;
import stqa.pft.sandbox.tests.TestBase;
import utils.FileUtilz;

import java.io.IOException;

public class SoftAssertTests extends TestBase {
//
//    @BeforeClass
//    @Override
//    public void setUp(ITestContext context) {
//    }
//    @BeforeMethod
//    @Override
//    public void cleanBeforeMethod(){
//    }
//    @AfterClass
//    @Override
//    public void tearDown() {
//    }

    @Test(groups = "smoke2")
    @Description("Soft assertions test example")
    public void testSoftAssert(){
        SoftAssert s = new SoftAssert();
        s.assertEquals(2*2, 3);
        s.assertEquals(2*2, 4);
        s.assertEquals(2*2, 5);
        s.assertAll();
        //FileUtilz.takeScreenshotSaveToFolder(app.driver); //screen shot doesn't work this way,-after driver was killed
    }

}
