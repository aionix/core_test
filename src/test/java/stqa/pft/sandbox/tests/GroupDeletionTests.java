package stqa.pft.sandbox.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.navigationHelper.gotoGroupPage();
    app.groupHelper.selectGroup();
    app.groupHelper.deleteSelectedGroup();
    app.navigationHelper.returnToGroupsPage();
    app.navigationHelper.logout();
  }






}
