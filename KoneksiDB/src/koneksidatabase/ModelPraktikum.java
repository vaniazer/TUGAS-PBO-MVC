package koneksidatabase;

import javax.swing.*;
import java.sql.*;

public class ModelPraktikum {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbprak";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public ModelPraktikum() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public void insertMahasiswa(String nim, String nama, String jenis, String alamat){
        try {
            String query = "INSERT INTO `mahasiswa` VALUES ('"+nim+"','"+nama+"','"+jenis+"','"+alamat+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Berhasil Diinput!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readMahasiswa(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4];

            String query = "SELECT * FROM `mahasiswa`";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nim");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("jenis");
                data[jmlData][3] = resultSet.getString("alamat");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public void updateMahasiswa(String nim, String nama, String jenis, String alamat){
        try {
            String query = "UPDATE `mahasiswa` SET `nim` = '"+nim+"',`nama`= '"+nama+"', `jenis`= '"+jenis+"' , `alamat`='"+alamat+"'  WHERE `nim` = '"+nim+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil diUpdate");
            JOptionPane.showMessageDialog(null, "Data Berhasil diupdate!");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }



    public void deleteMahasiswa (String nim) {
        try{
            String query = "DELETE FROM `mahasiswa` WHERE `nim` = '"+nim+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
