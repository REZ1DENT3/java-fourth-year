package net.babichev.libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

public class DataBase {

    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String MAX_POOL = "250";

    protected static int dbPort;
    protected static String dbName;
    protected static String dbHost;
    protected static String dbLogin;
    protected static String dbPassword;

    public static int getDbPort() {
        return dbPort;
    }

    public static void setDbPort(int dbPort) {
        DataBase.dbPort = dbPort;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        DataBase.dbName = dbName;
    }

    public static String getDbHost() {
        return dbHost;
    }

    public static void setDbHost(String dbHost) {
        DataBase.dbHost = dbHost;
    }

    public static String getDbLogin() {
        return dbLogin;
    }

    public static void setDbLogin(String dbLogin) {
        DataBase.dbLogin = dbLogin;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static void setDbPassword(String dbPassword) {
        DataBase.dbPassword = dbPassword;
    }

    public static String dbUrl() {
        return "jdbc:mysql://" + getDbHost() + ":" + getDbPort() + "/" + getDbName();
    }

    private Connection connection;
    private Properties properties;

    public DataBase(String dbName, String dbHost, int dbPort, String dbLogin, String dbPassword) {
        setDbName(dbName);
        setDbHost(dbHost);
        setDbPort(dbPort);
        setDbLogin(dbLogin);
        setDbPassword(dbPassword);
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", getDbLogin());
            properties.setProperty("password", getDbPassword());
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(dbUrl(), getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
