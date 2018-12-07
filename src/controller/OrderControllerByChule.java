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
import models.Orders;
import models.OrderDetail;

/*
 * @author Asus
 */

public class OrderControllerByChule {

   public boolean addOrder(Orders orders, ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException,IOException {
        String query = "insert into Orders values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        connection.setAutoCommit(false);
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setObject(1, orders.getOrderId().trim());
            prepareStatement.setObject(2, orders.getUserName().trim());
            prepareStatement.setObject(3, orders.getTime().trim());
            prepareStatement.setObject(4, orders.getOrderDate().trim());
            prepareStatement.setObject(5, orders.getTotalAmount());
            prepareStatement.setObject(6, orders.getDiscountAmount());
            int res = prepareStatement.executeUpdate();
            if (res > 0) {
                OrderDetailControllerByDilan orderDetailController = new OrderDetailControllerByDilan();
                boolean addOrderDetail = orderDetailController.addOrderDetail(orderDetailList);
                if (!addOrderDetail) {
                    connection.rollback();
                }
                return addOrderDetail;
            }
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
