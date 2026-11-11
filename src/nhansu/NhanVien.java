package nhansu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class NhanVien {

    protected String maNV;
    protected String hoTen;
    protected LocalDate ngayVaoLam;
    protected double luongCoBan;
    protected LoaiNhanVien loai;
    protected ChucVu chucVu;
    protected PhongBan phongBan;

    public NhanVien(String maNV, String hoTen, LocalDate ngayVaoLam,
                    double luongCoBan, LoaiNhanVien loai,
                    ChucVu chucVu, PhongBan phongBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongCoBan = luongCoBan;
        this.loai = loai;
        this.chucVu = chucVu;
        this.phongBan = phongBan;
    }

    // Lớp con BẮT BUỘC phải override
    public abstract double tinhLuong();
    public abstract String getMoTaLoai();

    public String getMaNV()          { return maNV; }
    public String getHoTen()         { return hoTen; }
    public LocalDate getNgayVaoLam() { return ngayVaoLam; }
    public double getLuongCoBan()    { return luongCoBan; }
    public LoaiNhanVien getLoai()    { return loai; }
    public ChucVu getChucVu()        { return chucVu; }
    public PhongBan getPhongBan()    { return phongBan; }

    public void setHoTen(String hoTen)             { this.hoTen = hoTen; }
    public void setLuongCoBan(double luongCoBan)   { this.luongCoBan = luongCoBan; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-6s | %-20s | %-10s | %-14s | %-12s | %-20s | %,.0f VND",
                maNV, hoTen, ngayVaoLam.format(fmt), loai, chucVu, phongBan, tinhLuong());
    }
}
