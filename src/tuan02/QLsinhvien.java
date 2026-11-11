package tuan02;

import java.util.ArrayList;

public class QLsinhvien {

    private ArrayList<SinhVien> danhSach;

    public QLsinhvien() {
        danhSach = new ArrayList<SinhVien>();
    }

    public void themSinhVien(SinhVien sv) {
        danhSach.add(sv);
    }

    public void xuatDanhSach() {
        if (danhSach.size() == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("\n==========================================================");
        System.out.printf("%-10s %-25s %-10s %-10s %-10s%n",
                "Ma SV", "Ho ten", "Diem LT", "Diem TH", "Diem TB");
        System.out.println("==========================================================");

        for (SinhVien sv : danhSach) {
            sv.xuat();
        }
    }

    public SinhVien timTheoMa(int ma) {
        for (SinhVien sv : danhSach) {
            if (sv.getMaSinhVien() == ma) {
                return sv;
            }
        }
        return null;
    }

    public boolean xoaSinhVien(int ma) {
        SinhVien sv = timTheoMa(ma);
        if (sv != null) {
            danhSach.remove(sv);
            return true;
        }
        return false;
    }

    public boolean suaSinhVien(int ma, String hoTen, double diemLT, double diemTH) {
        SinhVien sv = timTheoMa(ma);
        if (sv != null) {
            sv.setHoTen(hoTen);
            sv.setDiemLT(diemLT);
            sv.setDiemTH(diemTH);
            return true;
        }
        return false;
    }

    public int soLuongSinhVien() {
        return danhSach.size();
    }

    public void sapXepDiemTangDan() {
        danhSach.sort((a, b) -> Double.compare(a.getDiemTB(), b.getDiemTB()));
    }
}