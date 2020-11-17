/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Controller {
     static DBHandler conn = new DBHandler();
     
     
     public Controller(){
         
     }
     
     public static boolean addCoba(String id, String nama){
        conn.connect();
        String query = "INSERT INTO coba VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.executeUpdate();
            return(true);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }
     
     
}
