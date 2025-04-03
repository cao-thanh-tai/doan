package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


import DTO.khachhangDTO;

public class khachhangDAO {
    private Connection conn;

    public khachhangDAO(){
        try {
            String url="jdbc:mysql://localhost:3306/mohinh3lop";
            String username="root";
            String password="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("loi r 24 DAO");
        }
    }

    public List<khachhangDTO> getAllKhachHang(){
        List<khachhangDTO> dsKhachHang =new ArrayList<>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM khachhang");
            while (rs.next()) {
                dsKhachHang.add(new khachhangDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println("loi r 38 DAO");
        }

        return dsKhachHang;
    }

    public void addKhachHang(khachhangDTO kh){
        try {
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO khachhang (makh,hokh,tenkh,sdt,diachi) VALUES (?,?,?,?,?)");
            stmt.setInt(1, kh.getMakh());
            stmt.setString(2, kh.getHokh());
            stmt.setString(3, kh.getTenkh());
            stmt.setString(4, kh.getSdt());
            stmt.setString(5, kh.getDiachi());

            stmt.executeUpdate();

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(); // Hiển thị lỗi chi tiết
        }
    }
    public void updateKhachHang(khachhangDTO kh){
        try {
            PreparedStatement stmt=conn.prepareStatement("UPDATE khachhang SET hokh = ?, tenkh=?, sdt=?,diachi=? WHERE makh=?");
            stmt.setString(1, kh.getHokh());
            stmt.setString(2, kh.getTenkh());
            stmt.setString(3, kh.getSdt());
            stmt.setString(4, kh.getDiachi());
            stmt.setInt(5, kh.getMakh());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Hiển thị lỗi chi tiết
        }
    }
    public void deleteKhachHang(int n){
        try {
            PreparedStatement stmt=conn.prepareStatement("DELETE FROM khachhang WHERE makh = ?");
            stmt.setInt(1, n);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }



}
