package tuan10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLySanPham {
	private List<SanPham> danhSachSP;
	public QuanLySanPham() {
		this.danhSachSP = new ArrayList<>();
}
	public List<SanPham> getDanhSachSP(){
		return danhSachSP;
	}
	public void setDanhSachSP(List<SanPham> danhSachSP) {
		this.danhSachSP = danhSachSP;
	}
	public boolean themSP(SanPham sp) {
		boolean trungMa = danhSachSP.stream().anyMatch(s->s.getMaSP().equalsIgnoreCase(sp.getMaSP()));
		if(trungMa) {
			System.out.println("San Pham Da Ton Tai");
			return false;
		}
		danhSachSP.add(sp);
		System.out.println("Them SP Thanh Cong");
		return true;
	}
	public boolean xoaSP(String maSP) {
		boolean xoa = danhSachSP.removeIf(s->s.getMaSP().equalsIgnoreCase(maSP));
		if(xoa) {
			System.out.println("Xoa Thanh Cong");
		}
		else {
			System.out.println("Khong Tim Thay SP ");
		}
		return xoa;
		}
	
	public boolean suaSLTon(String maSP, int SLmoi) {
		for (SanPham s: danhSachSP) {
			if(s.getMaSP().equalsIgnoreCase(maSP)) {
				s.setSlTon(SLmoi);
				System.out.println("Da Cap Nhat");
				return true;
			}
			System.out.println("Cap Nhat Khong Thanh Cong");
			return false;
		}
		System.out.println("Khong Tim Thay SP");
		return false;
	}
	public void xuatSP(String loai) {
		List<SanPham> ketqua = new ArrayList<>();
		if(loai.equalsIgnoreCase("ĐiệnTử")) {
			ketqua = danhSachSP.stream().filter(s->s instanceof SPDienTu).collect(Collectors.toList());
		}
		else if (loai.equalsIgnoreCase("ThựcPhẩm")) {
			ketqua = danhSachSP.stream().filter(s->s instanceof SPThucPham).collect(Collectors.toList());
		}
		System.out.println("Danh Sach SP Loai:" + loai + "---");
		if (ketqua.isEmpty()) {
			System.out.println("Khong Tim Thay SP");

		}
		else {
			ketqua.forEach(System.out::println);
		}
	}
	
	public void SPgiacaonhat() {
		if(danhSachSP.isEmpty()) {
			System.out.println("Danh Sach SP trong");
			return;
		}
		double maxgiaBan = danhSachSP.stream().mapToDouble(SanPham::tinhGiaBan).max().orElse(0);
		List<SanPham> spcaonhat = danhSachSP.stream().filter(s->s.tinhGiaBan() == maxgiaBan).collect(Collectors.toList());
		System.out.println("SP Gia Cao Nhat(" + maxgiaBan + ") ");

	}
	}