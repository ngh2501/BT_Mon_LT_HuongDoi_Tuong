package tuan7;
import java.time.LocalDate;

abstract class KhachHang {
	protected String maKH;
	protected String hoTen;
	protected LocalDate ngayLHD;
	protected double soKw, donGia;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public LocalDate getNgayLHD() {
		return ngayLHD;
	}
	public void setNgayLHD(LocalDate ngayLHD) {
		this.ngayLHD = ngayLHD;
	}
	public double getSoKw() {
		return soKw;
	}
	public void setSoKw(double soKw) {
		this.soKw = soKw;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public KhachHang(String maKH, String hoTen, LocalDate ngayLHD, double soKw, double donGia) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.ngayLHD = ngayLHD;
		this.soKw = soKw;
		this.donGia = donGia;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTen=" + hoTen + ", ngayLHD=" + ngayLHD + ", soKw=" + soKw + ", donGia="
				+ donGia + "]";
	}
	protected abstract void setGia(double gia);
	
	
	
	
}
