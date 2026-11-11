package tuan02;

public class SinhVien {
    private int maSinhVien;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    public SinhVien() {
    }

    public SinhVien(int maSinhVien, String hoTen, double diemLT, double diemTH) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(double diemLT) {
        this.diemLT = diemLT;
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) {
        this.diemTH = diemTH;
    }

    public double getDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    public void xuat() {
        System.out.printf("%-10d %-25s %-10.2f %-10.2f %-10.2f%n",
                maSinhVien, hoTen, diemLT, diemTH, getDiemTB());
    }

 