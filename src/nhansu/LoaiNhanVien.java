package nhansu;

public enum LoaiNhanVien {
    FULL_TIME("FullTime", "Toàn thời gian"),   
    PART_TIME("PartTime", "Bán thời gian");

    private final String ma;       
    private final String moTa;

    LoaiNhanVien(String ma, String moTa) {   
        this.ma = ma;
        this.moTa = moTa;
    }
    public String getMa() { return ma; }     
    public String getMoTa() {
        return moTa;
    }
}