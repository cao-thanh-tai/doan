

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class borderLayout extends JFrame{

    
    public JPanel pS,pC,pN,pW,pE;

    public borderLayout(){
        initComponent();
    }

    public void initComponent(){
        this.setTitle("broderLayout");
        this.getContentPane().setLayout(new BorderLayout());
        this.setSize(1000, 700);
        this.getContentPane().setBackground(Color.yellow);
        this.setUndecorated(true);
        pN=new JPanel();
        northJPanel nJP=new northJPanel();
        pN.add(nJP);
        this.add(pN,BorderLayout.NORTH);

        pS=new JPanel();
        pS.setPreferredSize(new Dimension(100, 100));
        pS.setBackground(Color.pink);
        pS.setOpaque(true);
        this.add(pS,BorderLayout.SOUTH);

        // pE=new JPanel();
        // pE.setBackground(Color.white);
        // pE.setPreferredSize(new Dimension(100, 100));
        // pE.setOpaque(true);
        // this.add(pE,BorderLayout.EAST);

        pW=new JPanel();
        pW.setPreferredSize(new Dimension(100,500));
        pW.setOpaque(true);
        this.add(pW,BorderLayout.WEST);
        centerPanel ctJP=new centerPanel();
        westJPanel wJP=new westJPanel(ctJP);
        
        pW.add(wJP);

        pC=new JPanel();
        pC.add(ctJP);
        this.add(pC,BorderLayout.CENTER);

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((d.width-this.getSize().width)/2, (d.height-this.getSize().height)/2);




        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new borderLayout();
    }
}
