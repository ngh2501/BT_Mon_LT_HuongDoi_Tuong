package tuan10;


import java.time.LocalDate;

public abstract class SanPham {
	protected String maSP, tenSP;
	protected LocalDate ngaySX;
	protected LocalDate ngayHH;

	protected double  giaNhap;
	protected int slTon;
	public String getMaSP() {
		return maSP;
	}
	
	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}

	public LocalDate getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(LocalDate ngayHH) {
		this.ngayHH = ngayHH;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public int getSlTon() {
		return slTon;
	}

	public void setSlTon(int slTon) {
		this.slTon = slTon;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public SanPham(String maSP, String tenSP, LocalDate ngaySX, LocalDate ngayHH, double giaNhap, int slTon) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.giaNhap = giaNhap;
		this.slTon = slTon;
	}

	public SanPham() {
	}

	public abstract double tinhGiaBan();

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", ngaySX=" + ngaySX + ", ngayHH=" + ngayHH + ", giaNhap="
				+ giaNhap + ", slTon=" + slTon + "]";
	}
	
	
	
}
