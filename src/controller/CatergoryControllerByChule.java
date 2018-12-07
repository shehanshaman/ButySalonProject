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
import models.Catergory;

/**
 *
 * @author Shermila
 */
public class CatergoryControllerByChule {
    public  int addCatergory(Catergory catergory) throws ClassNotFoundException, SQLException, IOException {
        String sql = "Insert into Catergory values(?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, catergory.getCategeryId().trim());
        stm.setObject(2, catergory.getCatergoryName().trim());
        return  stm.executeUpdate();
        
    }

    public  int updateCatergory(Catergory catergory) throws ClassNotFoundException, SQLException, IOException {
        String sql = "Update Catergory set catergoryName=? where catergoryId=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(2, catergory.getCategeryId().trim());
        stm.setObject(1, catergory.getCatergoryName().trim());
        return  stm.executeUpdate();
    } 

    public int deleteCatergory(String catergoryId) throws ClassNotFoundException, SQLException, IOException {
        String sql = "Delete from Catergory where catergoryId=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, catergoryId.trim());
        return  stm.executeUpdate();
    } 

    public  ArrayList<Catergory> getAllCatergories() throws ClassNotFoundException, SQLException, IOException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select * From Catergory");
        ArrayList<Catergory>catergoryList=new ArrayList<>();
        while(rst.next()){
            Catergory catergory=new Catergory(rst.getString("catergoryId"),rst.getString("catergoryName"));
            catergoryList.add(catergory);
        }
        return catergoryList;
    }

    public Catergory searchCatergory(String catergoryId) throws ClassNotFoundException, SQLException, IOException {
        String sql = "Select * From Catergory where catergoryId=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, catergoryId.trim());
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            Catergory catergory=new Catergory(rst.getString("catergoryId"),rst.getString("catergoryName"));
            return catergory;
        }else{
            return null;
        }
    }
     public String getNewCatergoryId() throws ClassNotFoundException, SQLException, IOException {
        String query = "select catergoryId from Catergory order by catergoryId desc limit 1 ";
        String lastCatergoryId = null;
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        ResultSet rst = prepareStatement.executeQuery();        
        while (rst.next()) {
            lastCatergoryId = rst.getString(1);
        }
        if (lastCatergoryId != null) {
            String number = lastCatergoryId.substring(2);
            int newNumber = Integer.parseInt(number)+1;
            String prefix = null;
            if (newNumber <= 9) {
                prefix = "CT000";
            } else if (newNumber > 9 && newNumber <= 99) {
                prefix = "CT00";
            } else if (newNumber > 99 && newNumber <= 999) {
                prefix = "CT0";
            } else {
                prefix = "CT";
            }
            return prefix + newNumber;
        } else {
            return "CT0001";
        }

    }
}
