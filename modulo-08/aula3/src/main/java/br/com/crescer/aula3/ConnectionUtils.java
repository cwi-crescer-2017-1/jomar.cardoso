package br.com.crescer.aula3;
 

 
import java.sql.Connection;
 
import java.sql.DriverManager;
 
import java.sql.SQLException;
 

 
/**
 
 * @author carloshenrique
 
 */
 
public final class ConnectionUtils {
    
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static final String USER = "AULAJAVA"; 
    private static final String PASS = "AULAJAVA";

 
    private ConnectionUtils() { 
    }

    public static Connection getConnection() throws SQLException { 
        return DriverManager.getConnection(URL, USER, PASS); 
    }
 

 
}
 