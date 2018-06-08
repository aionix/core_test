package database;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private String      url;
    private Properties  properties = new Properties();
    private Connection  mysqlConnect;

    DBConnection(String url, Properties properties){
        this.url = url;
        this.properties = properties;
    }

    public  void initConnection(){
        if(mysqlConnect == null){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mysqlConnect = DriverManager.getConnection(url, properties);
            System.out.println("DB connected");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }}else System.out.println("already connected");}


    public  void closeConnection(){
        try {mysqlConnect.close();}
        catch (SQLException e) {e.printStackTrace();}}

    public ResultSet query(String query) {
        ResultSet result = null;
        try {
            Statement stmt = mysqlConnect.createStatement();
            result = stmt.executeQuery(query);}
        catch (SQLException e) {e.printStackTrace();}
        return result;
    }

    public void queryDelete(String query) {
        try {
            Statement stmt = mysqlConnect.createStatement();
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {e.printStackTrace();}
    }


}
