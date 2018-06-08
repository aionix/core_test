package stqa.pft.tests.groupsTests;

import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import stqa.pft.tests.TestBase;

public class GroupDeletionTests extends TestBase {


  @Test(groups = "smoke")
  @Description("User removes one group, the first one")
  public void testGroupDeletion() {
    app.navigationPage.gotoGroupPage();
    app.groupPage.selectGroup();
    app.groupPage.deleteSelectedGroup();
    app.navigationPage.returnToGroupsPage();
    //Assert.assertEquals("00","123");
    app.navigationPage.logout();
  }



}
