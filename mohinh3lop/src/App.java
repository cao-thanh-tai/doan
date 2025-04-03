
import java.util.ArrayList;
import java.util.List;

import DAO.khachhangDAO;
import DTO.khachhangDTO;

public class App {
    public static void main(String[] args) {
        khachhangDAO test=new khachhangDAO();
        List<khachhangDTO> ds=new ArrayList<>();
        ds=test.getAllKhachHang();
        for (int i = 0; i < ds.size(); i++) {
            ds.get(i).ouput();
        }
    }
}
