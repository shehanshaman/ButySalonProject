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
import models.User;

/**
 *
 * @author Asus
 */
public class UserControllerByDilan {
    
    public static int addUser(User user) throws ClassNotFoundException, SQLException,IOException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("Insert into User value(?,?,?)");
        prepareStatement.setObject(1, user.getUserName().trim());
        prepareStatement.setObject(2, user.getPassword().trim());
        prepareStatement.setObject(3, user.getType().trim());
        int res = prepareStatement.executeUpdate();
        return res;
    }
    
    public static int deleteUser(String userName) throws ClassNotFoundException, SQLException,IOException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate("Delete From User where userName='" + userName.trim() + "'");
    }
    
    public  static ArrayList<User>getAllUser() throws ClassNotFoundException, SQLException,IOException{
        DBConnection ob=DBConnection.getDBConnection();
        Connection connection=ob.getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("select * From User");
        ArrayList<User>userList=new ArrayList<>();
        while(rst.next()){
            User user = new User(rst.getString("userName"), rst.getString("password"), rst.getString("type"));
            userList.add(user);
        }
        return userList;
    }
    
    public static int updateUser(User user) throws ClassNotFoundException, SQLException ,IOException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("Update User set password=password(?) where userName=?");
        prepareStatement.setObject(2, user.getUserName().trim());
        prepareStatement.setObject(1, user.getPassword().trim());
        int res = prepareStatement.executeUpdate();
        return res;
    }

    public static User searchUser(String userName) throws ClassNotFoundException, SQLException ,IOException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * From User where userName='" + userName.trim() + "'");
        if (rst.next()) {
            User user = new User(rst.getString("userName"), rst.getString("password"), rst.getString("type"));
            return user;
        } else {
            return null;
        }
    }
}
