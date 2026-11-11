package tuan10;


import java.time.LocalDate;

public class SPDienTu extends SanPham {
	private double thoigianBH;

	public double getThoigianBH() {
		return thoigianBH;
	}

	public void setThoigianBH(double thoigianBH) {
		this.thoigianBH = thoigianBH;
	}

	
	public double tinhGiaBan() {
		return giaNhap + ( giaNhap * 0.1) + ( thoigianBH * 50000);
		
	}

	public SPDienTu(String maSP, String tenSP, LocalDate ngaySX, LocalDate ngayHH, double giaNhap, int slTon,
			double thoigianBH) {
		super(maSP, tenSP, ngaySX, ngayHH, giaNhap, slTon);
		this.thoigianBH = thoigianBH;
	}

	@Override
	public String toString() {
		return  super.toString() + "SPDienTu [thoigianBH=" + thoigianBH + "]";
	}
	
	
}
