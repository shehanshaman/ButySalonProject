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
public class ReturnedItems {
    private String returnedId;
    private String orderId;
    private String itemCode;
    private String returnDate;
    private int returnedQty;

    public ReturnedItems() {
    }

    public ReturnedItems(String returnedId, String orderId, String itemCode, String returnDate, int returnedQty) {
        this.returnedId = returnedId;
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.returnDate = returnDate;
        this.returnedQty = returnedQty;
    }

    public ReturnedItems setReturnedQty(int returnedQty) {
        this.returnedQty = returnedQty;
        return this;
    }

    public ReturnedItems setReturnedItem(String returnedItem) {
        this.returnedId = returnedItem;
        return this;
    }

    public ReturnedItems setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public ReturnedItems setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public ReturnedItems setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;        
    }

    public String getReturnedId() {
        return returnedId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getReturnedQty() {
        return returnedQty;
    }        
}
