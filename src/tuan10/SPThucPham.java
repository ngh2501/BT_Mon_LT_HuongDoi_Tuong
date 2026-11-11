package tuan10;


import java.time.LocalDate;

public class SPThucPham extends SanPham {
	
	
	public SPThucPham(String maSP, String tenSP, LocalDate ngaySX, LocalDate ngayHH, double giaNhap, int slTon) {
		super(maSP, tenSP, ngaySX, ngayHH, giaNhap, slTon);
	}

	public double tinhGiaBan() {
		if(ngayHH.isBefore(LocalDate.now())|| ngayHH.isEqual(LocalDate.now())) {
		return 0;
	}
		return giaNhap + (giaNhap * 0.05);
		
	}

	@Override
	public String toString() {
		return super.toString() + "SPThucPham []";
	}
	
	
}
