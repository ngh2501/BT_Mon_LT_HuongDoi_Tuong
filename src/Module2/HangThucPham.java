import java.time.LocalDate;

public class HangThucPham {
    private final int Mahang;
    private String Tenhang;
    private double Dongia;
    private LocalDate Ngaysx;
    private LocalDate Ngayhh;

    // Getter
    public int getMahang() {
        return Mahang;
    }

    // Getter + Setter
    public String getTenhang() {
        return Tenhang;
    }

    public void setTenhang(String Tenhang) {
        if (Tenhang == null || Tenhang.trim().isEmpty()) {
            this.Tenhang = "xxx";
        } else {
            this.Tenhang = Tenhang;
        }
    }

    // Getter + Setter
    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        if (Dongia < 0) {
            this.Dongia = 0;
        } else {
            this.Dongia = Dongia;
        }
    }

    // Getter + Setter
    public LocalDate getNgaysx() {
        return Ngaysx;
    }

    public void setNgaysx(LocalDate Ngaysx) {
        if (Ngaysx != null && Ngaysx.isBefore(LocalDate.now())) {
            this.Ngaysx = Ngaysx;
        } else {
            this.Ngaysx = LocalDate.now();
        }
    }


    public LocalDate getNgayhh() {
        return Ngayhh;
    }

    public void setNgayhh(LocalDate Ngayhh) {
        if (Ngayhh != null && Ngayhh.isAfter(Ngaysx)) {
            this.Ngayhh = Ngayhh;
        } else {
            this.Ngayhh = Ngaysx;
        }
    }

    // Kiểm tra hết hạn
    public boolean ktrangodoc() {
        return LocalDate.now().isAfter(Ngayhh);
    }

    // Constructor
    public HangThucPham(int Mahang, String Tenhang, double Dongia,
                        LocalDate Ngaysx, LocalDate Ngayhh) {

        if (Mahang <= 0) {
            throw new IllegalArgumentException("Ma Hang Khong Hop Le");
        }

        this.Mahang = Mahang;
        setTenhang(Tenhang);
        setDongia(Dongia);
        setNgaysx(Ngaysx);
        setNgayhh(Ngayhh);
    }

    // Constructor chỉ có mã hàng
    public HangThucPham(int Mahang) {

        if (Mahang <= 0) {
            throw new IllegalArgumentException("Ma Hang Khong Hop Le");
        }

        this.Mahang = Mahang;
        this.Tenhang = "xxx";
        this.Dongia = 0;
        this.Ngaysx = LocalDate.now();
        this.Ngayhh = this.Ngaysx;
    }
}
@Override
public String toString() {
    return "Mã hàng: " + Mahang +
            "\nTên hàng: " + Tenhang +
            "\nĐơn giá: " + Dongia +
            "\nNgày sản xuất: " + Ngaysx +
            "\nNgày hết hạn: " + Ngayhh +
            "\nĐã hết hạn: " + ktrangodoc();
}
