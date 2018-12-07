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
import java.util.ArrayList;
import models.ReturnedItems;

/**
 *
 * @author pavilion 15
 */
public class ReturnedItemController {
    public int addReturnedItems(ReturnedItems returnedItems) throws ClassNotFoundException, SQLException,IOException{
        String sql="insert into ReturnedItems values('"+returnedItems.getReturnedId().trim()+"','"+returnedItems.getOrderId().trim()+"','"+returnedItems.getItemCode().trim()+"','"+returnedItems.getReturnDate().trim()+"',"+returnedItems.getReturnedQty()+")";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement createStatement = conn.createStatement();
        return createStatement.executeUpdate(sql);        
    }
    public ArrayList<ReturnedItems> getReturnedItems(String orderId) throws ClassNotFoundException,SQLException,IOException{
        ArrayList<ReturnedItems> returnedItems=new ArrayList<ReturnedItems>();
        String sql="select * from ReturnedItems where orderId='"+orderId.trim()+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement createStatement = conn.createStatement();
        ResultSet executeQuery = createStatement.executeQuery(sql);
        while(executeQuery.next()){
            returnedItems.add(new ReturnedItems(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4), executeQuery.getInt(5)));
        }
        return returnedItems;
    }
    
     public String getNewReturnId() throws ClassNotFoundException, SQLException,IOException {
        String query = "select returnedId from ReturnedItems order by returnedId desc limit 1 ";
        String lastOrderId = null;
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();        
        while (rst.next()) {
            lastOrderId = rst.getString(1);
        }
        if (lastOrderId != null) {
            String number = lastOrderId.substring(2);
            int newNumber = Integer.parseInt(number)+1;
            String prefix = null;
            if (newNumber <= 9) {
                prefix = "R000";
            } else if (newNumber > 9 && newNumber <= 99) {
                prefix = "R00";
            } else if (newNumber > 99 && newNumber <= 999) {
                prefix = "R0";
            } else {
                prefix = "R";
            }
            return prefix + newNumber;
        } else {
            return "R0001";
        }

    }
    
}
