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
import java.util.ArrayList;
import models.Item;

/**
 *
 * @author Asus
 */
public class ItemControllerByChule {
    
    public int addItem(Item item) throws ClassNotFoundException, SQLException ,IOException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("Insert into Item value(?,?,?,?,?,?)");
        prepareStatement.setObject(1, item.getItemCode().trim());
        prepareStatement.setObject(2, item.getCatergoryId().trim());
        prepareStatement.setObject(3, item.getItemName().trim());
        prepareStatement.setObject(4, item.getQtyOnHand());
        prepareStatement.setObject(5, item.getSupplierPrice());
        prepareStatement.setObject(6, item.getSellingprice());
        int res = prepareStatement.executeUpdate();
        return res;
    }
    
    public int updateItem(Item item) throws ClassNotFoundException, SQLException,IOException {
        String sql = "Update Item set itemName=?,qtyOnHand=? ,supplierPrice=?,sellingPrice=? where itemCode=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);        
        stm.setObject(1, item.getItemName().trim());
        stm.setObject(2, item.getQtyOnHand());
        stm.setObject(3, item.getSupplierPrice());
        stm.setObject(4, item.getSellingprice());
        stm.setObject(5, item.getItemCode().trim());
        return  stm.executeUpdate();
    } 
    
    public int updateItemPrice(Item item) throws ClassNotFoundException, SQLException,IOException {
        String sql = "Update Item set qtyOnHand=? ,supplierPrice=?,sellingPrice=? where itemCode=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);                
        stm.setObject(1, item.getQtyOnHand());
        stm.setObject(2, item.getSupplierPrice());
        stm.setObject(3, item.getSellingprice());
        stm.setObject(4, item.getItemCode().trim());
        return  stm.executeUpdate();
    }
    
    public Item searchItem(String itemCode) throws ClassNotFoundException, SQLException ,IOException{
        String query = "select * from Item where itemCode = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, itemCode.trim());
        ResultSet rst = prepareStatement.executeQuery();
        if (rst.next()) {
            Item item = new Item(rst.getString("itemCode"), rst.getString("catergoryId"), rst.getString("itemName"), rst.getInt("qtyOnHand"), rst.getDouble("supplierPrice"), rst.getDouble("sellingprice"));
            return item;
        }
        return null;
    }
    
        public Item searchItemByName(String name) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Item where itemName = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, name.trim());
        ResultSet rst = prepareStatement.executeQuery();
        if (rst.next()) {
            Item item = new Item(rst.getString("itemCode"), rst.getString("catergoryId"), rst.getString("itemName"), rst.getInt("qtyOnHand"), rst.getDouble("supplierPrice"), rst.getDouble("sellingprice"));
            return item;
        }
        return null;
    }
    
    public int deleteItem(String itemCode) throws ClassNotFoundException, SQLException,IOException {
        String sql = "Delete from Item where itemCode=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, itemCode.trim());
        return  stm.executeUpdate();
    } 
    
    ////////////Not want/////////////
    
    public boolean updateItemQty(String itemCode,int newQtyOnHand) throws ClassNotFoundException, SQLException ,IOException{
        int res = 0;
        Connection connection = DBConnection.getDBConnection().getConnection();       
            String query = "update Item set qtyOnHand =? where itemCode = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setObject(1, newQtyOnHand);
            prepareStatement.setObject(2, itemCode.trim());
            res = prepareStatement.executeUpdate();
        
        if (res == 1) {            
            return true;
        }
        return false;
    }
    
    public ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Item";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getDouble(5), rst.getDouble(6)));
        }
        return itemList;
    }
    
    public ArrayList<Item> getAllItemsForCategoryID(String categoryID) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Item where catergoryId=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, categoryID.trim());
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getDouble(5), rst.getDouble(6)));
        }
        return itemList;
    }
    
         public String getNewItemId() throws ClassNotFoundException, SQLException ,IOException{
        String query = "select itemCode from Item order by itemCode desc limit 1 ";
        String lastItemId = null;
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();        
        while (rst.next()) {
            lastItemId = rst.getString(1);
        }
        if (lastItemId != null) {
            String number = lastItemId.substring(1);
            int newNumber = Integer.parseInt(number)+1;            
            String prefix = null;
            if (newNumber <= 9) {                
                prefix = "I000";
            } else if (newNumber > 9 && newNumber <=99) {                
                prefix = "I00";
            } else if (newNumber > 99 && newNumber <= 999) {                
                prefix = "I0";
            } else {                
                prefix = "I";
            }
            return prefix + newNumber;
        } else {
            return "I0001";
        }

    }
    
}
