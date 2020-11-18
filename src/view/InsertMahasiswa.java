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

public class InsertMahasiswa implements ActionListener{
    JFrame frame = new JFrame("INSERT MAHASISWA");
    JButton insert_jurusan = new JButton("INSERT JURUSAN");
    JButton lihat_jurusan = new JButton("LIHAT JURUSAN");
    JButton insert_mahasiswa = new JButton("INSERT MAHASISWA");
    JLabel labnama = new JLabel("Nama");
    JLabel labkode = new JLabel("Kode Jurusan");
    JLabel labnim = new JLabel("NIM");
    JLabel labangkatan = new JLabel("Angkatan");
    JTextField textnim = new JTextField();
    JTextField textangkatan = new JTextField();
    JTextField textnama = new JTextField();
    JButton submit = new JButton("SUBMIT");
    Controller control = new Controller();
    ArrayList<Jurusan> jurus = control.getallJurusan();
    String[] jur;
    JComboBox Jurusan;
    
    
    public InsertMahasiswa(){
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
        
        jur = new String[jurus.size()];
        for(int i = 0; i < jurus.size(); i++ ){
            Jurusan jurs = jurus.get(i);
            jur[i] = jurs.getKode();
            System.out.println(jur[i]);
        }
        
        Jurusan = new JComboBox(jur);
        labnim.setBounds(400, 200, 100, 20);
        labnama.setBounds(400, 230, 100, 20);
        labangkatan.setBounds(400, 260, 100, 20);
        labkode.setBounds(400, 290, 100, 20);
        textnim.setBounds(530, 200, 300, 20);
        textnama.setBounds(530, 230, 300, 20);
        textangkatan.setBounds(530, 260, 300, 20);
        Jurusan.setBounds(530, 290, 300, 20);
        
        submit.setBounds(550, 350, 100, 50);
        submit.addActionListener(this);
        frame.add(submit);
        frame.add(labnama);
        frame.add(labkode);
        frame.add(textnama);
        frame.add(labnim);
        frame.add(textnim);
        frame.add(labangkatan);
        frame.add(textangkatan);
        frame.add(Jurusan);
        
        
        
        
        
        
        
        
        
        
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "SUBMIT":
                String strnama, strnim, strangkatan, strkode;
                strnama = textnama.getText();
                strnim = textnim.getText();
                strangkatan = textangkatan.getText();
                int angkat = Integer.parseInt(strangkatan);
                strkode = String.valueOf(Jurusan.getSelectedItem());
                Mahasiswa mhs = new Mahasiswa(strnama, strnim, angkat, strkode);
                boolean insert = control.addMahasiswa(mhs);
                if(insert == true){
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Mahasiswa Sudah Di Tambah");
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
