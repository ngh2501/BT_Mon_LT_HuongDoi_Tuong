package HangTP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyThucPham {
    private ArrayList<HangThucPham> ds;

    public QuanLyThucPham() {
        ds = new ArrayList<HangThucPham>();
    }
    
    public void themHang(HangThucPham h) {
        ds.add(h);
    }
    
    public void xuatDanhSach() {
        for (HangThucPham h : ds) {
            System.out.println(h);
        }
    }
    public HangThucPham timHang(String maHang) {
        for (HangThucPham h : ds) {
            if (h.getMaHang().equals(maHang)) {
                return h;
            }
        }
        return null;
    }
    public boolean xoaHang(String maHang) {
        HangThucPham h = timHang(maHang);

        if (h != null) {
            ds.remove(h);
            return true;
        }

        return false;
    }
    public void sapXepTheoGia() {
        Collections.sort(ds, new Comparator<HangThucPham>() {
            @Override
            public int compare(HangThucPham h1, HangThucPham h2) {
                return Float.compare(h1.getDonGia(), h2.getDonGia());
            }
        });
    }
}