package koneksidatabase;

import javax.swing.*;
import java.awt.event.*;

public class ControllerPraktikum {
    ModelPraktikum modelpraktikum;
    ViewPraktikum viewpraktikum;

    public ControllerPraktikum(ModelPraktikum modelpraktikum, ViewPraktikum viewpraktikum) {
        this.modelpraktikum = modelpraktikum;
        this.viewpraktikum = viewpraktikum;

        if (modelpraktikum.getBanyakData() != 0) {
            String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
            viewpraktikum.tabel.setModel((new JTable(dataMahasiswa, viewpraktikum.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewpraktikum.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = viewpraktikum.getNim();
                String nama = viewpraktikum.getNamaMhs();
                String jenis = viewpraktikum.getJenisMhs();
                String alamat = viewpraktikum.getAlamatMhs();
                modelpraktikum.insertMahasiswa(nim, nama, jenis, alamat);

                String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
                viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
            }
        });

        viewpraktikum.btnUpdatePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = viewpraktikum.getNim();
                String nama = viewpraktikum.getNamaMhs();
                String jenis = viewpraktikum.getJenisMhs();
                String alamat = viewpraktikum.getAlamatMhs();
                modelpraktikum.updateMahasiswa(nim,nama,jenis,alamat);

                String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
                viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());

            }
        });

        viewpraktikum.tabel.addMouseListener(new MouseAdapter() {
                                                 @Override
                                                 public void mouseClicked(MouseEvent e) {
                                                     super.mousePressed(e);
                                                     int baris = viewpraktikum.tabel.getSelectedRow();
                                                     int kolom = viewpraktikum.tabel.getSelectedColumn();

                                                     String dataterpilih = viewpraktikum.tabel.getValueAt(baris, 0).toString();

                                                     System.out.println(dataterpilih);

                                                     int input = JOptionPane.showConfirmDialog(null,
                                                             "Apa anda ingin menghapus NIM " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                                                     if (input == 0) {
                                                         modelpraktikum.deleteMahasiswa(dataterpilih);
                                                         String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
                                                         viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
                                                     } else {
                                                         JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                                                     }
                                                 }
                                             }
        );
    }
}