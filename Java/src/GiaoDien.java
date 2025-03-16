import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

public class GiaoDien extends JPanel {
    private JLabel l1, l2, l3, lSoA, lTieuDe;
    private JPanel p1, p2, p3, p4, p5;
    private JTextField tf1, tf2, tf3, tf4, tf5;
    private JButton bt1, bt2, bt3, bt4, bt5;

    public GiaoDien() {
        initComponent();
    }

    public void initComponent() {
        // this.setTitle("VD ");

        // this.getContentPane().setBackground(Color.pink);
        // this.getContentPane().setLayout(new FlowLayout(1, 5, 5));
        this.setBackground(Color.pink);
        this.setLayout(new FlowLayout(1, 5, 5));
        this.setPreferredSize(new Dimension(500, 500));

        lTieuDe = new JLabel("Caculator");
        lTieuDe.setPreferredSize(new Dimension(475, 30));
        lTieuDe.setBackground(Color.YELLOW);
        lTieuDe.setOpaque(true);
        this.add(lTieuDe);

        lSoA = new JLabel("so a ");
        lSoA.setPreferredSize(new Dimension(70, 30));
        lSoA.setBackground(Color.green);
        lSoA.setOpaque(true);
        this.add(lSoA);

        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(400, 30));
        this.add(tf1);

        lSoA = new JLabel("so b ");
        lSoA.setPreferredSize(new Dimension(70, 30));
        lSoA.setBackground(Color.green);
        lSoA.setOpaque(true);
        this.add(lSoA);

        tf2 = new JTextField();
        tf2.setPreferredSize(new Dimension(400, 30));
        this.add(tf2);

        lSoA = new JLabel("kq ");
        lSoA.setPreferredSize(new Dimension(70, 30));
        lSoA.setBackground(Color.green);
        lSoA.setOpaque(true);
        this.add(lSoA);

        tf3 = new JTextField();
        tf3.setPreferredSize(new Dimension(400, 30));
        this.add(tf3);

        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(400, 200));
        p1.setLayout(new FlowLayout(1, 50, 50));
        this.add(p1);

        // ImageIcon icon=new
        // ImageIcon(getClass().getResource("/icon/icons8-plus-80.png"));
        bt1 = new JButton("cong");
        bt1.setPreferredSize(new Dimension(100, 30));
        bt1.addActionListener(testNhan(3));
        p1.add(bt1);

        bt2 = new JButton("tru");
        bt2.setPreferredSize(new Dimension(100, 30));
        bt2.addActionListener(testNhan(4));
        p1.add(bt2);

        bt3 = new JButton("nhan");
        bt3.setPreferredSize(new Dimension(100, 30));
        bt3.addActionListener(testNhan(1));
        p1.add(bt3);

        bt4 = new JButton("chia");
        bt4.setPreferredSize(new Dimension(100, 30));
        bt4.addActionListener(testNhan(2));
        p1.add(bt4);

        // this.setLocation(100, 100);
        // this.setSize(500, 500);
        // this.setVisible(true);
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        // int x = (d.width - this.getSize().width) / 2;
        // int y = (d.height - this.getSize().height) / 2;
        // this.setLocation(x, y);

    }

    public ActionListener testNhan(int n) {
        ActionListener test = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = tf1.getText();
                System.out.println("gia tri a " + a);
                String b = tf2.getText();
                if (a.equals("")) {
                    JOptionPane.showConfirmDialog(GiaoDien.this, "them so a", "thong bao", 1);
                    tf1.requestFocus();
                } else if (b.equals("")) {
                    JOptionPane.showConfirmDialog(GiaoDien.this, "them so b", "thong bao", 1);
                    tf2.requestFocus();
                } else {
                    if (n == 1) {
                        System.out.println("dau nhan");
                        tf3.setText(String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));
                    } else if (n == 2) {
                        System.out.println("dau chia");
                        tf3.setText(String.valueOf(Integer.parseInt(a) / Integer.parseInt(b)));
                    } else if (n == 3) {
                        System.out.println("dau cong");
                        tf3.setText(String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));
                    } else if (n == 4) {
                        System.out.println("dau tru");
                        tf3.setText(String.valueOf(Integer.parseInt(a) - Integer.parseInt(b)));
                    }
                }
            }
        };
        return test;
    }

    public static void main(String[] args) {
        new GiaoDien();
    }

}