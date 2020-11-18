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

public class LihatMahasiswa implements ActionListener{
    JFrame frame = new JFrame("INSERT JURUSAN");
    JButton insert_jurusan = new JButton("INSERT JURUSAN");
    JButton lihat_jurusan = new JButton("LIHAT JURUSAN");
    JButton insert_mahasiswa = new JButton("INSERT MAHASISWA");
    Controller control = new Controller();
    JLabel data;

    
    public LihatMahasiswa(Jurusan jurus){
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
        String datas = "";
        ArrayList<Mahasiswa> mahas = jurus.getListMhs();
        for(int i = 0; i < mahas.size(); i++){
            Mahasiswa mhs = mahas.get(i);
            datas = mhs.getNama() + " - " + mhs.getNim() + "\n";
        }
        
        data = new JLabel(datas);
        
        data.setBounds(350, 50, 500, 500);
        frame.add(data);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
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
