package tuan5;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachCongNhan {
    private CongNhan[] ds;
    private int count = 0;

    public DanhSachCongNhan(int n) {
        ds = new CongNhan[n];
        count = 0;
    }

    public boolean ThemCongNhan(CongNhan cn) {
        if (count < ds.length) {
            ds[count] = cn;
            count++;
            return true;
        }
        return false;
    }

    public void XuatDanhSach() {
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }

    public int SoLuongCongNhan() {
        return count;
    }

    public void XuatCongNhanTren200() {
        for (int i = 0; i < count; i++) {
            if (ds[i].getSoSanPham() > 200) {
                System.out.println(ds[i]);
            }
        }
    }

    
    public void SapXepGiamDan() {
        Arrays.sort(ds, 0, count, new Comparator<CongNhan>() {
            @Override
            public int compare(CongNhan cn1, CongNhan cn2) {
                return Integer.compare(
                    cn2.getSoSanPham(),
                    cn1.getSoSanPham()
                );
            }
        });
    }
}