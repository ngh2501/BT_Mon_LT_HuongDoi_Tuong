package nhansu;

import java.time.LocalDate;

public class NhanVienPartTime extends NhanVien {

    private int soGioLam;
    private double luongTheoGio;

    public NhanVienPartTime(String maNV, String hoTen, LocalDate ngayVaoLam,
                            double luongCoBan, LoaiNhanVien loai,
                            ChucVu chucVu, PhongBan phongBan,
                            int soGioLam, double luongTheoGio) {
        super(maNV, hoTen, ngayVaoLam, luongCoBan, loai, chucVu, phongBan);
        this.soGioLam = soGioLam;
        this.luongTheoGio = luongTheoGio;
    }

    public int getSoGioLam()         { return soGioLam; }
    public double getLuongTheoGio()  { return luongTheoGio; }

    // lương = số giờ làm × lương theo giờ
    @Override
    public double tinhLuong() {
        return soGioLam * luongTheoGio;
    }

    @Override
    public String getMoTaLoai() {
        return "Làm việc bán thời gian, lương theo giờ";
    }
}
