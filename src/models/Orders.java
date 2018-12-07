package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavilion 15
 */
public class Orders {
    private String orderId;
    private String userName;
    private String time;
    private String orderDate;    
    private double totalAmount;
    private double discountAmount;

    public double getDiscountAmount() {
        return discountAmount;
    }

    public Orders setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public Orders() {
    }

    public Orders(String orderId, String userName, String date, String time, double total) {
        this.orderId = orderId;
        this.userName = userName;
        this.orderDate = date;
        this.time = time;
        this.totalAmount = total;
    }
    public Orders(String orderId, String userName, String date, String time, double total,double discountAmount) {
        this.orderId = orderId;
        this.userName = userName;
        this.orderDate = date;
        this.time = time;
        this.totalAmount = total;
        this.discountAmount = discountAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Orders setTotal(double total) {
        this.totalAmount = total;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public Orders setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Orders setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Orders setDate(String date) {
        this.orderDate = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Orders setTime(String time) {
        this.time = time;
        return this;
    }        
}
