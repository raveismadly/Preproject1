package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    private static DBHelper dbHelper;

    public DBHelper() {
    }

    public static DBHelper getInstanse() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    private static Connection connection;
    private static Properties property = PropertyReader.getProperties("database.properties");
    private static String URL = property.getProperty("url");
    private static String USERNAME = property.getProperty("username");
    private static String PASSWORD = property.getProperty("password");

    public static Connection getConnection() {
//        Properties property = PropertyReader.getProperties("database.properties");
//        String URL = property.getProperty("url");
//        String USERNAME = property.getProperty("username");
//        String PASSWORD = property.getProperty("password");

        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
