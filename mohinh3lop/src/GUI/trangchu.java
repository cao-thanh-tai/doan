package GUI;

import DTO.*;
import BUS.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class trangchu extends JFrame {

    private static final khachhangBUS khachhangBUS = new khachhangBUS();

    private JPanel jpNuaTren, jpNuaDuoi, jpTimKiem, jpHienThiTongTin, jpChucNang, jpThongTinVaChiTiet;
    private int WIDTH = 1000, HEIGHT = 800;
    private JButton jbTHem, jbSua, jbXoa;

    

    private JTable jtb;
    private String[] dsThuocTinhKH = { "ma", "ho", "ten", "dia chi", "sdt" };
    private JTextField[] arrJT;
    private JTextField jtfTimKiem;



    private JComboBox<String> jcb;
    private List<khachhangDTO> dskh;



    public trangchu() {
        init();
    }

    public void init() {
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // gridBagLayout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // jpNuaTren
        jpNuaTren = new JPanel();
        jpNuaTren.setBackground(Color.red);
        jpNuaTren.setOpaque(true);
        jpNuaTren.setLayout(new FlowLayout(1, 5, 5));

        jpThongTinVaChiTiet = new JPanel();
        jpThongTinVaChiTiet.setLayout(new FlowLayout());

        jpHienThiTongTin = new JPanel();
        jpTimKiem = new JPanel();
        initHienThiThongTin();
        initTimKiem();
        

        jpThongTinVaChiTiet.add(jpHienThiTongTin);
        jpThongTinVaChiTiet.add(jpTimKiem);

        jpChucNang = new JPanel();
        jbTHem = new JButton("THEM");
        jbSua = new JButton("SUA");
        jbXoa = new JButton("XOA");

        jbTHem.addActionListener(new event(this));
        jbXoa.addActionListener(new event(this));
        jbSua.addActionListener(new event(this));

        jpChucNang.add(jbTHem);
        jpChucNang.add(jbSua);
        jpChucNang.add(jbXoa);

        jpChucNang.setPreferredSize(new Dimension((int)(WIDTH*0.15), HEIGHT));
        jpThongTinVaChiTiet.setPreferredSize(new Dimension((int)(WIDTH*0.7),HEIGHT));
        jpNuaTren.add(jpThongTinVaChiTiet);
        jpNuaTren.add(jpChucNang);
        // jpNuaDuoi
        jpNuaDuoi = new JPanel();
        jpNuaDuoi.setBackground(Color.BLUE);
        jpNuaDuoi.setOpaque(true);

        // nua tren
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(jpNuaTren, gbc);

        // nua duoi
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.7;

        // tao bang
        initTable();
        this.add(jpNuaDuoi, gbc);

        //

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((d.width - WIDTH) / 2, (d.height - HEIGHT) / 2);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new trangchu();
    }

    public void initTable() {
        dskh = new ArrayList<>();
        dskh = khachhangBUS.getAllKhachHang();
        DefaultTableModel model = new DefaultTableModel(dsThuocTinhKH, 0);
        jtb = new JTable(model);
        jtb.addMouseListener(new event(this));
        JScrollPane jsp = new JScrollPane(jtb);
        jpNuaDuoi.add(jsp);
        updateTable(dskh);

    }
    public void updateTable(List<khachhangDTO> dsTable){
        DefaultTableModel model = (DefaultTableModel) jtb.getModel();
        model.setRowCount(0);
        for (khachhangDTO kh : dsTable) {
            model.addRow(kh.getObject());
        }
    }

    
    public void initHienThiThongTin(){
        jpHienThiTongTin.setLayout(new FlowLayout(0, 0, 0));
        jpHienThiTongTin.setPreferredSize(new Dimension((int)(WIDTH*0.7), 150));
        arrJT=new JTextField[dsThuocTinhKH.length];
        for (int i = 0; i < arrJT.length; i++) {
            JLabel jl=new JLabel(dsThuocTinhKH[i]);
            arrJT[i]=new JTextField();
            arrJT[i].setPreferredSize(new Dimension(200,30));
            jl.setPreferredSize(new Dimension(100,30));
            JPanel a=new JPanel();
            a.add(jl);
            a.add(arrJT[i]);
            jpHienThiTongTin.add(a);
        }
    }
    public void initTimKiem(){
        jcb=new JComboBox<>(dsThuocTinhKH);
        jtfTimKiem=new JTextField();
        jtfTimKiem.getDocument().addDocumentListener(new event(this));
        ImageIcon icon=new ImageIcon(getClass().getResource("../resource/img/icons8-search-50.png"));
        icon=resizeImage(icon, 30, 30);
        jcb.setPreferredSize(new Dimension(100,30));
        jtfTimKiem.setPreferredSize(new Dimension(500, 30));

        jpTimKiem.add(jcb);
        jpTimKiem.add(jtfTimKiem);
        jpTimKiem.add(new JLabel(icon));
    }



    //ham chuc nang
    public ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image test = icon.getImage();
        Image img = test.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    // get set
    public JTable getjtb() {
        return jtb;
    }
    public JTextField[] getarrJT(){
        return arrJT;
    }
    public JComboBox<String> getjcb(){
        return jcb;
    }
    public List<khachhangDTO> getDskh() {
        return this.dskh;
    }

    public void setDskh(List<khachhangDTO> dskh) {
        this.dskh = dskh;
    }
    
    public String[] getDsThuocTinhKH() {
        return this.dsThuocTinhKH;
    }

    public void setDsThuocTinhKH(String[] dsThuocTinhKH) {
        this.dsThuocTinhKH = dsThuocTinhKH;
    }
    public JTextField getJtfTimKiem() {
        return this.jtfTimKiem;
    }

    public void setJtfTimKiem(JTextField jtfTimKiem) {
        this.jtfTimKiem = jtfTimKiem;
    }
    public JButton getJbTHem()
    {
		return this.jbTHem;
	}

    public void setJbTHem(JButton jbTHem)
    {
		this.jbTHem = jbTHem;
	}
    public JButton getJbSua()
    {
		return this.jbSua;
	}

    public JButton getJbXoa()
    {
		return this.jbXoa;
	}


}