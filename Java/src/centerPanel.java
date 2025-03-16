import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class centerPanel extends JPanel {


    public centerPanel(){
        initComponent();
    }
    private JPanel jp;

    public JPanel getJP(){return jp;}
    public void setJP(JPanel jp){this.jp=jp;}

    public void initComponent(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
        this.setName("center");
        this.setPreferredSize(new Dimension(700,500));
    }

    public void updateCenter(JPanel jp){
        this.removeAll();
        this.add(jp);
        this.revalidate();
        this.repaint();
    }

    


}
