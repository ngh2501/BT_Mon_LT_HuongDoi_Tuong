package tuan6;

public enum PhongBan {
    IT("Công nghệ thông tin"),
    HR("Nhân sự"),
    KE_TOAN("Kế toán"),
    MARKETING("Marketing");

    private final String ten;

    PhongBan(String ten) { this.ten = ten; }

    public String getTen() { return ten; }

    @Override
    public String toString() { return ten; }
}
