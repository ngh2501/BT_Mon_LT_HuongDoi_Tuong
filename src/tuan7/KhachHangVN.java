package tuan7;

import java.time.LocalDate;

public class KhachHangVN extends KhachHang {
	private String doiTuong;
	private double dinhMuc;
	
	public String getDoiTuong() {
		return doiTuong;
	}
	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}
	public double getDinhMuc() {
		return dinhMuc;
	}
	public void setDinhMuc(double dinhMuc) {
		this.dinhMuc = dinhMuc;
	}
	
	public double ThanhTien() {
		return soKw <= dinhMuc
		? soKw * donGia 
		: dinhMuc * donGia + ( soKw - dinhMuc ) * donGia * 2.5;
	}
	public KhachHangVN(String maKH, String hoTen, LocalDate ngayLHD, double soKw, double donGia, String doiTuong,
			double dinhMuc) {
		super(maKH, hoTen, ngayLHD, soKw, donGia);
		this.doiTuong = doiTuong;
		this.dinhMuc = dinhMuc;
	}
	public KhachHangVN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangVN(String maKH, String hoTen, LocalDate ngayLHD, double soKw, double donGia) {
		super(maKH, hoTen, ngayLHD, soKw, donGia);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return super.toString() + "KhachHangVN [doiTuong=" + doiTuong + ", dinhMuc=" + dinhMuc + "]";
	}
	@Override
	protected void setGia(double gia) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
