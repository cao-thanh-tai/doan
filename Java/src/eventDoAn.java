import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class eventDoAn implements ActionListener,MouseListener {
    private westJPanel OBJ;
    private centerPanel OBJcenter;
    
    public eventDoAn(westJPanel OBJ,centerPanel OBJcenter){
        this.OBJ=OBJ;
        this.OBJcenter=OBJcenter;
    }
    public eventDoAn(westJPanel OBJ){
        this.OBJ=OBJ;
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==OBJ.arJB[0]){
            OBJcenter.updateCenter(jp1());
        } else if(e.getSource()==OBJ.arJB[1]){
            OBJcenter.updateCenter(jp2());
        } else if(e.getSource()==OBJ.arJB[2]){
            OBJcenter.updateCenter(jp3());
        } else if(e.getSource()==OBJ.arJB[3]){
            OBJcenter.updateCenter(jp4());
        } else if(e.getSource()==OBJ.arJB[4]){
            OBJcenter.updateCenter(jp5());
        } else if(e.getSource()==OBJ.arJB[5]){
            OBJcenter.updateCenter(jp6());
        } else if(e.getSource()==OBJ.arJB[6]){
            OBJcenter.updateCenter(jp7());
        } else if(e.getSource()==OBJ.arJB[7]){
            OBJcenter.updateCenter(jp8());
        } else if(e.getSource()==OBJ.arJB[8]){
            OBJcenter.updateCenter(jp9());
        }
    }
    @Override
    public void mouseClicked(MouseEvent e){         // nhan va tha
        
    }

    @Override
    public void mousePressed(MouseEvent e) {        // nhannhan
        // Implement logic for mousePressed event
    }

    @Override
    public void mouseReleased(MouseEvent e) {       //tha
        // Implement logic for mouseReleased event
    }

    @Override
    public void mouseEntered(MouseEvent e) {        //di chuyen vaovao
        for (JButton i : OBJ.arJB) {
            if(e.getSource()==i){
                i.setBackground(Color.BLUE);
                i.setOpaque(true);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {         //di chuyen rara
        for (JButton i : OBJ.arJB) {
            if(e.getSource()==i){
                i.setBackground(Color.lightGray);
                i.setOpaque(true);
            }
        }
    }

    public Border mauVien(Color cl){
        Border br=BorderFactory.createLineBorder(cl,2);
        return br;
    }








    public JPanel jp1(){
        JPanel jp=new JPanel();
        GiaoDien gd=new GiaoDien();
        jp.add(gd);
        return jp;
    }
    public JPanel jp2(){
        return new ctNhanVien();
    }public JPanel jp3(){
        JPanel jp=new JPanel();
        JLabel jl=new JLabel("menu 3 fksdfs sdjflsf sdfj sdfjsdjf;");
        jp.add(jl);
        return jp;
    }public JPanel jp4(){
        JPanel jp=new JPanel();
        JLabel jl=new JLabel("menu 4 fksdfs sdjflsf sdfj sdfjsdjf;");
        jp.add(jl);
        return jp;
    }public JPanel jp5(){
        JPanel jp=new JPanel();
        JLabel jl=new JLabel("menu 5 fksdfs sdjflsf sdfj sdfjsdjf;");
        jp.add(jl);
        return jp;
    }public JPanel jp6(){
        JPanel jp=new JPanel();
        JLabel jl=new JLabel("menu 6 fksdfs sdjflsf sdfj sdfjsdjf;");
        jp.add(jl);
        return jp;
    }public JPanel jp7(){
        JPanel jp=new JPanel();
        JLabel jl=new JLabel("menu 7 fksdfs sdjflsf sdfj sdfjsdjf;");
        jp.add(jl);
        return jp;
    }public JPanel jp8(){
        JPanel jp=new JPanel();
        JLabel jl=new JLabel("menu 8 fksdfs sdjflsf sdfj sdfjsdjf;");
        jp.add(jl);
        return jp;
    }public JPanel jp9(){
        JPanel jp=new JPanel();
        JLabel jl=new JLabel("menu 9 fksdfs sdjflsf sdfj sdfjsdjf;");
        jp.add(jl);
        return jp;
    }



}
