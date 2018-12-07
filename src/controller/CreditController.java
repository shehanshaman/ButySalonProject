/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Credit;

/**
 *
 * @author pavilion 15
 */
public class CreditController {

    public boolean addCredits(Credit credit) throws ClassNotFoundException, SQLException, IOException {
        String sql = "insert into Credit values('" + credit.getCreditId() + "','" + credit.getOrderId() + "'," + credit.getAmount() + ")";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement createStatement = connection.createStatement();
        int res = createStatement.executeUpdate(sql);
        return res > 0;
    }

    public boolean removeCredits(String orderId) throws ClassNotFoundException, SQLException, IOException {
        String sql = "delete from Credit where orderId='" + orderId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement createStatement = connection.createStatement();
        int res = createStatement.executeUpdate(sql);
        return res > 0;
    }
    public boolean removeAllCredits() throws ClassNotFoundException, SQLException, IOException {
        String sql = "delete from Credit";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement createStatement = connection.createStatement();
        int res = createStatement.executeUpdate(sql);
        return res > 0;
    }
    public boolean deleteAllCredits() throws ClassNotFoundException, SQLException, IOException {
        String sql = "delete from Credit";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement createStatement = connection.createStatement();
        int res = createStatement.executeUpdate(sql);
        return res > 0;
    }
    public double getCredits(String orderId) throws SQLException, ClassNotFoundException, IOException {
        String sql = "select sum(amount) from Credit where orderId='" + orderId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement createStatement = connection.createStatement();
        ResultSet set = createStatement.executeQuery(sql);
        if (set.next()) {
            return set.getDouble(1);
        } else {
            return 0.0;
        }

    }

    public String getNewCreditId() throws ClassNotFoundException, SQLException, IOException {
        String query = "select creditId from Credit order by creditId desc limit 1 ";
        String lastCatergoryId = null;
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();
        while (rst.next()) {
            lastCatergoryId = rst.getString(1);
        }
        if (lastCatergoryId != null) {
            int newNumber = Integer.parseInt(lastCatergoryId.trim()) + 1;
            String prefix = null;
            if (newNumber <= 9) {
                prefix = "000";
            } else if (newNumber > 9 && newNumber <= 99) {
                prefix = "00";
            } else if (newNumber > 99 && newNumber <= 999) {
                prefix = "0";
            } else {
                prefix = "";
            }
            return (prefix + newNumber).trim();
        } else {
            return "0001";
        }
    }
}
