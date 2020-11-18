/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hp
 */
public class Mahasiswa {
    private String Nama;
    private String Nim;
    private int Angkatan;
    private String Kode_jurusan;

    public Mahasiswa(String Nama, String Nim, int Angkatan, String Kode_jurusan) {
        this.Nama = Nama;
        this.Nim = Nim;
        this.Angkatan = Angkatan;
        this.Kode_jurusan = Kode_jurusan;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String Nim) {
        this.Nim = Nim;
    }

    public int getAngkatan() {
        return Angkatan;
    }

    public void setAngkatan(int Angkatan) {
        this.Angkatan = Angkatan;
    }

    public String getKode_jurusan() {
        return Kode_jurusan;
    }

    public void setKode_jurusan(String Kode_jurusan) {
        this.Kode_jurusan = Kode_jurusan;
    }
    
    
}
