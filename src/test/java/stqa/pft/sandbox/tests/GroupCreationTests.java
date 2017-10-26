package stqa.pft.sandbox.tests;

import org.testng.annotations.*;

import stqa.pft.sandbox.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.navigationHelper.gotoGroupPage();
        app.groupHelper.initGroupCreation();
        app.groupHelper.fillGroupForm(new GroupData("java group2", "asd", "asd"));
        app.groupHelper.submitGroupCreation();
        app.navigationHelper.returnToGroupsPage();
    }

}
