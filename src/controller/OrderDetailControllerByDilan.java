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
import models.OrderDetail;

/*
 * @author Asus
 */

public class OrderDetailControllerByDilan {

    public boolean addOrderDetail(ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException,IOException {
        int res = 0;
        for (OrderDetail orderDetail : orderDetailList) {
            String query = "insert into OrderDetail values(?,?,?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setObject(1, orderDetail.getOrderId().trim());
            prepareStatement.setObject(2, orderDetail.getItemCode().trim());
            prepareStatement.setObject(3, orderDetail.getSupplierPrice());
            prepareStatement.setObject(4, orderDetail.getSellingPrice());
            prepareStatement.setObject(5, orderDetail.getOrderQty());
            prepareStatement.setObject(6, orderDetail.getTotalPerEachItem());
            res += prepareStatement.executeUpdate();
        }
       
        return false;
    }
    
    public static ArrayList<OrderDetail> searchOrderDetail(String orderId) throws ClassNotFoundException, SQLException ,IOException{
        String query = "select * from OrderDetail where orderId = ? ";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, orderId.trim());
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
        while(rst.next()) {
            orderDetailList.add( new OrderDetail(rst.getString("orderId"), rst.getString("itemCode"), rst.getDouble("supplierPrice"), rst.getDouble("sellingPrice"),rst.getInt("orderQty"), rst.getDouble("totalPerEachItem")));
        }
        return orderDetailList;
       
    }
    
    public static boolean removeOrderDetail(String orderId,String itemCode) throws ClassNotFoundException, SQLException ,IOException{
        String query = "delete from OrderDetail where orderId = ? and itemCode=? ";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, orderId.trim());
        prepareStatement.setObject(2, itemCode.trim());
        int rst = prepareStatement.executeUpdate();
        
        return rst>0;       
    }
    public static boolean removeOrderDetail(String orderId) throws ClassNotFoundException, SQLException ,IOException{
        String query = "delete from OrderDetail where orderId = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, orderId.trim());        
        int rst = prepareStatement.executeUpdate();
        
        return rst>0;       
    }
    public static boolean updateOrderDetail(int newQty,double amount, String orderId,String itemCode) throws ClassNotFoundException, SQLException,IOException {
        String query = "update OrderDetail set orderQty=?,totalPerEachItem=? where orderId = ? and itemCode=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, newQty);
        prepareStatement.setObject(2, amount);
        prepareStatement.setObject(3, orderId.trim());
        prepareStatement.setObject(4, itemCode.trim());
        int rst = prepareStatement.executeUpdate();

        return rst > 0;
    }
}
