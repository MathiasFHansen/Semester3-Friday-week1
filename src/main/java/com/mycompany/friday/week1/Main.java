/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.friday.week1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author didas
 */
public class Main {

    public static ArrayList<String> getAllUserFirstNames() throws SQLException, ClassNotFoundException {
        ArrayList<String> userFirstNames = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT fname FROM usertable";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("fname");

                userFirstNames.add(name);
            }
            return userFirstNames;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userFirstNames;
    }

    public static User getUserDetails(int id) throws ClassNotFoundException, SQLException {
        User user = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM usertable WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next())  {
            user = new User(rs.getInt("id"), rs.getString("fname"),rs.getString("lname"), rs.getString("pw"), rs.getString("phone"), rs.getString("address"));
            
            }
                

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static String editDetails(String info, String update, int id) throws SQLException, ClassNotFoundException {
        String name = "";
        try (Connection con = Connector.connection()) {
            String SQL = "UPDATE usertable SET ? = ? WHERE id = ?;";
            
            try (PreparedStatement ps = con.prepareStatement(SQL)){
                ps.setString(1, "info");
                ps.setString(2, "update");
                ps.setString(3, "id");   
                ps.executeQuery();
            }
            catch (SQLException ex) {               
            }
            try {
                String SQL2 = "SELECT ? FROM usertable WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(SQL2);
                ps.setString(1, info);
                ps.setInt(2, id);
                ResultSet rs = ps.executeQuery();
               
                while (rs.next()){
                    name = rs.getString(info);
                }
            }
            catch (SQLException ex){
                
            }
        } catch (SQLException ex) {
            
        }
        return name;
    }
    
    
    
}
