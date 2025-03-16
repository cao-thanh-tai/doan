import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class northJPanel extends JPanel {
    
    private JPanel p1,p2;
    private JLabel l1,l2;
    private JButton bt1;

    public northJPanel(){
        initComponent();
    }


    public void initComponent(){
        this.setPreferredSize(new Dimension(1000,50));
        this.setBackground(Color.GREEN);

        p1=new JPanel(new FlowLayout(0, 5, 5));
        p2=new JPanel(new FlowLayout(2, 5, 5));
        
        p1.setBackground(Color.GREEN);
        p1.setOpaque(true);
        p2.setBackground(Color.GREEN);
        p2.setOpaque(true);

        p1.setPreferredSize(new Dimension(400,100));
        p2.setPreferredSize(new Dimension(590,100));

        this.add(p1);
        this.add(p2);

        l1=new JLabel("xin chao");
        l2=new JLabel("hello");

        p1.add(l1);
        p2.add(l2);
        ImageIcon ic=new ImageIcon(getClass().getResource("icon/nuttat.png"));
        
        bt1=new JButton(ic);
        bt1.addActionListener(tat());
        bt1.setPreferredSize(new Dimension(30, 30));
        p2.add(bt1);
        
    }

    public ActionListener tat(){
        ActionListener test=new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        };
        return test;
    }

}
