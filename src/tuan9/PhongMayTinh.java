package tuan9;

public class PhongMayTinh extends PhongHoc {
	private int soMayTinh;

	public int getSoMayTinh() {
		return soMayTinh;
	}
	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public PhongMayTinh() {
	}

	// Trung binh 1.5m2 dat 1 may => soMayTinh * 1.5 <= dienTich
	@Override
	public boolean datChuan() {
		return duAnhSang() && soMayTinh * 1.5 <= dienTich;
	}

	@Override
	public String toString() {
		return "PhongMayTinh [soMayTinh=" + soMayTinh + ", " + super.toString() + "]";
	}
}