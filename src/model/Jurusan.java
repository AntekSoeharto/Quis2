/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hp
 */


public class Jurusan {
    private String Kode;
    private String Nama;
    private ArrayList<Mahasiswa> listMhs = new ArrayList<Mahasiswa>();
    
    public Jurusan(){
        
    }

    public Jurusan(String Kode, String Nama, ArrayList<Mahasiswa> listMhs) {
        this.Kode = Kode;
        this.Nama = Nama;
        this.listMhs = listMhs;
    }

    public String getKode() {
        return Kode;
    }

    public void setKode(String Kode) {
        this.Kode = Kode;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public ArrayList<Mahasiswa> getListMhs() {
        return listMhs;
    }

    public void setListMhs(ArrayList<Mahasiswa> listMhs) {
        this.listMhs = listMhs;
    }
    
    
}
