import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class eventClass implements ActionListener,MouseListener {
    private test OBJ;
    public eventClass(test OBJ){
        this.OBJ=OBJ;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==OBJ.bt1){
            System.out.println("dau cong");
        }else if(e.getSource()==OBJ.bt2){
            System.out.println("dau tru");
        }else if(e.getSource()==OBJ.bt3){
            System.out.println("dau nhan");
        }else if(e.getSource()==OBJ.bt4){
            System.out.println("dau chia");
        }
    }
    public void mouseClicked(MouseEvent e){
        if(e.getSource()==OBJ.tf1){
            System.out.println("da di chuyen va tf1");
            Border br=BorderFactory.createLineBorder(Color.red,2);
            OBJ.tf1.setBorder(br);
        }else if(e.getSource()==OBJ.tf2){
            System.out.println("den tf2");
            OBJ.tf2.setBorder(mauVien(Color.red));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Implement logic for mousePressed event
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Implement logic for mouseReleased event
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Implement logic for mouseEntered event
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Implement logic for mouseExited event
    }

    public Border mauVien(Color cl){
        Border br=BorderFactory.createLineBorder(cl,2);
        return br;
    }
}
