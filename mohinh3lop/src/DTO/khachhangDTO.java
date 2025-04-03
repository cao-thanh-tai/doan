package DTO;

public class khachhangDTO {
    private int makh;
    private String tenkh;
    private String hokh;
    private String sdt;
    private String diachi;

    public int getMakh() {
        return this.makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return this.tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getHokh() {
        return this.hokh;
    }

    public void setHokh(String hokh) {
        this.hokh = hokh;
    }

    public String getSdt() {
        return this.sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return this.diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Object[] getObject(){
        return new Object[]{makh,hokh,tenkh,diachi,sdt};
    }

    public khachhangDTO() {
    }

    public khachhangDTO(int makh, String tenkh, String hokh, String sdt, String diachi) {
        this.makh = makh;
        this.diachi = diachi;
        this.hokh = hokh;
        this.tenkh = tenkh;
        this.sdt = sdt;
    }

    public khachhangDTO(khachhangDTO kh) {
        this.makh = kh.makh;
        this.diachi = kh.diachi;
        this.hokh = kh.hokh;
        this.tenkh = kh.tenkh;
        this.sdt = kh.sdt;
    }

    public void ouput(){
        System.out.println(makh + hokh + tenkh + sdt + diachi);
    }
}
