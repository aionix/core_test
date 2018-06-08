package stqa.pft.tests.groupsTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import stqa.pft.model.GroupData;
import stqa.pft.tests.TestBase;
import utils.FileUtilz;

import static utils.NumbersGenerator.*;


public class GroupCreationTests extends TestBase {

    @Test(groups = "smoke")
    @Description("user creates Group from groups page")
    public void testGroupCreation(){
        app.navigationHelper.gotoGroupPage();
        app.groupHelper.initGroupCreation();
        app.groupHelper.fillGroupForm(new GroupData()
                .withName("test gr "+getCurrentTime()).withHeader("head").withFooter("foot"));
        app.groupHelper.submitGroupCreation();
    }

    @Test(groups = "smoke")
    @Description("user creates Group from groups page")
    public void testGroupCreation2(){
        app.navigationHelper.gotoGroupPage();
        app.groupHelper.initGroupCreation();
        app.groupHelper.fillGroupForm(new GroupData()
                .withName("test gr - TO FAIL").withHeader("head").withFooter("foot"));
        app.groupHelper.submitGroupCreation();
        Assert.assertEquals("00","123");
    }

    @Test(groups = "smoke2")
    @Description("user creates")
    public void attachePic(){
        app.navigationHelper.gotoGroupPage();
        app.driver.findElement(By.linkText("add new")).click();
        app.driver.findElement(By.name("firstname")).sendKeys("with-pic"+getCurrentTime());

        app.driver.findElement(By.cssSelector("input[type=file]")).sendKeys(FileUtilz.getFilePath("pic2.jpg"));
        app.driver.findElement(By.xpath("//input[@name='submit'][1]")).click();

    }

}
