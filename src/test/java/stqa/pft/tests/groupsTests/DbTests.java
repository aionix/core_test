package stqa.pft.tests.groupsTests;

import database.MainDBconnect;
import org.testng.annotations.Test;
import stqa.pft.model.GroupData;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbTests {

    @Test
    void getGroupsList() throws SQLException {
        ResultSet rs = MainDBconnect.executeQuery("SELECT * FROM `group_list` where group_name like 'test gr 2018.05.15%'");
        GroupData grFromDb = null;
        while (rs.next()) {
            grFromDb = new GroupData()
                    .withName(rs.getString("group_name")).withHeader(rs.getString("group_header"))
                    .withFooter(rs.getString("group_footer"));
            System.out.println(rs.getString("group_name"));//print out all groups
        }
        System.out.println(grFromDb);
    }
}
