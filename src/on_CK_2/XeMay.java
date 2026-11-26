package on_CK_2;

import java.time.LocalDate;

public class XeMay extends XeThue {

	private int dungtichxilanh;

	public XeMay() {
		super();
		this.dungtichxilanh = 110;
	}

	public XeMay(String maXe, String tenXe, LocalDate ngayThue,
			int songayThue, double giaThue, int dungtichxilanh) {
		super(maXe, tenXe, ngayThue, songayThue, giaThue);
		setDungtichxilanh(dungtichxilanh);
	}

	public int getDungtichxilanh() {
		return dungtichxilanh;
	}

	public void setDungtichxilanh(int dungtichxilanh) {
		if (dungtichxilanh <= 0)
			throw new IllegalArgumentException("Dung tich phai lon hon 0");
		this.dungtichxilanh = dungtichxilanh;
	}

	@Override
	public double tinhTienThue() {
		double tien = getSongayThue() * getGiaThue();
		if (dungtichxilanh > 150)
			tien += 50000;
		return tien;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("  Xe may %dcc", dungtichxilanh);
	}
}