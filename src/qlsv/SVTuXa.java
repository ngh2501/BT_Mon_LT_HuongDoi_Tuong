package qlsv;

import java.time.LocalDate;

public class SVTuXa extends SinhVien{

	public SVTuXa(String maSV, String hoTen, LocalDate ngaySinh, String lop, int tinchi, monhoc monHoc) {
		super(maSV, hoTen, ngaySinh, lop, tinchi, monHoc);
		// TODO Auto-generated constructor stub
	}

	private String nentang;

	public String getNentang() {
		return nentang;
	}

	public void setNentang(String nentang) {
		this.nentang = nentang;
	}
	
	public String getLoai() {
		return "Sinh Vien Tu Xa";
	}
	
	public double thanhtien() {
		return monHoc.getDonGia() * 0.9;
	}


}
