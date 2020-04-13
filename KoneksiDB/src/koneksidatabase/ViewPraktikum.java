package koneksidatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewPraktikum extends JFrame {
    String[] jenisKelamin = { "Laki-Laki", "Perempuan" };

    JLabel Judul = new JLabel("DATA MAHASISWA");
    JLabel lNim = new JLabel("Nim");
    JTextField tfnim = new JTextField();
    JLabel lNamaMhs = new JLabel ("Nama");
    JTextField tfNamaMhs = new JTextField();
    JLabel lJenisMhs = new JLabel ("Jenis Kelamin");
    JComboBox tfJenisMhs = new JComboBox(jenisKelamin);
    JLabel lAlamatMhs = new JLabel ("Alamat");
    JTextField tfAlamatMhs = new JTextField();

    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnUpdatePanel = new JButton("Update");

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;  //buat scroll
    Object namaKolom[] = {"NIM","Nama","Jenis","Alamat"};

    public ViewPraktikum(){

        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000, 350);



        add(scrollPane);
        scrollPane.setBounds(320, 5, 600, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(Judul);
        Judul.setBounds(5, 5, 200, 30);
        add(lNim);
        lNim.setBounds(5, 50, 130, 20);
        add(tfnim);
        tfnim.setBounds(150, 50, 150, 30);
        add(lNamaMhs);
        lNamaMhs.setBounds(5, 95, 130, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(150, 95, 150, 30);
        add(lJenisMhs);
        lJenisMhs.setBounds(5, 140, 130, 20);
        add(tfJenisMhs);
        tfJenisMhs.setBounds(150, 140, 150, 30);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(5, 185, 130, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(150, 185, 150, 30);

        add(btnTambahPanel);
        btnTambahPanel.setBounds(5, 240, 90, 20);

        add(btnBatalPanel);
        btnBatalPanel.setBounds(105, 240, 90, 20);

        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(205, 240, 90, 20);
    }
    public String getNim(){
        return tfnim.getText();
    }

    public String getNamaMhs(){
        return tfNamaMhs.getText();
    }

    public String getJenisMhs(){
        return (String) tfJenisMhs.getSelectedItem();
    }

    public String getAlamatMhs(){
        return tfAlamatMhs.getText();
    }
}
