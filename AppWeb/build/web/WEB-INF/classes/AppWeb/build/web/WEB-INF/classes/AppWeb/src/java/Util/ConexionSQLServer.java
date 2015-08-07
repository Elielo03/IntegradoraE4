/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Arakanox
 */
public class ConexionSQLServer {

    // Parametros necesarios
//    private static final String ipAddress = "192.168.75.187\\SQLESPRESS"; //nota: localhost= 127.0.0.1
//    private static final String dbName = "db3deq4";
//    private static final String user = "lo3deq4";
//    private static final String password = "jebR3veR";
//    private static final String service = "1433";
     private static final String ipAddress = "localhost"; //nota: localhost= 127.0.0.1
    private static final String dbName = "LYA";
    private static final String user = "sa";
    private static final String password = "root";
    private static final String service = "1433";
    
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // --------------- DRIVER ERIC -------- FAVOR DE NO BORRAR ----- //
//           String url = "jdbc:sqlserver://" + ipAddress + "\\SQLEXPRESS;databaseName=" + dbName;
//        return DriverManager.getConnection(url, user, password);
     //----------------------------------------------------------------//
      String url = "jdbc:sqlserver://" + ipAddress + ":" + service + ";databaseName=" + dbName;
       return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException {
        Connection con = ConexionSQLServer.getConnection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
}
