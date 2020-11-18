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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    Controller control = new Controller();
    JLabel labjur = new JLabel("Jurusan");
    JButton submit = new JButton("SUBMIT");
    ArrayList<Jurusan> jurus;
    String[] listjurus;
    JComboBox jurusan;

    
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
        
        jurus = control.getallJurusan();
        
        listjurus = new String[jurus.size()];
        for(int i = 0; i < jurus.size(); i++){
            Jurusan jurs = jurus.get(i);
            listjurus[i] = jurs.getKode();
        }
        
        jurusan = new JComboBox(listjurus);
        labjur.setBounds(400, 300, 100, 20);
        jurusan.setBounds(510, 300, 100, 20);
        submit.setBounds(480, 380, 100, 70);
        submit.addActionListener(this);
        
        frame.add(jurusan);
        frame.add(labjur);
        frame.add(submit);
        
                
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "SUBMIT":
                Jurusan jurs = control.getJurusan(String.valueOf(jurusan.getSelectedItem()));
                new LihatMahasiswa(jurs);
                frame.setVisible(false);
                System.out.println("Sudah Disini");
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
