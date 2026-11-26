package on_CK_2;

import java.time.LocalDate;

public class Oto extends XeThue {

	private int soCho;
	private NhienLieu nhienLieu;

	public Oto() {
		super();
		this.soCho = 4;
		this.nhienLieu = NhienLieu.XANG;
	}

	public Oto(String maXe, String tenXe, LocalDate ngayThue, int songayThue,
			double giaThue, int soCho, NhienLieu nhienLieu) {
		super(maXe, tenXe, ngayThue, songayThue, giaThue);
		setSoCho(soCho);
		setNhienLieu(nhienLieu);
	}

	public int getSoCho() {
		return soCho;
	}

	public void setSoCho(int soCho) {
		if (soCho != 4 && soCho != 7)
			throw new IllegalArgumentException("So cho chi nhan 4 hoac 7");
		this.soCho = soCho;
	}

	public NhienLieu getNhienLieu() {
		return nhienLieu;
	}

	public void setNhienLieu(NhienLieu nhienLieu) {
		if (nhienLieu == null)
			throw new IllegalArgumentException("Nhien lieu khong duoc rong");
		this.nhienLieu = nhienLieu;
	}

	@Override
	public double tinhTienThue() {
		double tien = getSongayThue() * getGiaThue();
		if (soCho == 7)
			tien += 200000;
		if (nhienLieu == NhienLieu.DIEN)
			tien = tien * 0.9;
		return tien;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("  O to %d cho, %s", soCho, nhienLieu);
	}
}