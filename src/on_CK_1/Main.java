package on_CK_1;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		QLBenhNhan ql = new QLBenhNhan();
		LocalDate d = LocalDate.now();

		// 3a. Tạo 5 bệnh nhân hợp lệ của cả 2 loại
		ql.themBenhNhan(new BenhNhanNoiTru("A", "01", "BN1", d.minusDays(5), TinhTrang.CON_BENH, 10));
		ql.themBenhNhan(new BenhNhanNoiTru("B", "02", "BN2", d.minusDays(9), TinhTrang.HET_BENH, 5));
		ql.themBenhNhan(new BenhNhanNoiTru("C", "03", "BN3", d.minusDays(2), TinhTrang.CON_BENH, 7));
		ql.themBenhNhan(new BenhNhanNgoaiTru("D", "04", "BN4", d, TinhTrang.KHAC, 50000));
		ql.themBenhNhan(new BenhNhanNgoaiTru("E", "05", "BN5", d, TinhTrang.HET_BENH, 0));
		System.out.println(ql.getDsBN());

		// Dữ liệu không hợp lệ
		try {
			new BenhNhanNoiTru("X", "0", "BN9", d, TinhTrang.KHAC, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			new BenhNhanNgoaiTru("Y", "0", "BN8", d, TinhTrang.KHAC, -1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// a. Thêm: đúng / trùng mã / null
		System.out.println(ql.themBenhNhan(new BenhNhanNgoaiTru("F", "06", "BN6", d, TinhTrang.KHAC, 0)));
		System.out.println(ql.themBenhNhan(new BenhNhanNgoaiTru("F", "06", "BN1", d, TinhTrang.KHAC, 0)));
		System.out.println(ql.themBenhNhan(null));

		// b. Lọc: có / không có
		System.out.println(ql.getDSBNTheoSoNgayNamVien(5, 10));
		System.out.println(ql.getDSBNTheoSoNgayNamVien(50, 60));

		// c. Cập nhật: có mã / không có mã
		System.out.println(ql.capNhatBenhNhan(new BenhNhanNoiTru("A2", "01", "BN1", d, TinhTrang.HET_BENH, 3)));
		System.out.println(ql.capNhatBenhNhan(new BenhNhanNoiTru("Z", "09", "BN99", d, TinhTrang.KHAC, 3)));

		// e. Thống kê
		System.out.println(ql.thongKeSoCaBenh());

		// d. Xóa bệnh nhân hết bệnh
		System.out.println(ql.xoaBenhNhanHetBenh());
		ql.getDsBN().forEach(bn -> System.out.println(bn));
	}
}