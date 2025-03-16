import java.util.ArrayList;
import java.util.Scanner;

public class DSGS {
    private static ArrayList<GiaSuc> DSGS = new ArrayList<>();
    
    public void input(){
        System.out.println("nhap so luong gia suc ");
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        int sl=sc.nextInt();
        for (int i = 0; i < sl; i++) {
            input1GS();
        }
    }

    public void input1GS(){
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        GiaSuc gs=new GiaSuc();
        System.out.println("1.bo    2.de    3.cuu");
        System.out.print("chon loai gia suc : ");
        switch (sc.nextInt()) {
            case 1:gs=new Bo();
            break;
            case 2:gs=new De();
            break;
            case 3:gs=new Cuu();
            break;
            default:
            break;
        }
        gs.input();
        DSGS.add(gs);
    }

    public void output(){
        for(GiaSuc i:DSGS){
            i.output();
        }
    }
    public void khocThet(){
        for(GiaSuc i:DSGS){
            i.keu();
        }
    }

}
