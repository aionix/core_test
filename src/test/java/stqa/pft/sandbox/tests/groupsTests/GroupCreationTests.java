package stqa.pft.sandbox.tests.groupsTests;

import org.testng.annotations.*;

import ru.yandex.qatools.allure.annotations.Description;
import stqa.pft.sandbox.helpers.NumbersGenerator;
import stqa.pft.sandbox.model.GroupData;
import stqa.pft.sandbox.tests.TestBase;

import static stqa.pft.sandbox.helpers.NumbersGenerator.*;


public class GroupCreationTests extends TestBase {

    @Test
    @Description("user creates Group from groups page")
    public void testGroupCreation(){
        app.navigationHelper.gotoGroupPage();
        app.groupHelper.initGroupCreation();
        app.groupHelper.fillGroupForm(new GroupData(getCurrentTime(), "asd", "asd"));
        app.groupHelper.submitGroupCreation();

        app.navigationHelper.returnToGroupsPage();
    }

    //@Test
    public void testGroupCreation2(){
        app.navigationHelper.gotoGroupPage();
        app.groupHelper.initGroupCreation();
        app.groupHelper.fillGroupForm(new GroupData("new", "asd", "asd"));
        app.groupHelper.submitGroupCreation();
        app.navigationHelper.returnToGroupsPage();
    }

    //@Test
    public void loginIE(){
        app.navigationHelper.gotoGroupPage();
    }

}
