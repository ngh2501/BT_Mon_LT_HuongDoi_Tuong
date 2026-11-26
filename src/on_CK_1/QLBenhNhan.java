package on_CK_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QLBenhNhan {
	private List<BenhNhan> dsBN;

	public QLBenhNhan() {
		dsBN = new ArrayList<>();
	}

	public List<BenhNhan> getDsBN() {
		return dsBN;
	}

	// a. Thêm bệnh nhân: khác null và không trùng mã
	public boolean themBenhNhan(BenhNhan benhNhan) {
	    if (benhNhan == null || dsBN.contains(benhNhan))
	        return false;
	    return dsBN.add(benhNhan);
	}

	// b. Lọc BN nội trú có số ngày nằm viện trong [a, b], sắp giảm dần theo ngày phát bệnh
	public List<BenhNhan> getDSBNTheoSoNgayNamVien(int a, int b) {
		List<BenhNhan> kq = new ArrayList<>();
		for (BenhNhan bn : dsBN) {
			if (bn instanceof BenhNhanNoiTru) {
				int soNgay = ((BenhNhanNoiTru) bn).getSongaynamvien();
				if (soNgay >= a && soNgay <= b)
					kq.add(bn);
			}
		}
		kq.sort(Comparator.comparing(BenhNhan::getNgayphatBenh).reversed());
		return kq;
	}

	// c. Cập nhật thông tin BN nội trú khi biết mã số
	public boolean capNhatBenhNhan(BenhNhan bnNewInfor) {
		if (!(bnNewInfor instanceof BenhNhanNoiTru))
			return false;
		for (int i = 0; i < dsBN.size(); i++) {
			BenhNhan bn = dsBN.get(i);
			if (bn instanceof BenhNhanNoiTru
					&& bn.getMaBN().equalsIgnoreCase(bnNewInfor.getMaBN())) {
				dsBN.set(i, bnNewInfor);
				return true;
			}
		}
		return false;
	}

	// d. Xóa tất cả BN đã hết bệnh, trả về số BN đã xóa
	public int xoaBenhNhanHetBenh() {
		int dem = 0;
		Iterator<BenhNhan> it = dsBN.iterator();
		while (it.hasNext()) {
			if (it.next().getTinhtrang() == TinhTrang.HET_BENH) {
				it.remove();
				dem++;
			}
		}
		return dem;
	}

	// e. Thống kê số ca bệnh theo từng tình trạng
	public Map<String, Integer> thongKeSoCaBenh() {
		Map<String, Integer> map = new HashMap<>();
		for (BenhNhan bn : dsBN) {
			String tt = bn.getTinhtrang().toString();
			map.put(tt, map.getOrDefault(tt, 0) + 1);
		}
		return map;
	}
}