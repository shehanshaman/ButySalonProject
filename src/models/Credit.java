/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author pavilion 15
 */
public class Credit {
    private String creditId;
    private String orderId;
    private double amount;

    public Credit() {
    }

    public Credit(String creditId, String orderId, double amount) {
        this.creditId = creditId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Credit setCreditId(String creditId) {
        this.creditId = creditId;
        return this;
    }

    public Credit setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Credit setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getCreditId() {
        return creditId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }        
}
