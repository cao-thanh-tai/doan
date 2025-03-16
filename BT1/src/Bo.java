public class Bo extends GiaSuc {

    Bo(){};
    Bo(Bo b){
        super((GiaSuc)b);
    }

    @Override
    public void keu(){
        System.out.println("bo bo ");
    }
    @Override
    public void input(){
        super.input();
    }
    @Override
    public void output(){
        System.out.println("con bo ");
        super.output();
    }
}
