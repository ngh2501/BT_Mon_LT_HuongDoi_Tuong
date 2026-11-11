package tuan9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	// Doc so nguyen, nhap sai thi nhap lai
	static int docSo(String thongBao) {
		while (true) {
			try {
				System.out.print(thongBao);
				return Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Nhap sai, vui long nhap so nguyen!");
			}
		}
	}

	// Doc so thuc, nhap sai thi nhap lai
	static double docSoThuc(String thongBao) {
		while (true) {
			try {
				System.out.print(thongBao);
				return Double.parseDouble(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Nhap sai, vui long nhap so!");
			}
		}
	}

	// Doc chuoi
	static String docChuoi(String thongBao) {
		System.out.print(thongBao);
		return sc.nextLine().trim();
	}

	// Hoi co/khong: nhap c la co
	static boolean docCoKhong(String thongBao) {
		String s = docChuoi(thongBao + " (c/k): ");
		return s.equalsIgnoreCase("c");
	}

	// In danh sach ra man hinh
	static void inDanhSach(ArrayList<PhongHoc> ds) {
		if (ds.isEmpty()) {
			System.out.println("Danh sach rong!");
			return;
		}
		for (PhongHoc ph : ds) {
			System.out.println(ph);
		}
	}

	// Nhap thong tin va them phong
	static void themPhong(ListPhongHoc dsph) {
		System.out.println("1. Phong ly thuyet  2. Phong may tinh  3. Phong thi nghiem");
		int loai = docSo("Chon loai phong: ");
		if (loai < 1 || loai > 3) {
			System.out.println("Loai phong khong hop le!");
			return;
		}

		// Thong tin chung
		String ma = docChuoi("Ma phong: ");
		String day = docChuoi("Day nha: ");
		double dt = docSoThuc("Dien tich: ");
		int bd = docSo("So bong den: ");

		// Thong tin rieng theo tung loai
		PhongHoc ph = null;
		if (loai == 1) {
			boolean mc = docCoKhong("Co may chieu");
			ph = new PhongLyThuyet(ma, day, dt, bd, mc);
		} else if (loai == 2) {
			int mt = docSo("So may tinh: ");
			ph = new PhongMayTinh(ma, day, dt, bd, mt);
		} else {
			String cn = docChuoi("Chuyen nganh: ");
			int sucChua = docSo("Suc chua: ");
			boolean br = docCoKhong("Co bon rua");
			ph = new PhongThiNghiem(ma, day, dt, bd, cn, sucChua, br);
		}

		if (dsph.them(ph))
			System.out.println("Them thanh cong!");
		else
			System.out.println("Them that bai, ma phong bi trung!");
	}

	public static void main(String[] args) {
		ListPhongHoc dsph = new ListPhongHoc();

		// Du lieu mau de test
		dsph.them(new PhongLyThuyet("A101", "A", 50, 5, true));
		dsph.them(new PhongLyThuyet("B201", "B", 60, 4, true));
		dsph.them(new PhongMayTinh("C301", "C", 90, 9, 60));
		dsph.them(new PhongMayTinh("A302", "A", 45, 5, 40));
		dsph.them(new PhongThiNghiem("D101", "D", 40, 4, "Hoa", 30, true));
		dsph.them(new PhongThiNghiem("D102", "D", 40, 3, "Sinh", 25, false));

		int chon;
		do {
			// Menu
			System.out.println("\n========== QUAN LY PHONG HOC ==========");
			System.out.println("1. Them phong hoc");
			System.out.println("2. Tim phong hoc theo ma phong");
			System.out.println("3. Xem toan bo danh sach");
			System.out.println("4. Xem cac phong dat chuan");
			System.out.println("5. Sap xep tang dan theo day nha");
			System.out.println("6. Sap xep giam dan theo dien tich");
			System.out.println("7. Sap xep tang dan theo so bong den");
			System.out.println("8. Cap nhat so may tinh cho phong may tinh");
			System.out.println("9. Xoa phong hoc theo ma phong");
			System.out.println("10. Tong so phong hoc");
			System.out.println("11. Xem cac phong may co 60 may");
			System.out.println("0. Thoat");
			chon = docSo("Chon chuc nang: ");

			switch (chon) {
			case 1: // Them phong
				themPhong(dsph);
				break;
			case 2: // Tim phong
				PhongHoc ph = dsph.timKiem(docChuoi("Nhap ma phong can tim: "));
				if (ph == null)
					System.out.println("Khong tim thay!");
				else
					System.out.println(ph);
				break;
			case 3: // Xem tat ca
				inDanhSach(dsph.layToanBo());
				break;
			case 4: // Phong dat chuan
				inDanhSach(dsph.layPhongDatChuan());
				break;
			case 5: // Sap xep theo day nha
				dsph.sapXepTheoDayNha();
				System.out.println("Da sap xep theo day nha!");
				inDanhSach(dsph.layToanBo());
				break;
			case 6: // Sap xep theo dien tich
				dsph.sapXepGiamTheoDienTich();
				System.out.println("Da sap xep giam dan theo dien tich!");
				inDanhSach(dsph.layToanBo());
				break;
			case 7: // Sap xep theo so bong den
				dsph.sapXepTheoSoBongDen();
				System.out.println("Da sap xep tang dan theo so bong den!");
				inDanhSach(dsph.layToanBo());
				break;
			case 8: // Cap nhat so may
				String maCN = docChuoi("Nhap ma phong may tinh: ");
				int soMoi = docSo("Nhap so may tinh moi: ");
				if (dsph.capNhatSoMay(maCN, soMoi))
					System.out.println("Cap nhat thanh cong!");
				else
					System.out.println("Khong tim thay phong may tinh co ma nay!");
				break;
			case 9: // Xoa phong (hoi lai cho chac)
				String maXoa = docChuoi("Nhap ma phong can xoa: ");
				PhongHoc canXoa = dsph.timKiem(maXoa);
				if (canXoa == null) {
					System.out.println("Khong tim thay phong can xoa!");
				} else {
					System.out.println(canXoa);
					if (docCoKhong("Ban co chac chan muon xoa")) {
						dsph.xoa(maXoa);
						System.out.println("Da xoa!");
					} else {
						System.out.println("Da huy xoa.");
					}
				}
				break;
			case 10: // Tong so phong
				System.out.println("Tong so phong hoc: " + dsph.tongSoPhong());
				break;
			case 11: // Phong may co 60 may
				inDanhSach(dsph.layPhongMay60());
				break;
			case 0:
				System.out.println("Tam biet!");
				break;
			default:
				System.out.println("Chuc nang khong hop le!");
			}
		} while (chon != 0);
	}
}