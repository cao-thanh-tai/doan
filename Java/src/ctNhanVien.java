import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.awt.image.ImageObserver;
import java.sql.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


public class ctNhanVien extends JPanel {

    private JPanel jp,jp1,jp2,jp3,jp4,jp5;
    public JLabel jl,jl1,jl2,jl3,jl4,jl5,jlavt;
    public JButton jb1,jb2,jb3;
    private JLabel[] arJL1;
    public JTextField[] arJT1;
    public JTable jtb;
    public ctNhanVien(){
        init();
    }

    public void init(){
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbl=new GridBagConstraints();

        jp1=new JPanel();
        jp2=new JPanel();
      
       
        jp5=new JPanel();



        jp1.setPreferredSize(new Dimension(600, 200));
        jp2.setPreferredSize(new Dimension(600, 250));


        jp1.setBackground(Color.GREEN);
        jp1.setOpaque(true);
        jp2.setBackground(Color.BLUE);
        jp1.setOpaque(true);

        jp1.setLayout(new FlowLayout(0,5,5));

        jp3=new JPanel(); //avata

        jp3.setPreferredSize(new Dimension(150,190));
        ImageIcon ic=new ImageIcon(getClass().getResource("img/avt2.jpg"));
        // ImageIcon resize=ic.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        // Image test=ic.getImage();
        // Image resize=test.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        // ImageIcon moi=new ImageIcon(resize);
        ic=resizeImage(ic, 140, 140);
        jlavt = new JLabel(ic);
        jp3.add(jlavt);
        jp4=new JPanel();
        jp4.setPreferredSize(new Dimension(300, 190));
        
        
        

        


        jp1.add(jp3);
        jp1.add(jp4);

        
        jp5.setPreferredSize(new Dimension(100,100));
        jb1=new JButton("them");
        jb2=new JButton("sua");
        jb3=new JButton("xoa");

        jb2.addActionListener(new eventctNhanVien(this));

        jp5.add(jb1);
        jp5.add(jb2);
        jp5.add(jb3);
        jp1.add(jp5);
        // String[][] data={
        //     {"1","1","1","1","avt1.jpg","1","1"},
        //     {"2","2","2","2","avt2.jpg","2","2"},
        //     {"3","3","3","3","avt3.jpg","3","3"},
        //     {"4","4","4","4","avt4.jpg","4","4"},
        //     {"5","5","5","5","avt5.jpg","5","5"},
        //     {"6","6","6","6","avt6.jpg","6","6"},
        //     {"7","7","7","7","avt7.jpg","7","7"},
        //     {"8","8","8","8","avt8.jpg","8","8"},
        // };
        
        // String[] hang={"1","2","3","4","5","6","7"};
        // DefaultTableModel model=new DefaultTableModel(data,hang);

        // jtb=new JTable(model);


        docDataFromDataBase();


        arJL1=new JLabel[7];
        arJT1=new JTextField[7];
        for (int i = 0; i < 7; i++) {
            arJL1[i]=new JLabel(jtb.getModel().getColumnName(i));
            arJT1[i]=new JTextField();
            arJL1[i].setPreferredSize(new Dimension(50, 20));
            arJT1[i].setPreferredSize(new Dimension(200, 20));
            jp4.add(arJL1[i]);
            jp4.add(arJT1[i]);
        }

        var chinhCot = (BiConsumer<Integer, Integer>) (n,k) ->{
            jtb.getColumnModel().getColumn(n).setPreferredWidth(k);
        };
        for (int i = 0; i < 7; i++) {
            chinhCot.accept(i, 40);
        }

        
        
        jtb.addMouseListener(new eventctNhanVien(this));
        
        jp2.add(jtb);

        // for (int i = 0; i < 7; i++) {
        //     arJT1[i].setText(data[0][i]);
        // }

        System.out.println(jtb.getModel().getValueAt(1, 1));
        gbl.gridx=0;
        gbl.gridy=0;
        gbl.weighty=0.4;
        this.add(jp1, gbl);

        gbl.gridy=-1;
        gbl.weighty=0.6;
        this.add(jp2, gbl);

    
        
    }


    public ImageIcon resizeImage(ImageIcon icon,int width,int height){
        Image test=icon.getImage();
        Image img=test.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    public void docDataFromDataBase(){
        String url="jdbc:mysql://localhost:3306/nhanvien";
        String username="root";
        String password="";
        System.out.println("database");

        try {
            System.out.println("loi 1");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url, username, password);
            // Properties info = new Properties();
            // info.setProperty("characterEncoding", "utf8");
            // info.setProperty("user", "root");
            // info.setProperty("password", "");
            // Connection conn=DriverManager.getConnection(url,info);
            System.out.println("loi 2");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM nv");

            ResultSetMetaData metaData=rs.getMetaData();
            int n=metaData.getColumnCount();
            DefaultTableModel model= new DefaultTableModel();
            jtb=new JTable(model);

            System.out.println("so " + n);

            for (int i = 1; i <= n; i++) {
                model.addColumn(metaData.getColumnName(i));
            }
            // while (rs.next()) {
            //     for (int i = 1; i <= n; i++) {
            //         System.out.print(rs.getString(i) + "\t"); // Lấy dữ liệu từng cột
            //     }
            //     System.out.println();
            // }
            while (rs.next()) {
                Object[] rowData = new Object[n];
                for (int i = 1; i <= n; i++) {
                    rowData[i - 1] = rs.getString(i);
                }
                model.addRow(rowData);
            }

        } catch (Exception e) {
            System.out.println("looi data");
        }
    }
    public void ghiDataFromDataBase(){
        String url="jdbc:mysql://localhost:3306/nhanvien";
        String username="root";
        String password="";

        String updateSql = "UPDATE nv SET mot = ?, hai = ?, ba = ?, bon = ?, nam = ?, sau = ?, bay = ? WHERE mot = ?";
        String insertSql = "INSERT INTO nv (mot, hai, ba, bon, nam, sau, bay) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("loi data1");
            Connection conn=DriverManager.getConnection(url, username, password);
            System.out.println("loi data2");

            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);

            DefaultTableModel model=(DefaultTableModel) jtb.getModel();
            
            int n=model.getRowCount();
            for (int i = 0; i < n; i++) {
                updateStmt.setInt(1, Integer.parseInt(model.getValueAt(i, 0).toString()));
                updateStmt.setInt(2, Integer.parseInt(model.getValueAt(i, 1).toString()));
                updateStmt.setInt(3, Integer.parseInt(model.getValueAt(i, 2).toString()));
                updateStmt.setInt(4, Integer.parseInt(model.getValueAt(i, 3).toString()));
                updateStmt.setString(5, model.getValueAt(i, 4).toString());
                updateStmt.setInt(6, Integer.parseInt(model.getValueAt(i, 5).toString()));
                updateStmt.setInt(7, Integer.parseInt(model.getValueAt(i, 6).toString()));
                updateStmt.setInt(8, i+1);
                updateStmt.addBatch();
            }
            updateStmt.executeBatch();
            System.out.println("update");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi ghidata");
        }
    }


}
