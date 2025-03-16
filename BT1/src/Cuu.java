
public class Cuu extends GiaSuc {

    Cuu(){};
    Cuu(Cuu c){
        super((GiaSuc)c);
    }

    @Override
    public void keu(){
        System.out.println("cuu cuu ");
    }
    @Override
    public void input(){
        super.input();
    }
    @Override
    public void output(){
        System.out.println("con cuu");
        super.output();
    }
}
