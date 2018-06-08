package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Art on 03.04.2018.
 */
public class MainDBconnect {

    static String selAllGroups =         "Select * from group_list";
    static String selArtForTestUser =   "SELECT * FROM `user` WHERE email='artyomfortest@gmail.com'";
    final static String localUrl = "jdbc:mysql://localhost:3306/addressbook";

    public static void main(String[] args) {
        selectUsers(selAllGroups);
    }

     static Properties initProps(){
        Properties properties = new Properties();
        properties.setProperty("user",              "root");
        properties.setProperty("password",          "");
        properties.setProperty("characterEncoding", "UTF-8");
        properties.setProperty("useUnicode",        "true");
        return properties;
    }

    public static void printOutFromUsers(ResultSet resultSet){
        try {
            while (resultSet.next()) {
                String  email     = resultSet.getString("group_id");
                String  firstName = resultSet.getString("group_name");
                System.out.println(email    + "  :     " +  firstName);
            }}
        catch (SQLException e) {e.printStackTrace();}
    }

    public static void selectUsers(String query){
        DBConnection connectDb = new DBConnection(localUrl, initProps());
        connectDb.initConnection();
        ResultSet queryResult = connectDb.query(query);
        printOutFromUsers(queryResult);
        connectDb.closeConnection();
    }

    public static ResultSet executeQuery (String query) {
        ResultSet resultSet;
        DBConnection connectDb = new DBConnection(localUrl, initProps());
        connectDb.initConnection();
         resultSet = connectDb.query(query);
        return resultSet;

        //connectDb.closeConnection();
    }

}



