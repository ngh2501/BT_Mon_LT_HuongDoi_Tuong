package qlsv;

import java.time.LocalDate;

public class SinhVien {


		protected String maSV;
		protected String hoTen;
		protected LocalDate ngaySinh;
		protected String lop;
		protected int sotinchi;
		protected monhoc monHoc;
		
		public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String lop, int tinchi, monhoc monHoc) {
			super();
			this.maSV = maSV;
			this.hoTen = hoTen;
			this.ngaySinh = ngaySinh;
			this.lop = lop;
			this.sotinchi = tinchi;
			this.monHoc = monHoc;
		}

		public double thanhtien() {
			return sotinchi * monHoc.getDonGia();
		}

		public String getMaSV() {
			return maSV;
		}

		public void setMaSV(String maSV) {
			this.maSV = maSV;
		}

		public String getHoTen() {
			return hoTen;
		}

		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}

		public LocalDate getNgaySinh() {
			return ngaySinh;
		}

		public void setNgaySinh(LocalDate ngaySinh) {
			this.ngaySinh = ngaySinh;
		}

		public String getLop() {
			return lop;
		}

		public void setLop(String lop) {
			this.lop = lop;
		}

		public int getSotinchi() {
			return sotinchi;
		}

		public void setSotinchi(int sotinchi) {
			this.sotinchi = sotinchi;
		}

		public monhoc getMonHoc() {
			return monHoc;
		}

		public void setMonHoc(monhoc monHoc) {
			this.monHoc = monHoc;
		}

		public float getdonGia() {return monHoc.getDonGia();}
		public String gettenMonHoc() {return monHoc.getTenMon();}

}