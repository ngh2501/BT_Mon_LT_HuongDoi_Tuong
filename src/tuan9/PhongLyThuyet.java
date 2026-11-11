package tuan9;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

	public boolean isCoMayChieu() {
		return coMayChieu;
	}
	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}

	public PhongLyThuyet() {
	}

	@Override
	public boolean datChuan() {
		return duAnhSang() && coMayChieu;
	}

	@Override
	public String toString() {
		return "PhongLyThuyet [coMayChieu=" + (coMayChieu ? "Co" : "Khong") + ", " + super.toString() + "]";
	}
}