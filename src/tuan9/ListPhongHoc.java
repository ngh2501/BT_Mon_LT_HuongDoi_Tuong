package tuan9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListPhongHoc {
	private ArrayList<PhongHoc> ds;

	// Khoi tao danh sach
	public ListPhongHoc() {
		ds = new ArrayList<PhongHoc>();
	}

	// Them phong (khong trung ma)
	public boolean them(PhongHoc ph) {
		if (ph == null || timKiem(ph.getMaPhong()) != null)
			return false;
		ds.add(ph);
		return true;
	}

	// Tim phong theo ma
	public PhongHoc timKiem(String maPhong) {
		for (PhongHoc ph : ds) {
			if (ph.getMaPhong().equalsIgnoreCase(maPhong))
				return ph;
		}
		return null;
	}

	// Lay ca danh sach
	public ArrayList<PhongHoc> layToanBo() {
		return ds;
	}

	// Lay cac phong dat chuan
	public ArrayList<PhongHoc> layPhongDatChuan() {
		ArrayList<PhongHoc> kq = new ArrayList<PhongHoc>();
		for (PhongHoc ph : ds) {
			if (ph.datChuan())
				kq.add(ph);
		}
		return kq;
	}

	// Sap xep tang theo day nha
	public void sapXepTheoDayNha() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc a, PhongHoc b) {
				return a.getDayNha().compareToIgnoreCase(b.getDayNha());
			}
		});
	}

	// Sap xep giam theo dien tich
	public void sapXepGiamTheoDienTich() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc a, PhongHoc b) {
				return Double.compare(b.getDienTich(), a.getDienTich());
			}
		});
	}

	// Sap xep tang theo so bong den
	public void sapXepTheoSoBongDen() {
		Collections.sort(ds, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc a, PhongHoc b) {
				return Integer.compare(a.getSoBongDen(), b.getSoBongDen());
			}
		});
	}

	// Cap nhat so may (chi phong may tinh)
	public boolean capNhatSoMay(String maPhong, int soMayMoi) {
		PhongHoc ph = timKiem(maPhong);
		if (ph instanceof PhongMayTinh) {
			((PhongMayTinh) ph).setSoMayTinh(soMayMoi);
			return true;
		}
		return false;
	}

	// Xoa phong theo ma
	public boolean xoa(String maPhong) {
		PhongHoc ph = timKiem(maPhong);
		if (ph == null)
			return false;
		return ds.remove(ph);
	}

	// Tong so phong
	public int tongSoPhong() {
		return ds.size();
	}

	// Lay cac phong may co 60 may
	public ArrayList<PhongHoc> layPhongMay60() {
		ArrayList<PhongHoc> kq = new ArrayList<PhongHoc>();
		for (PhongHoc ph : ds) {
			if (ph instanceof PhongMayTinh && ((PhongMayTinh) ph).getSoMayTinh() == 60)
				kq.add(ph);
		}
		return kq;
	}
}