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
public class Catergory {
    
    private String categeryId;
    private String catergoryName;

    public Catergory() {
    }

    public Catergory(String categeryId, String catergoryName) {
        this.categeryId = categeryId;
        this.catergoryName = catergoryName;
    }

    public String getCatergoryName() {
        return catergoryName;
    }

    public Catergory setCatergoryName(String catergoryName) {
        this.catergoryName = catergoryName;
        return this;
    }

    public String getCategeryId() {
        return categeryId;
    }

    public Catergory setCategeryId(String categeryId) {
        this.categeryId = categeryId;
        return this;
    }            
}
