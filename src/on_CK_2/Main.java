package on_CK_2;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		CuaHangThueXe ch = new CuaHangThueXe();
		LocalDate n = LocalDate.now();

		// ===== 3a) Them san 6 xe hop le cua ca hai loai va in ra =====
		ch.themXe(new XeMay("X01", "Honda Vision", n.minusDays(10), 4, 100000, 125));
		ch.themXe(new XeMay("X02", "Yamaha Exciter", n.minusDays(2), 3, 150000, 160));
		ch.themXe(new XeMay("X03", "Honda SH 160", n.minusDays(6), 2, 250000, 160));
		ch.themXe(new Oto("O01", "Toyota Vios", n.minusDays(5), 3, 500000, 4, NhienLieu.XANG));
		ch.themXe(new Oto("O02", "Mitsubishi Xpander", n.minusDays(3), 2, 400000, 7, NhienLieu.XANG));
		ch.themXe(new Oto("O03", "VinFast VF9", n.minusDays(1), 3, 500000, 7, NhienLieu.DIEN));

		System.out.println("===== DANH SACH BAN DAU =====");
		System.out.println(ch);

		// ===== 3b) Truong hop ngoai le: moi try tao mot doi tuong SAI that =====
		System.out.println("\n===== KIEM THU NGOAI LE =====");
		try {
			new XeMay("X09", "Loi ten", n, 1, 100000, 0); // dung tich = 0
		} catch (IllegalArgumentException e) {
			System.out.println("Loi: " + e.getMessage());
		}
		try {
			new XeMay("X09", "Loi gia", n, 1, -100000, 110); // gia am
		} catch (IllegalArgumentException e) {
			System.out.println("Loi: " + e.getMessage());
		}
		try {
			new Oto("O09", "Loi so cho", n, 1, 600000, 5, NhienLieu.XANG); // 5 cho
		} catch (IllegalArgumentException e) {
			System.out.println("Loi: " + e.getMessage());
		}
		try {
			new Oto("O10", "Loi ngay", n.plusDays(3), 1, 700000, 4, NhienLieu.XANG); // ngay tuong lai
		} catch (IllegalArgumentException e) {
			System.out.println("Loi: " + e.getMessage());
		}
		try {
			new Oto("", "Loi ma", n, 1, 700000, 4, NhienLieu.XANG); // ma rong
		} catch (IllegalArgumentException e) {
			System.out.println("Loi: " + e.getMessage());
		}

		// ===== 3b) Them xe: dung / trung ma / null =====
		System.out.println("\n===== THEM XE =====");
		System.out.println("Them moi      : "
				+ ch.themXe(new XeMay("X04", "Honda Wave", n.minusDays(8), 2, 90000, 110)));
		System.out.println("Them trung ma : "
				+ ch.themXe(new XeMay("x01", "Trung ma", n, 1, 100000, 110)));
		System.out.println("Them null     : " + ch.themXe(null));

		// ===== Tim theo ma: co / khong co =====
		System.out.println("\n===== TIM THEO MA =====");
		System.out.println("Tim o01  : " + ch.timTheoMa("o01")); // khong phan biet hoa thuong
		System.out.println("Tim XX99 : " + ch.timTheoMa("XX99"));

		// ===== Cap nhat nhien lieu: o to / xe may / ma khong co =====
		System.out.println("\n===== CAP NHAT NHIEN LIEU =====");
		System.out.println("O02 sang dien      : " + ch.capNhatNhienLieu("O02", NhienLieu.DIEN));
		System.out.println("X01 (khong phai oto): " + ch.capNhatNhienLieu("X01", NhienLieu.DIEN));
		System.out.println("XX99 (khong co)    : " + ch.capNhatNhienLieu("XX99", NhienLieu.DIEN));

		// ===== Liet ke xe cao hon trung binh =====
		System.out.println("\n===== XE CO TIEN THUE CAO HON TRUNG BINH =====");
		System.out.println(XeThue.tieuDe());
		ch.lietKeXeTienThueCaoHonTB().forEach(xe -> System.out.println(xe));

		// ===== Thong ke theo loai =====
		System.out.println("\n===== TONG TIEN THUE THEO LOAI =====");
		ch.thongKeTienThueTheoLoai()
				.forEach((loai, tong) -> System.out.printf("%-8s %,12.0f%n", loai, tong));

		// ===== Xoa theo ngay: co xoa duoc / khong xoa duoc =====
		System.out.println("\n===== XOA XE THUE TRUOC NGAY =====");
		System.out.println("Xoa truoc " + n.minusDays(4) + " : "
				+ ch.xoaXeThueTruocNgay(n.minusDays(4)) + " xe");
		System.out.println("Xoa truoc " + n.minusYears(5) + " : "
				+ ch.xoaXeThueTruocNgay(n.minusYears(5)) + " xe");

		System.out.println("\n===== DANH SACH SAU KHI XOA =====");
		System.out.println(ch);
	}
}