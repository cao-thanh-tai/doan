package GUI;

import DAO.khachhangDAO;
import DTO.khachhangDTO;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import BUS.khachhangBUS;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class event implements ActionListener, MouseListener, DocumentListener {
    private trangchu OBJ;
    private static final khachhangDAO khachhangDAO = new khachhangDAO();
    private static final khachhangBUS khachhangBUS = new khachhangBUS();

    public event(trangchu OBJ) {
        this.OBJ = OBJ;
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == OBJ.getJbTHem()) {
            them();
        } else if (src == OBJ.getJbSua()) {
            sua();
        } else if (src == OBJ.getJbXoa()) {
            xoa();
            updateArrTextField(-1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { // nhan va tha
        if (e.getSource() == OBJ.getjtb()) {
            updateArrTextField(OBJ.getjtb().getSelectedRow());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { // nhannhan
        // Implement logic for mousePressed event
    }

    @Override
    public void mouseReleased(MouseEvent e) { // tha
        // Implement logic for mouseReleased event
    }

    @Override
    public void mouseEntered(MouseEvent e) { // di chuyen vaovao

    }

    @Override
    public void mouseExited(MouseEvent e) { // di chuyen rara

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument() == OBJ.getJtfTimKiem().getDocument()) {
            timKiem();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (e.getDocument() == OBJ.getJtfTimKiem().getDocument()) {
            timKiem();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Chỉ kích hoạt với text có format đặc biệt (hiếm khi dùng)
    }

    // ham chuc nag
    // sua du lieu hien thi trong input
    public void updateArrTextField(int n) {
        if (n == -1) {
            for (int i = 0; i < OBJ.getDsThuocTinhKH().length; i++) {
                OBJ.getarrJT()[i].setText("");
            }
        } else {
            for (int i = 0; i < OBJ.getDsThuocTinhKH().length; i++) {
                OBJ.getarrJT()[i].setText(OBJ.getjtb().getModel().getValueAt(n, i).toString());
            }
        }

    }

    // tim kiem
    public void timKiem() {
        String thongtin = OBJ.getJtfTimKiem().getText();
        String thuoctinh = OBJ.getjcb().getSelectedItem().toString();
        List<khachhangDTO> ds = new ArrayList<>();
        boolean ktra = false;
        for (khachhangDTO kh : OBJ.getDskh()) {
            switch (thuoctinh) {
                case "ma":
                    ktra = strcon(thongtin, Integer.toString(kh.getMakh()));
                    break;
                case "ho":
                    ktra = strcon(thongtin, kh.getHokh());
                    break;
                case "ten":
                    ktra = strcon(thongtin, kh.getTenkh());
                    break;
                case "sdt":
                    ktra = strcon(thongtin, kh.getSdt());
                    break;
                case "dia chi":
                    ktra = strcon(thongtin, kh.getDiachi());
                    break;
                default:
                    break;
            }
            if (ktra)
                ds.add(kh);
        }
        OBJ.updateTable(ds);
    }

    // ktra chuoi con
    public boolean strcon(String strcon, String strme) {
        if (strme.toLowerCase().contains(strcon.toLowerCase()))
            return true;
        return false;
    }

    // xoa
    public void xoa() {
        int n=OBJ.getjtb().getSelectedRow();
        khachhangBUS.deleteKhachHang(OBJ.getDskh().get(n).getMakh());
        DefaultTableModel model = (DefaultTableModel) (OBJ.getjtb().getModel());
        model.removeRow(n);
        OBJ.getDskh().remove(n);
    }

    // them
    public void them() {
        DefaultTableModel model = (DefaultTableModel) (OBJ.getjtb().getModel());
        model.addRow(getDataInputOBJ());
        khachhangDTO kh=new khachhangDTO(getDataInputKH());
        OBJ.getDskh().add(kh);
        khachhangBUS.addKhachHang(kh);
    }

    // sua
    public void sua() {
        int n = OBJ.getjtb().getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) (OBJ.getjtb().getModel());
        for (int i = 0; i < OBJ.getDsThuocTinhKH().length; i++) {
            model.setValueAt(getDataInputOBJ()[i], n, i);
        }
        khachhangDTO kh=new khachhangDTO(getDataInputKH());
        OBJ.getDskh().set(n, kh);
        khachhangBUS.updateKhachHang(kh);
    }

    // lay du lieu tu input
    public Object[] getDataInputOBJ() {
        int n = OBJ.getarrJT().length;
        JTextField[] arrJT = OBJ.getarrJT();
        Object obj[] = new Object[n];
        for (int i = 0; i < n; i++) {
            obj[i] = arrJT[i].getText();
        }
        return obj;
    }

    public khachhangDTO getDataInputKH() {
        khachhangDTO kh = new khachhangDTO();
        JTextField[] arrJT = OBJ.getarrJT();

        kh.setMakh(Integer.parseInt(arrJT[0].getText()));
        kh.setHokh(arrJT[1].getText());
        kh.setTenkh(arrJT[2].getText());
        kh.setDiachi(arrJT[3].getText());
        kh.setSdt(arrJT[4].getText());
        
        return kh;
    }
}
