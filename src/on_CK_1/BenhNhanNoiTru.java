package on_CK_1;

import java.time.LocalDate;

public class BenhNhanNoiTru extends BenhNhan {

	private int songaynamvien;
	
	
	
	public int getSongaynamvien() {
		return songaynamvien;
	}

	public void setSongaynamvien(int songaynamvien) {
		if(songaynamvien <=0 )
			throw new IllegalArgumentException("So ngay nam vien phai > 0");
		this.songaynamvien = songaynamvien;
	}
	public BenhNhanNoiTru() {
		super();              
		this.songaynamvien = 1; 
	}

	public BenhNhanNoiTru(String hoTen, String soDT, String maBN, LocalDate ngayphatBenh,
			TinhTrang tinhtrang, int songaynamvien) {
		super(hoTen, soDT, maBN, ngayphatBenh, tinhtrang);
		setSongaynamvien(songaynamvien);
	}
	@Override
	public double getTienPhaiTra() {
		return songaynamvien * 100000;
	}

	@Override
	public String toString() {
		return super.toString() + " " +  "BenhNhanNoiTru [songaynamvien=" + songaynamvien + "]";
	}

	
}
