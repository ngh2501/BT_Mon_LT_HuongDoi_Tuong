package qlsv;

public enum monhoc {
    LAP_TRINH_JAVA("Lập trình Java", 450_000f),
    HE_CSDL("Hệ Cơ Sở Dữ Liệu", 450_000f),
    TOAN_ROI_RAC("Toán Rời Rạc", 500_000f),
    MANG_MAY_TINH("Mạng Máy Tính", 550_000f),
    TRI_TUE_NHAN_TAO("Trí Tuệ Nhân Tạo", 400_000f),
    HE_DIEU_HANH("Hệ Điều Hành", 500_000f),
    LAP_TRINH_WEB("Lập Trình WEB", 450_000f),
    CHUYEN_DOI_SO("Chuyển Đổi Số", 450_000f);

    private final String tenMon;
    private final float donGia;

    private monhoc(String tenMon, float donGia) {
        this.tenMon = tenMon;
        this.donGia = donGia;
    }

    public String getTenMon() {
        return tenMon;
    }

    public float getDonGia() {
        return donGia;
    }

    public static monhoc fromTenMon(String tenMon) {
        for (monhoc mh : values()) {
            if (mh.tenMon.equalsIgnoreCase(tenMon)) {
                return mh;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s (%,.0f VND/tín chỉ)", tenMon, donGia);
    }
}

