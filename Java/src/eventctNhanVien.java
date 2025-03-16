import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;



public class eventctNhanVien implements MouseListener,ActionListener {
    private ctNhanVien OBJ;
    private int selectRow;

    public eventctNhanVien(ctNhanVien OBJ) {
        this.OBJ = OBJ;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(selectRow);
        if(e.getSource()==OBJ.jb2){
            updateData();
            OBJ.ghiDataFromDataBase();
        }
    }

    public void updateData(){
        selectRow=OBJ.jtb.getSelectedRow();
        for (int i = 0; i < 7; i++) {
            OBJ.jtb.getModel().setValueAt(OBJ.arJT1[i].getText(), selectRow, i);
        }
        ImageIcon ic=new ImageIcon(getClass().getResource("img/"+String.valueOf(OBJ.jtb.getModel().getValueAt(selectRow, 4))));
        OBJ.jlavt.setIcon(resizeImage(ic, 140, 140));
    }

    @Override
    public void mouseClicked(MouseEvent e) { // nhan va tha
        // getselectedrow
        selectRow=OBJ.jtb.getSelectedRow();

        if(e.getSource()==OBJ.jtb){
            
            for (int i = 0; i < 7; i++) {
                OBJ.arJT1[i].setText(String.valueOf(OBJ.jtb.getModel().getValueAt(selectRow, i)));
            }
        }
        ImageIcon ic=new ImageIcon(getClass().getResource("img/"+String.valueOf(OBJ.jtb.getModel().getValueAt(selectRow, 4))));
        OBJ.jlavt.setIcon(resizeImage(ic, 140, 140));
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






    public ImageIcon resizeImage(ImageIcon icon,int width,int height){
        Image test=icon.getImage();
        Image img=test.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
