package stqa.pft.sandbox.tests.groupsTests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import stqa.pft.sandbox.tests.TestBase;

public class GroupDeletionTests extends TestBase {

  @Description("User removes one group, the first one")
  @Test
  public void testGroupDeletion() throws Exception {
    app.navigationHelper.gotoGroupPage();
    app.groupHelper.selectGroup();
    app.groupHelper.deleteSelectedGroup();
    app.navigationHelper.returnToGroupsPage();
    //Assert.assertEquals("00","123");
    app.navigationHelper.logout();
  }



}
