import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class westJPanel extends JPanel {

    private JPanel jp;
    private JLabel jl;
    public JButton jb;
    public JButton arJB[];
    private centerPanel ctJP;

    public westJPanel(centerPanel ctJP) {
        this.ctJP=ctJP;
        initComponent();
    }

    public void initComponent() {

        this.setLayout(new FlowLayout(1, 5, 5));
        this.setPreferredSize(new Dimension(100, 500));
        this.setBackground(Color.GREEN);
        this.setOpaque(true);
        
        menu();

    }

    public void khungMenu(String str, int i) {
        JPanel jptest = new JPanel();

        arJB[i] = new JButton(str);
        arJB[i].setName(str);
        arJB[i].setBackground(Color.lightGray);
        arJB[i].setPreferredSize(new Dimension(80, 20));
        arJB[i].addActionListener(new eventDoAn(this,ctJP));
        arJB[i].addMouseListener(new eventDoAn(this));
        arJB[i].setOpaque(true);
        this.add(arJB[i]);
    }

    public void menu() {

        String[] strMenu = { "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin" };
        arJB = new JButton[strMenu.length];
        for(int i=0;i<strMenu.length;i++){
            khungMenu(strMenu[i], i);
        }

    }
}
