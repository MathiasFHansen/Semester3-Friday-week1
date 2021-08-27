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

}
