package on_CK_1;

import java.time.LocalDate;

public abstract class BenhNhan {
	protected String hoTen;
	protected String soDT;
	protected final String maBN;
	protected LocalDate ngayphatBenh;
	protected TinhTrang tinhtrang;
	
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getMaBN() {
		return maBN;
	}
	
	public LocalDate getNgayphatBenh() {
		return ngayphatBenh;
	}
	public void setNgayphatBenh(LocalDate ngayphatBenh) {
		this.ngayphatBenh = ngayphatBenh;
	}
	public TinhTrang getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(TinhTrang tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	public abstract double getTienPhaiTra();
	
	public BenhNhan() {
	    this("", "", "", LocalDate.now(), TinhTrang.KHAC);
	}
	
	
	public BenhNhan(String hoTen, String soDT, String maBN, LocalDate ngayphatBenh, TinhTrang tinhtrang) {
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.maBN = maBN;
		this.ngayphatBenh = ngayphatBenh;
		this.tinhtrang = tinhtrang;
	}
	
	
	@Override
	public String toString() {
		return "BenhNhan [hoTen=" + hoTen + ", soDT=" + soDT + ", maBN=" + maBN + ", ngayphatBenh=" + ngayphatBenh
				+ ", tinhtrang=" + tinhtrang + "]";
	}
	
	
	
}
