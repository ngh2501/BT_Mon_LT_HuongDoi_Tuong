package tuan3;
import java.time.LocalDate;


public class HangThucPham {
	private final String maHang;
	private String tenHang;
	private float donGia;
	private LocalDate ngaySX;
	private LocalDate ngayHH;
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(tenHang == null || tenHang.trim().isEmpty()) {
			this.tenHang = "xxx";
		}
		else{
			this.tenHang = tenHang;
		}
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		if (donGia <= 0 ) {
			this.donGia = donGia;
		}
		this.donGia = donGia;
	}
	public LocalDate getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(LocalDate ngaySX) {
	    if (ngaySX == null || !ngaySX.isBefore(LocalDate.now())) {
	        this.ngaySX = LocalDate.now();
	    } else {
	        this.ngaySX = ngaySX;
	    }

	    if (this.ngayHH != null && !this.ngayHH.isAfter(this.ngaySX)) {
	        this.ngayHH = this.ngaySX;
	    }
	}
	public LocalDate getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(LocalDate ngayHH) {
		if(ngayHH == null || !ngayHH.isAfter(ngaySX)) {
			this.ngayHH = ngaySX;
		}
		else {
			this.ngayHH = ngayHH;
		}
		
	}
	
	public HangThucPham(String maHang, String tenHang, float donGia, LocalDate ngaySX, LocalDate ngayHH) {
		if (maHang == null || maHang.trim().isEmpty()) {
	        throw new IllegalArgumentException("Ma hang khong duoc de trong");
	    }
		this.maHang = maHang;
		setTenHang(tenHang);
	    setDonGia(donGia);
	    setNgaySX(ngaySX);
	    setNgayHH(ngayHH);
	}
	
	public String getMaHang() {
	    return maHang;
	}
	
	public HangThucPham(String maHang) {
	    if (maHang == null || maHang.trim().isEmpty()) {
	        throw new IllegalArgumentException("Ma hang khong duoc de trong");
	    }

	    this.maHang = maHang;
	    this.tenHang = "xxx";
	    this.donGia = 0;
	    this.ngaySX = LocalDate.now();
	    this.ngayHH = this.ngaySX;
	}
	
	public boolean KiemTraHH() {
		return !ngayHH.isAfter(LocalDate.now());
		
	}
	@Override
	public String toString() {
	    

	    return "HangThucPham ["
	            + "maHang=" + maHang
	            + ", tenHang=" + tenHang
	            + ", donGia=" + donGia
	            + ", ngaySX=" + ngaySX
	            + ", ngayHH=" + ngayHH
	            + ", Da het han: " + (KiemTraHH() ? "Da het han" : "Chua het han")
	            + "]";
	}
	
	
}
