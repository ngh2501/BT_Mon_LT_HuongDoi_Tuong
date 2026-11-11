package tuan8;

public class QLsv implements IFsv {

    private SinhVien[] ds = new SinhVien[100];
    private int n = 0;

    public QLsv() {
    }

    @Override
    public void them(SinhVien sv) {
        ds[n++] = sv;
    }

    @Override
    public void sua(String maSV) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSV().equals(maSV)) {
                System.out.println("Tim thay sinh vien: " + ds[i].getHoTen());
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }

    @Override
    public void xoa(String maSV) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSV().equals(maSV)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds[--n] = null;
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay sinh vien!");
    }

    @Override
    public void sapXepTheoMa() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ds[i].getMaSV().compareTo(ds[j].getMaSV()) > 0) {
                    SinhVien temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }

    @Override
    public double tongThanhTien() {
        double tong = 0;

        for (int i = 0; i < n; i++) {
            tong += ds[i].thanhtien();
        }

        return tong;
    }
}

