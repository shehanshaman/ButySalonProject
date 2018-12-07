/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import myFunctionalDetails.FunctionalDetails;

/**
 *
 * @author Asus
 */
public class DBConnection {

    private static DBConnection dBConnection;
    private Connection conn;
    private String userName = "root";
    private String password = "mysql";

    private DBConnection() throws ClassNotFoundException, SQLException, IOException {
        FunctionalDetails details = new FunctionalDetails();
        if (details.getIPAddress() != null && details.getPortNumber() != null) {
            userName = details.getIPAddress();
            password = details.getPortNumber();
        }
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/Shop", userName, password);
    }

    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException, IOException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public Connection getConnection() {
        return conn;
    }
}
