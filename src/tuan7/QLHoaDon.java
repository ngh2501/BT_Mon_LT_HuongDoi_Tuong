package tuan7;

import java.time.LocalDate;

public class QLHoaDon {


public static void main(String[] args) {

    // 1. Tao danh sach quan ly
    QuanLyKH ql = new QuanLyKH();

    // 2. Them khach hang
    ql.themNhieu(
        new KhachHangVN("VN01", "Nguyen Van A",
            LocalDate.of(2018, 9, 10), 100, 1500, "sinh hoat", 50),

        new KhachHangVN("VN02", "Tran Thi B",
            LocalDate.of(2018, 10, 5), 200, 2000, "kinh doanh", 100),

        new KhachHangVN("VN03", "Le Van C",
            LocalDate.of(2019, 1, 20), 80, 1800, "san xuat", 60),

        new KhachHangNN("NN01", "John Smith",
            LocalDate.of(2018, 9, 25), 150, 2500, "My"),

        new KhachHangNN("NN02", "Yuki Tanaka",
            LocalDate.of(2018, 8, 15), 120, 3000, "Nhat"),

        new KhachHangNN("NN03", "Kim Min Su",
            LocalDate.of(2019, 3, 8), 90, 2800, "Han")
    );

    // 3. Dem khach hang
    System.out.println("So khach hang Viet Nam: "
            + ql.dem(kh -> kh instanceof KhachHangVN));

    System.out.println("So khach hang nuoc ngoai: "
            + ql.dem(kh -> kh instanceof KhachHangNN));

    // 4. Xuat danh sach khach hang
    System.out.println("\n=== DANH SACH KHACH HANG ===");
    ql.duyet(kh -> System.out.println(kh));

    // 5. Sap xep theo ma khach hang
    System.out.println("\n=== DANH SACH SAU KHI SAP XEP ===");
    ql.sapxep();
    ql.duyet(kh -> System.out.println(kh));
}


}
