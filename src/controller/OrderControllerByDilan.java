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
import models.Item;
import models.Orders;
import models.OrderDetail;

/*
 * @author Asus
 */
public class OrderControllerByDilan {

//    public boolean addOrder(Orders orders, ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException,IOException {
//        String query = "insert into Orders values('"+orders.getOrderId()+"','"+orders.getUserName()+"','"+orders.getTime()+"','"+orders.getOrderDate()+"',"+orders.getTotalAmount()+","+orders.getDiscountAmount()+")";
//        Connection connection = DBConnection.getDBConnection().getConnection();
//        connection.setAutoCommit(false);
//        try {
//            Statement createStatement = connection.createStatement();
//            int res = createStatement.executeUpdate(query);
//            if (res > 0) {
//                OrderDetailControllerByDilan orderDetailController = new OrderDetailControllerByDilan();
//                boolean addOrderDetail = orderDetailController.addOrderDetail(orderDetailList);
//                if (!addOrderDetail) {
//                    connection.rollback();
//                }
//                return addOrderDetail;
//            }
//            return false;
//        } finally {
//            connection.setAutoCommit(true);
//        }
//    }
    
     public static boolean addOrder(Orders orders, ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException, IOException {
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
                OrderDetailControllerByChule orderDetailController = new OrderDetailControllerByChule();
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

    public Orders searchOrders(String orderId) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where orderId = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, orderId.trim());
        ResultSet rst = prepareStatement.executeQuery();
        if (rst.next()) {
            Orders orders = new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount"));
            return orders;
        }
        return null;
    }
    
    public Orders getDiscountsById(String orderId) throws ClassNotFoundException, SQLException,IOException {
        String query = "select sum(discountAmount) from Orders where orderId = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, orderId.trim());
        ResultSet rst = prepareStatement.executeQuery();
        if (rst.next()) {
            Orders orders = new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount"));
            return orders;
        }
        return null;
    }
    public boolean removeOrders(String orderId) throws ClassNotFoundException, SQLException,IOException {
        String query = "delete from Orders where orderId = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, orderId.trim());
        int rst = prepareStatement.executeUpdate();
        return rst>0;
    }

