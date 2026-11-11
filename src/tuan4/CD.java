package tuan4;

public class CD {
    private String maCD;
    private String tuaCD;
    private String caSy;
    private int soBaiHat;
    private float giaThanh;

    // Getter - Setter
    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }
 
    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public String getCaSy() {
        return caSy;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBai) {
        if (soBai > 0) {
            this.soBaiHat = soBai;
        } else {
            throw new IllegalArgumentException("So bai hat phai lon hon 0");
        }
    }

    public float getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(float giaThanh) {
        this.giaThanh = giaThanh;
    }

    // Constructor có tham số
    public CD(String maCD, String tuaCD, String caSy, int soBai, float giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        
        if (soBai > 0) {
            this.soBaiHat = soBai;
        } else {
            throw new IllegalArgumentException("So bai hat phai lon hon 0");
        }

        this.giaThanh = giaThanh;
    }

    // Constructor mặc định
    public CD() {
    }

    public CD(String tuaCD2, String caSy2, int soBai, float gia, String maCD2) {
	}

	// Tạo tiêu đề in
    public static void tieuDe() {
        System.out.println("                         DANH SACH CD");

        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();

        String s = String.format(
                "|%10s|%20s|%20s|%10s|%10s|%15s|",
                "Ma CD", "Tua CD", "Ca Sy",
                "So Bai", "Don Gia", "Thanh Tien"
        );

        System.out.println(s);

        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Tính thành tiền
    public double getThanhTien() {
        return soBaiHat * giaThanh;
    }

    // Xuất thông tin CD
    @Override
    public String toString() {
        return String.format(
                "|%10s|%20s|%20s|%10d|%10.2f|%15.2f|",
                maCD, tuaCD, caSy, soBaiHat, giaThanh, getThanhTien()
        );
    }

    public static void main(String[] args) {
        CD cd = new CD("CD01", "Nhac Tre", "Son Tung", 10, 50000);

        CD.tieuDe();
        System.out.println(cd);
    }
}