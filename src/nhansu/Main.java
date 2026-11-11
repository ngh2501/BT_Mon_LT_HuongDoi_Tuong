package nhansu;

import java.time.LocalDate;
import java.util.*;

public class Main {

    static final Scanner sc = new Scanner(System.in);
    static final ListQuanLy ql = new ListQuanLy();

    public static void main(String[] args) {
        while (true) {
            hienThiMenu();
            System.out.print("Chọn: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            try {
                switch (chon) {
                    case 1:  chucNangThem();           break;
                    case 2:  chucNangXoa();            break;
                    case 3:  chucNangSua();            break;
                    case 4:  chucNangTimTheoTen();     break;
                    case 5:  chucNangTimTheoMa();      break;
                    case 6:  hienThi(ql.sapXepTheoLuong()); break;
                    case 7:  hienThi(ql.sapXepTheoTen());   break;
                    case 8:  chucNangThongKeLuong();   break;
                    case 9:  chucNangNhomTheoLoai();   break;
                    case 10: chucNangNhomTheoPhongBan(); break;
                    case 11: chucNangTimTheoChucVu();  break;
                    case 12: chucNangLocLuong();       break;
                    case 13: hienThi(ql.getDanhSach()); break;
                    case 0:
                        System.out.println("Tạm biệt!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (RuntimeException e) {
                // bắt lỗi nhập sai định dạng (số, ngày...) để chương trình không sập
                System.out.println("Dữ liệu nhập không hợp lệ: " + e.getMessage());
            }
        }
    }

    static void hienThiMenu() {
        System.out.println("\n========== MENU QUẢN LÝ NHÂN SỰ ==========");
        System.out.println("1.  Thêm nhân viên");
        System.out.println("2.  Xóa theo mã");
        System.out.println("3.  Sửa theo mã");
        System.out.println("4.  Tìm theo tên");
        System.out.println("5.  Tìm theo mã (tiền tố)");
        System.out.println("6.  Sắp xếp theo lương");
        System.out.println("7.  Sắp xếp theo tên");
        System.out.println("8.  Thống kê lương theo loại");
        System.out.println("9.  Nhóm theo loại");
        System.out.println("10. Nhóm theo phòng ban");
        System.out.println("11. Tìm theo chức vụ");
        System.out.println("12. Lọc lương trên mức X");
        System.out.println("13. Xuất tất cả");
        System.out.println("0.  Thoát");
    }

    // ---------- Các hàm xử lý chức năng ----------
    static void chucNangThem() {
        NhanVien nv = nhapNV();
        System.out.println(ql.them(nv) ? "Đã thêm!" : "Mã đã tồn tại!");
    }

    static void chucNangXoa() {
        System.out.print("Nhập mã cần xóa: ");
        String ma = sc.nextLine();
        System.out.println(ql.xoa(ma) ? "Đã xóa!" : "Không tìm thấy!");
    }

    static void chucNangSua() {
        System.out.print("Nhập mã cần sửa: ");
        String ma = sc.nextLine();
        System.out.println("Nhập thông tin mới:");
        NhanVien nvMoi = nhapNV();
        System.out.println(ql.sua(ma, nvMoi) ? "Đã sửa!" : "Không tìm thấy!");
    }

    static void chucNangTimTheoTen() {
        System.out.print("Nhập tên cần tìm: ");
        hienThi(ql.timKiemTheoTen(sc.nextLine()));
    }

    static void chucNangTimTheoMa() {
        System.out.print("Nhập tiền tố mã: ");
        hienThi(ql.timKiemTheoMa(sc.nextLine()));
    }

    static void chucNangThongKeLuong() {
        System.out.println("--- Thống kê lương theo loại ---");
        ql.thongKeLuongTheoLoai().forEach((k, v) ->
                System.out.printf("%-12s : %,.0f VND%n", k, v));
    }

    static void chucNangNhomTheoLoai() {
        System.out.println("--- Nhóm theo loại ---");
        ql.groupByLoai().forEach((k, v) -> {
            System.out.println("Loại: " + k);
            v.forEach(nv -> System.out.println("   " + nv));
        });
    }

    static void chucNangNhomTheoPhongBan() {
        System.out.println("--- Nhóm theo phòng ban ---");
        ql.groupByPhongBan().forEach((k, v) -> {
            System.out.println("Phòng: " + k);
            v.forEach(nv -> System.out.println("   " + nv));
        });
    }

    static void chucNangTimTheoChucVu() {
        System.out.println("--- Chọn chức vụ ---");
        ChucVu[] chucVus = ChucVu.values();
        for (int i = 0; i < chucVus.length; i++) {
            System.out.println((i + 1) + ". " + chucVus[i]);
        }
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(sc.nextLine().trim());
        if (chon >= 1 && chon <= chucVus.length) {
            hienThi(ql.timTheoChucVu(chucVus[chon - 1]));
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    static void chucNangLocLuong() {
        System.out.print("Nhập mức lương: ");
        double muc = Double.parseDouble(sc.nextLine().trim());
        hienThi(ql.locLuongTren(muc));
    }

    // ---------- Nhập nhân viên (có chọn enum) ----------
    static NhanVien nhapNV() {
        System.out.print("Mã NV: ");
        String ma = sc.nextLine().trim();

        System.out.print("Họ tên: ");
        String ten = sc.nextLine().trim();

        System.out.print("Ngày vào làm (yyyy-MM-dd): ");
        LocalDate ngay = LocalDate.parse(sc.nextLine().trim());

        System.out.print("Lương cơ bản: ");
        double lcb = Double.parseDouble(sc.nextLine().trim());

        LoaiNhanVien loai = chonEnum("loại nhân viên", LoaiNhanVien.values());
        ChucVu chucVu     = chonEnum("chức vụ", ChucVu.values());
        PhongBan phongBan = chonEnum("phòng ban", PhongBan.values());

        if (loai == LoaiNhanVien.FULL_TIME) {
            System.out.print("Hệ số lương: ");
            double hs = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Phụ cấp: ");
            double pc = Double.parseDouble(sc.nextLine().trim());
            return new NhanVienFullTime(ma, ten, ngay, lcb, loai, chucVu, phongBan, hs, pc);
        } else {
            System.out.print("Số giờ làm: ");
            int gio = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Lương theo giờ: ");
            double lg = Double.parseDouble(sc.nextLine().trim());
            return new NhanVienPartTime(ma, ten, ngay, lcb, loai, chucVu, phongBan, gio, lg);
        }
    }

    // Hàm generic dùng chung để chọn 1 giá trị enum bất kỳ từ menu
    static <E extends Enum<E>> E chonEnum(String tieuDe, E[] giaTri) {
        System.out.println("--- Chọn " + tieuDe + " ---");
        for (int i = 0; i < giaTri.length; i++) {
            System.out.println((i + 1) + ". " + giaTri[i]);
        }
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(sc.nextLine().trim());
        return giaTri[chon - 1];
    }

    static void hienThi(List<NhanVien> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else {
            list.forEach(System.out::println);
        }
    }
}
