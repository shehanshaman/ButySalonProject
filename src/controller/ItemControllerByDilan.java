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
import models.OrderDetail;

/**
 *
 * @author Asus
 */
public class ItemControllerByDilan {
    
    public int addItem(Item item) throws ClassNotFoundException, SQLException,IOException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("Insert into Item value(?,?,?,?,?)");
        prepareStatement.setObject(1, item.getItemCode().trim());
        prepareStatement.setObject(2, item.getCatergoryId().trim());
        prepareStatement.setObject(3, item.getItemName().trim());
        prepareStatement.setObject(4, item.getQtyOnHand());
        prepareStatement.setObject(5, item.getSupplierPrice());
        prepareStatement.setObject(6, item.getSellingprice());
        int res = prepareStatement.executeUpdate();
        return res;
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
    
    ////////////Not want/////////////
    
    public boolean updateItemQty(String itemCode,int newQtyOnHand) throws ClassNotFoundException, SQLException,IOException {
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
    
    public ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException ,IOException{
        String query = "select * from Item";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new Item(rst.getString("itemCode"), rst.getString("catergoryId"), rst.getString("itemName"), rst.getInt("qtyOnHand"), rst.getDouble("supplierPrice"), rst.getDouble("sellingprice")));
        }
        return itemList;
    }
    
    public ArrayList<Item> getAllItemsFiltered(int qty) throws ClassNotFoundException, SQLException ,IOException{
        String query = "select * from Item where qtyOnHand="+qty+"";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(new Item(rst.getString("itemCode"), rst.getString("catergoryId"), rst.getString("itemName"), rst.getInt("qtyOnHand"), rst.getDouble("supplierPrice"), rst.getDouble("sellingprice")));
        }
        return itemList;
    }
    
}
