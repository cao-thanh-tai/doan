package BUS;

import java.util.List;

import DAO.khachhangDAO;
import DTO.khachhangDTO;

public class khachhangBUS {
    private khachhangDAO khachhangDAO;

    public khachhangBUS(){
        khachhangDAO=new khachhangDAO();
    }

    public List<khachhangDTO> getAllKhachHang(){
        return khachhangDAO.getAllKhachHang();
    }

    public void addKhachHang(khachhangDTO kh){
        khachhangDAO.addKhachHang(kh);
    }

    public void updateKhachHang(khachhangDTO kh){
        khachhangDAO.updateKhachHang(kh);
    }

    public void deleteKhachHang(int n){
        khachhangDAO.deleteKhachHang(n);
    }
}
