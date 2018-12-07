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

public class Item {

    private String itemCode;
    private String catergoryId;
    private String itemName;
    private int qtyOnHand;
    private double supplierPrice;
    private double sellingprice;

    public Item() {
    }

    public Item(String itemCode, String catergoryId, String itemName, int qtyOnHand, double supplierPrice, double sellingprice) {
        this.itemCode = itemCode;
        this.catergoryId = catergoryId;
        this.itemName = itemName;
        this.qtyOnHand = qtyOnHand;
        this.supplierPrice = supplierPrice;
        this.sellingprice = sellingprice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public Item setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getCatergoryId() {
        return catergoryId;
    }

    public Item setCatergoryId(String catergoryId) {
        this.catergoryId = catergoryId;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public Item setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public Item setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
        return this;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public Item setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
        return this;
    }

    public double getSellingprice() {
        return sellingprice;
    }

    public Item setSellingprice(double sellingprice) {
        this.sellingprice = sellingprice;
        return this;
    }    
}
