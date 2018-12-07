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
public class OrderDetail {
    private String orderId;
    private String itemCode;
    private double supplierPrice;
    private double sellingPrice;
    private int orderQty;
    private double totalPerEachItem;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String itemCode, double supplierPrice, double sellingPrice, int orderQty, double totalPerEachItem) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.orderQty = orderQty;
        this.totalPerEachItem = totalPerEachItem;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderDetail setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public OrderDetail setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public OrderDetail setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
        return this;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public OrderDetail setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public OrderDetail setOrderQty(int orderQty) {
        this.orderQty = orderQty;
        return this;
    }

    public double getTotalPerEachItem() {
        return totalPerEachItem;
    }

    public OrderDetail setTotalPerEachItem(double totalPerEachItem) {
        this.totalPerEachItem = totalPerEachItem;
        return this;
    }   
}
