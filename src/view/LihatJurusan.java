/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author hp
 */
import model.*;
import controller.Controller;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class LihatJurusan implements ActionListener{
    JFrame frame = new JFrame("INSERT JURUSAN");
    JButton insert_jurusan = new JButton("INSERT JURUSAN");
    JButton lihat_jurusan = new JButton("LIHAT JURUSAN");
    JButton insert_mahasiswa = new JButton("INSERT MAHASISWA");
    JLabel labnama = new JLabel("Nama");
    JLabel labkode = new JLabel("Kode");
    JTextField textnama = new JTextField();
    JTextField textkode = new JTextField();
    JButton submit = new JButton("SUBMIT");
    Controller control = new Controller();
    
    public LihatJurusan(){
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        insert_jurusan.setBounds(100, 150, 150, 70);
        lihat_jurusan.setBounds(100, 250, 150, 70);
        insert_mahasiswa.setBounds(100, 350, 150, 70);
        insert_jurusan.addActionListener(this);
        lihat_jurusan.addActionListener(this);
        insert_mahasiswa.addActionListener(this);
        frame.add(insert_jurusan);
        frame.add(lihat_jurusan);
        frame.add(insert_mahasiswa);
        
        labnama.setBounds(400, 200, 100, 20);
        labkode.setBounds(400, 230, 100, 20);
        textnama.setBounds(530, 200, 300, 20);
        textkode.setBounds(530, 230, 300, 20);
        submit.setBounds(550, 280, 100, 50);
        submit.addActionListener(this);
        frame.add(submit);
        frame.add(labnama);
        frame.add(labkode);
        frame.add(textnama);
        frame.add(textkode);
        
        
        
        
        
        
        
        
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "SUBMIT":
                String strnama = textnama.getText();
                String strkode = textkode.getText();
                Jurusan jurus = new Jurusan();
                jurus.setNama(strnama);
                jurus.setKode(strkode);
                boolean insert = control.addJurusan(jurus);
                if(insert == true){
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Jurusan Sudah Di Tambah");
                    new View();
                }
                break;
            case "INSERT JURUSAN": 
                new InsertJurusan();
                frame.setVisible(false);
                break;
            case "LIHAT JURUSAN":
                new LihatJurusan();
                frame.setVisible(false);
                break;
            case "INSERT MAHASISWA":
                new InsertMahasiswa();
                frame.setVisible(false);
                break;
            default:
                break;
        }
    }
}
