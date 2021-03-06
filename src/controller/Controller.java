/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.*;
/**
 *
 * @author hp
 */
public class Controller {
     static DBHandler conn = new DBHandler();
     
     
     public Controller(){
         
     }
     
     public static boolean addJurusan(Jurusan jurus){
        conn.connect();
        String query = "INSERT INTO jurusan VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, jurus.getKode());
            stmt.setString(2, jurus.getNama());
            stmt.executeUpdate();
            return(true);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
    }
     
    
     
     public static ArrayList<Jurusan> getallJurusan(){
        conn.connect();
        ArrayList<Jurusan> jurus = new ArrayList<Jurusan>();
        String query = "SELECT * FROM jurusan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan jur = new Jurusan();
                jur.setKode(rs.getString("kode"));
                jur.setNama(rs.getString("nama"));
                jurus.add(jur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return jurus;
     }
     
     public static Jurusan getJurusan(String kode){
        conn.connect();
        String query = "SELECT * FROM jurusan where kode = '" + kode + "' ";
        Jurusan jur = new Jurusan();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                jur.setKode(rs.getString("kode"));
                jur.setNama(rs.getString("nama"));
                jur.setListMhs(getallMahasiswa(rs.getString("kode")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return jur;
     }
     
     public static boolean addMahasiswa(Mahasiswa mhs){ 
        conn.connect();
        String query = "INSERT INTO mahasiswa VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, mhs.getNim());
            stmt.setString(2, mhs.getNama());
            stmt.setInt(3, mhs.getAngkatan());
            stmt.setString(4, mhs.getKode_jurusan());
            stmt.executeUpdate();
            return(true);  
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
     }
     
     public static ArrayList<Mahasiswa> getallMahasiswa(String kode_mhs){
        conn.connect();
        ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();
        String query = "SELECT * FROM mahasiswa where kode_jurusan = '" + kode_mhs + "' ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mahasiswa mahas = new Mahasiswa();
                mahas.setNim(rs.getString("nim"));
                mahas.setNama(rs.getString("nama"));
                mahas.setAngkatan(Integer.parseInt(rs.getString("angkatan")));
                mahas.setKode_jurusan(rs.getString("nama"));
                mhs.add(mahas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return mhs;
     }
     
}
