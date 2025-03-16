public class De extends GiaSuc {

    De(){}
    De(De d){
        super((GiaSuc)d);
    }

    @Override
    public void keu(){
        System.out.println("be be ");
    }
    @Override
    public void input(){
        super.input();
    }
    @Override
    public void output(){
        System.out.println("con de ");
        super.output();
    }
}