    public ArrayList<Orders> searchOrdersByUser(String userName) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where userName = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, userName.trim());
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }

    public boolean updateOrderAmount(double newAmount, String orderId) throws ClassNotFoundException, SQLException,IOException {
        String query = "update Orders set totalAmount=? where orderId = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, newAmount);
        prepareStatement.setObject(2, orderId.trim());
        int rst = prepareStatement.executeUpdate();

        return rst > 0;
    }
    public boolean updateDiscountAmount(double newAmount, String orderId) throws ClassNotFoundException, SQLException,IOException {
        String query = "update Orders set discountAmount=? where orderId = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, newAmount);
        prepareStatement.setObject(2, orderId.trim());
        int rst = prepareStatement.executeUpdate();

        return rst > 0;
    }

    public ArrayList<Orders> searchOrdersByDate(String date) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where orderDate = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, date.trim());
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }
    public ArrayList<Orders> searchOrdersByMonth(String year,String month) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where year(orderDate) = ? and month(orderDate)=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, year.trim());
        prepareStatement.setObject(2, month.trim());
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }
    public ArrayList<Orders> searchOrdersByYear(String year) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where year(orderDate) = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, year.trim());        
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }
    
    public double getDiscountsByDate(String date) throws ClassNotFoundException, SQLException,IOException {
        String query = "select sum(discountAmount) from Orders where orderDate = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, date.trim());
        ResultSet rst = prepareStatement.executeQuery();    
        rst.next();
        return rst.getDouble(1);
    }
     public double getDiscountsByMonth(String year,String month) throws ClassNotFoundException, SQLException,IOException {
        String query = "select sum(discountAmount) from Orders where year(orderDate) = ? and month(orderDate) = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, year.trim());
        prepareStatement.setObject(2, month.trim());
        ResultSet rst = prepareStatement.executeQuery();   
        rst.next();
        return rst.getDouble(1);
    }
     public double getDiscountsByYear(String year) throws ClassNotFoundException, SQLException,IOException {
        String query = "select sum(discountAmount) from Orders where year(orderDate) = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, year.trim());        
        ResultSet rst = prepareStatement.executeQuery(); 
        rst.next();
        return rst.getDouble(1);
    }

    public ArrayList<Orders> getAllOrders() throws ClassNotFoundException, SQLException ,IOException{
        String query = "select * from Orders";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }

    public String getNewOrderId() throws ClassNotFoundException, SQLException ,IOException{
        String query = "select orderId from Orders order by orderId desc limit 1 ";
        String lastOrderId = null;
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();
        while (rst.next()) {
            lastOrderId = rst.getString(1);
        }
        if (lastOrderId != null) {
            String number = lastOrderId.substring(2);
            int newNumber = Integer.parseInt(number) + 1;
            String prefix = null;
            if (newNumber <= 9) {
                prefix = "OR000";
            } else if (newNumber > 9 && newNumber <= 99) {
                prefix = "OR00";
            } else if (newNumber > 99 && newNumber <= 999) {
                prefix = "OR0";
            } else {
                prefix = "OR";
            }
            return prefix + newNumber;
        } else {
            return "OR0001";
        }
        
    }
    public ArrayList<OrderDetail> getAllOrderedItemsByDate(String date) throws ClassNotFoundException, SQLException,IOException{
        String sql="select itemCode,supplierPrice,sellingPrice,orderQty,totalPerEachItem from Orders,OrderDetail where Orders.orderId=OrderDetail.orderId and orderDate='"+date.trim()+"' order by itemCode asc";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement statement = conn.createStatement();
        ResultSet executeQuery = statement.executeQuery(sql);
        ArrayList<OrderDetail> itemList=new ArrayList<>();
        while(executeQuery.next()){
            itemList.add(new OrderDetail().setItemCode(executeQuery.getString(1).trim()).setSupplierPrice(executeQuery.getDouble(2)).setSellingPrice(executeQuery.getDouble(3)).setOrderQty(executeQuery.getInt(4)).setTotalPerEachItem(executeQuery.getDouble(5)));
        }
        return itemList;
    }
    public ArrayList<OrderDetail> getAllOrderedItemsByMonth(String year,String month) throws ClassNotFoundException, SQLException,IOException{
        String sql="select itemCode,supplierPrice,sellingPrice,orderQty,totalPerEachItem from Orders,OrderDetail where Orders.orderId=OrderDetail.orderId and year(orderDate)='"+year.trim()+"' and month(orderDate)='"+month+"' order by itemCode asc";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement statement = conn.createStatement();
        ResultSet executeQuery = statement.executeQuery(sql);
        ArrayList<OrderDetail> itemList=new ArrayList<>();
        while(executeQuery.next()){
            itemList.add(new OrderDetail().setItemCode(executeQuery.getString(1).trim()).setSupplierPrice(executeQuery.getDouble(2)).setSellingPrice(executeQuery.getDouble(3)).setOrderQty(executeQuery.getInt(4)).setTotalPerEachItem(executeQuery.getDouble(5)));
        }
        return itemList;
    }
    public ArrayList<OrderDetail> getAllOrderedItemsByYear(String year) throws ClassNotFoundException, SQLException,IOException{
        String sql="select itemCode,supplierPrice,sellingPrice,orderQty,totalPerEachItem from Orders,OrderDetail where Orders.orderId=OrderDetail.orderId and year(orderDate)='"+year.trim()+"' order by itemCode asc";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement statement = conn.createStatement();
        ResultSet executeQuery = statement.executeQuery(sql);
        ArrayList<OrderDetail> itemList=new ArrayList<>();
        while(executeQuery.next()){
            itemList.add(new OrderDetail().setItemCode(executeQuery.getString(1).trim()).setSupplierPrice(executeQuery.getDouble(2)).setSellingPrice(executeQuery.getDouble(3)).setOrderQty(executeQuery.getInt(4)).setTotalPerEachItem(executeQuery.getDouble(5)));
        }
        return itemList;
    }    
    public ArrayList<Orders> getOrdersByDiscount(String date) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where orderDate='"+date+"' and discountAmount>0";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);        
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }
    public ArrayList<Orders> getOrdersByDiscount(String year,String month) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where year(orderDate) = '"+year+"' and month(orderDate) = '"+month+"' and discountAmount>0";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);        
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }
    public ArrayList<Orders> getOrdersByDiscountInYear(String year) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Orders where year(orderDate) = '"+year+"' and discountAmount>0";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);        
        ResultSet rst = prepareStatement.executeQuery();
        ArrayList<Orders> ordersList = new ArrayList<>();
        while (rst.next()) {
            ordersList.add(new Orders(rst.getString("orderId"), rst.getString("userName"), rst.getString("time"), rst.getString("orderDate"), rst.getDouble("totalAmount"),rst.getDouble("discountAmount")));
        }
        return ordersList;
    }
}
