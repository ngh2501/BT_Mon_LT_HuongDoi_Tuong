package on_CK_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class XeThue implements ChoThue {

	private String maXe;
	private String tenXe;
	private LocalDate ngayThue;
	private int songayThue;
	private double giaThue;

	public XeThue() {
		this("XX00", "Chua co ten", LocalDate.now(), 1, 1000);
	}

	public XeThue(String maXe, String tenXe, LocalDate ngayThue, int songayThue, double giaThue) {
		setMaXe(maXe);
		setTenXe(tenXe);
		setNgayThue(ngayThue);
		setSongayThue(songayThue);
		setGiaThue(giaThue);
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		if (maXe == null || maXe.trim().isEmpty())
			throw new IllegalArgumentException("Ma xe khong duoc rong!");
		this.maXe = maXe.trim();
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		if (tenXe == null || tenXe.trim().isEmpty())
			throw new IllegalArgumentException("Ten xe khong duoc rong!");
		this.tenXe = tenXe.trim();
	}

	public LocalDate getNgayThue() {
		return ngayThue;
	}

	public void setNgayThue(LocalDate ngayThue) {
		if (ngayThue == null || ngayThue.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("Ngay thue khong duoc sau ngay hien tai");
		this.ngayThue = ngayThue;
	}

	public int getSongayThue() {
		return songayThue;
	}

	public void setSongayThue(int songayThue) {
		if (songayThue <= 0)
			throw new IllegalArgumentException("So ngay thue phai lon hon 0");
		this.songayThue = songayThue;
	}

	public double getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(double giaThue) {
		if (giaThue <= 0)
			throw new IllegalArgumentException("Gia thue phai lon hon 0");
		this.giaThue = giaThue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maXe.toUpperCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		XeThue other = (XeThue) obj;
		return maXe.equalsIgnoreCase(other.maXe);
	}

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%-5s %-18s %-11s %3d %,10.0f %,12.0f",
				maXe, tenXe, ngayThue.format(df), songayThue, giaThue, tinhTienThue());
	}

	public static String tieuDe() {
		return String.format("%-5s %-18s %-11s %3s %10s %12s",
				"MA", "TEN XE", "NGAY THUE", "SN", "GIA/NGAY", "TIEN THUE");
	}
}