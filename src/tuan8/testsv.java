package tuan8;

import java.time.LocalDate;

public class testsv {

    public static void main(String[] args) {

        QLsv ql = new QLsv();

        SinhVien sv1 = new SVchinhquy(
                "SV03", "Nguyen Van C",
                LocalDate.of(2005, 5, 10),
                "DHKTPM19A", 15, monhoc.LAP_TRINH_JAVA);

        SinhVien sv2 = new SVTuXa(
                "SV01", "Nguyen Van A",
                LocalDate.of(2005, 3, 15),
                "DHKTPM19A", 12, monhoc.HE_CSDL);

        SinhVien sv3 = new SVchinhquy(
                "SV02", "Nguyen Van B",
                LocalDate.of(2005, 7, 20),
                "DHKTPM19A", 18, monhoc.TOAN_ROI_RAC);
        SinhVien sv5 = new SVTuXa("SV07","SIEUDZ",
                LocalDate.of(2005, 7, 22),
                "DHKTPM19A", 18, monhoc.TOAN_ROI_RAC);

        ql.them(sv1);
        ql.them(sv2);
        ql.them(sv3);
        ql.them(sv5);

        System.out.println("Tong thanh tien: "
                + String.format("%,.0f", ql.tongThanhTien()).replace(',', '.') + " VND");

        ql.sapXepTheoMa();
        System.out.println("Da sap xep xong!");

        ql.xoa("SV02");
        ql.sua("SV01");
    }
}

