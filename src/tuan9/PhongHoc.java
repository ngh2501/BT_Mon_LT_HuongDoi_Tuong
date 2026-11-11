package tuan9;

public abstract class PhongHoc {
	protected String maPhong, dayNha;
	protected double dienTich;
	protected int soBongDen;

	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}

	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	public PhongHoc() {
	}

	// Du anh sang: trung binh 10m2 co 1 bong den
	public boolean duAnhSang() {
		return soBongDen >= dienTich / 10;
	}

	// Chi dung duy nhat 1 phuong thuc nay
	public abstract boolean datChuan();

	@Override
	public String toString() {
		return "PhongHoc [maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + ", soBongDen="
				+ soBongDen + ", datChuan=" + (datChuan() ? "Dat chuan" : "Khong dat") + "]";
	}
}