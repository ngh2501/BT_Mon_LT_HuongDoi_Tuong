package tuan8;

import java.time.LocalDate;

public class SVchinhquy extends SinhVien {

    private String hoctructiep;

    public SVchinhquy(String maSV, String hoTen, LocalDate ngaySinh, String lop, int tinchi, monhoc monHoc) {
        super(maSV, hoTen, ngaySinh, lop, tinchi, monHoc);
    }

    public String getHoctructiep() {
        return hoctructiep;
    }

    public void setHoctructiep(String hoctructiep) {
        this.hoctructiep = hoctructiep;
    }

    public String getLoai() {
        return "Sinh viên chính quy";
    }

    public String getthongtin() {
        return maSV + " - " + hoTen + " - " + ngaySinh + " - " + lop
                + " - " + sotinchi + " tín chỉ - " + monHoc.getTenMon()
                + " - " + thanhtien() + " VND - " + hoctructiep;
    }
}

