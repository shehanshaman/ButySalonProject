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
import java.sql.SQLException;
import java.util.ArrayList;
import models.OrderDetail;

/*
 * @author Asus
 */

public class OrderDetailControllerByChule {

    public static boolean addOrderDetail(ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException ,IOException{
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
       
        if(res==orderDetailList.size()){
            return true;
        }else{
            return false;
        }
    }
}
