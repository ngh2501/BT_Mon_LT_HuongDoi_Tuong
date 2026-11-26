package on_CK_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CuaHangThueXe {

	// a) khai bao va khoi tao danh sach
	private List<XeThue> dsXe;

	public CuaHangThueXe() {
		dsXe = new ArrayList<XeThue>();
	}

	public List<XeThue> getDsXe() {
		return dsXe;
	}

	// b) tim xe theo ma, khong phan biet hoa thuong, khong co thi tra ve null
	public XeThue timTheoMa(String maXe) {
		for (XeThue xe : dsXe)
			if (xe.getMaXe().equalsIgnoreCase(maXe))
				return xe;
		return null;
	}

	// b) them xe: khong rong va khong trung ma
	public boolean themXe(XeThue xe) {
		if (xe == null || timTheoMa(xe.getMaXe()) != null)
			return false;
		return dsXe.add(xe);
	}

	// c) cap nhat nhien lieu, chi cap nhat duoc neu xe do la o to
	public boolean capNhatNhienLieu(String maXe, NhienLieu nhienLieuMoi) {
		XeThue xe = timTheoMa(maXe);
		if (xe instanceof Oto) {
			Oto oto = (Oto) xe;
			oto.setNhienLieu(nhienLieuMoi);
			return true;
		}
		return false;
	}

	// d) cac xe co tien thue cao hon trung binh, sap xep giam dan theo tien thue
	public List<XeThue> lietKeXeTienThueCaoHonTB() {
		List<XeThue> kq = new ArrayList<XeThue>();
		if (dsXe.isEmpty())
			return kq;
		double tong = 0;
		for (XeThue xe : dsXe)
			tong += xe.tinhTienThue();
		double tb = tong / dsXe.size();
		for (XeThue xe : dsXe)
			if (xe.tinhTienThue() > tb)
				kq.add(xe);
		kq.sort((a, b) -> Double.compare(b.tinhTienThue(), a.tinhTienThue()));
		return kq;
	}

	// e) xoa cac xe thue truoc mot ngay cho truoc, tra ve so xe da xoa
	public int xoaXeThueTruocNgay(LocalDate ngay) {
		int truoc = dsXe.size();
		dsXe.removeIf(xe -> xe.getNgayThue().isBefore(ngay));
		return truoc - dsXe.size();
	}

	// f) thong ke tong tien thue theo tung loai xe
	public Map<String, Double> thongKeTienThueTheoLoai() {
		Map<String, Double> kq = new TreeMap<String, Double>();
		for (XeThue xe : dsXe) {
			String loai = (xe instanceof XeMay) ? "Xe may" : "O to";
			kq.put(loai, kq.getOrDefault(loai, 0.0) + xe.tinhTienThue());
		}
		return kq;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(XeThue.tieuDe()).append("\n");
		for (XeThue xe : dsXe)
			sb.append(xe).append("\n");
		sb.append("Tong so xe: ").append(dsXe.size());
		return sb.toString();
	}
}