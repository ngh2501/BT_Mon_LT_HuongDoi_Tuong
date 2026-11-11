package DienNuocGiChua;

import java.time.LocalDate;

public class KhachHangNN extends KhachHang {

	private String quocTich;
	
	
		
	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public KhachHangNN(String maKH, String hoTen, LocalDate ngayLHD, double soKw, double donGia, String quocTich) {
		super(maKH, hoTen, ngayLHD, soKw, donGia);
		this.quocTich = quocTich;
	}

	public KhachHangNN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHangNN(String maKH, String hoTen, LocalDate ngayLHD, double soKw, double donGia) {
		super(maKH, hoTen, ngayLHD, soKw, donGia);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
	    return super.toString() + ", quocTich=" + quocTich;
	}

	@Override
	protected void setGia(double gia) {
		// TODO Auto-generated method stub
		
	}


}
