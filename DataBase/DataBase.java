package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class DataBase {
   private static final String URL = "jdbc:mysql://127.0.0.1:3306/agricultural_production";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnetion() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } 
}
