package tuan6;

import java.time.LocalDate;

public class NhanVienFullTime extends NhanVien {

    private double heSoLuong;
    private double phuCap;

    public NhanVienFullTime(String maNV, String hoTen, LocalDate ngayVaoLam,
                            double luongCoBan, LoaiNhanVien loai,
                            ChucVu chucVu, PhongBan phongBan,
                            double heSoLuong, double phuCap) {
        super(maNV, hoTen, ngayVaoLam, luongCoBan, loai, chucVu, phongBan);
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    public double getHeSoLuong() { return heSoLuong; }
    public double getPhuCap()    { return phuCap; }

    // lương = lương cơ bản × hệ số lương × hệ số chức vụ + phụ cấp
    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong * chucVu.getHeSoPhuCap() + phuCap;
    }

    @Override
    public String getMoTaLoai() {
        return "Làm việc toàn thời gian, hưởng lương cứng + phụ cấp";
    }
}
