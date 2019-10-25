package model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * NO APTO PARA PRODUCCIÓN
 */
public class DBHandler {

    private Connection con;
    private String DBName;

    public DBHandler() throws SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.setProperty("user", "usuario");
        properties.setProperty("password", "Welcome1");
//        properties.setProperty("useSSL", "false");
//        properties.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");
        //"jdbc:mysql://127.0.0.1:3306/websec19", "usuario", "Welcome1"
        String urlTmp = "jdbc:mysql://127.0.0.1:3306/websec19?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        con = DriverManager.getConnection(urlTmp, properties);
        DBName = con.getMetaData().getDatabaseProductName();

    }

    public Connection getConnection() {
        return con;
    }

    public String getDBName() {
        return DBName;
    }
}
