/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package initialize;

import db.DBConnection;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import myFunctionalDetails.DetailForm;
import myFunctionalDetails.FunctionalDetails;

/**
 *
 * @author Manoj Madushanka
 */
public class AutoCreateDatabase {

    private static int result = 0;
    private static String userName = "root";
    private static String password = "mysql";

    public static boolean create() {
        try {
            File file1 = new File("Details.txt");
            if (!file1.exists()) {
                new DetailForm().setVisible(true);
            }
            FunctionalDetails details = new FunctionalDetails();
            if (details.getIPAddress() != null && details.getPortNumber() != null) {
                userName = details.getIPAddress();
                password = details.getPortNumber();
            } else {
                new DetailForm().setVisible(true);
                userName = details.getIPAddress();
                password = details.getPortNumber();
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost", userName, password);
            String sql = "create database Shop";
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            File file = new File("Database.txt");
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                Connection conn = DBConnection.getDBConnection().getConnection();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(line.trim());
                    result++;
                }
                JOptionPane.showMessageDialog(null, "Database is created successfully");
            } else {
                JOptionPane.showMessageDialog(null, "There is no Database.txt", null, JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println(result+" "+ex.getMessage());
            result = 0;
        }        
        return 0 != result;
    }

}
