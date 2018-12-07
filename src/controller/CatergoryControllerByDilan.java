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
import models.Catergory;
import models.Item;

/**
 *
 * @author Asus
 */
public class CatergoryControllerByDilan {
    
    public int addCatergory(Catergory catergory) throws ClassNotFoundException, SQLException,IOException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("Insert into Catergory value(?,?)");
        prepareStatement.setObject(1, catergory.getCategeryId().trim());
        prepareStatement.setObject(2, catergory.getCatergoryName().trim());
        int res = prepareStatement.executeUpdate();
        return res;
    }
    
    public Catergory searchCatergory(String catergoryId) throws ClassNotFoundException, SQLException,IOException {
        String query = "select * from Catergory where catergoryId = ?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setObject(1, catergoryId.trim());
        ResultSet rst = prepareStatement.executeQuery();
        if (rst.next()) {
            Catergory catergory = new Catergory(rst.getString("catergoryId"), rst.getString("catergoryName"));
            return catergory;
        }
        return null;
    }
    
}
