package stqa.pft.tests.groupsTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import stqa.pft.model.GroupData;
import stqa.pft.tests.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParametrizedTests extends TestBase {

    @Test(dataProvider = "validGroups", groups = "smoke2")
    @Description("creating group with help of Data Provider")
    public void createGroup(GroupData group) {
        app.navigationHelper.gotoGroupPage();
        app.groupHelper.initGroupCreation();
        app.groupHelper.fillGroupForm(group);
        app.groupHelper.submitGroupCreation();
    }

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new GroupData().withName("data-provider1").withHeader("d-provider1 header").withFooter("restExampleBugify")});
        list.add(new Object[]{new GroupData().withName("data-provider2").withHeader("d-provider2 header").withFooter("asd2")});
        return list.iterator();
}

}