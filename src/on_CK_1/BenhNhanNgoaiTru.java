package on_CK_1;

import java.time.LocalDate;

public class BenhNhanNgoaiTru extends BenhNhan{

	private double tiendichvu;
	
	
	

	public double getTiendichvu() {
		return tiendichvu;
	}

	public void setTiendichvu(double tiendichvu) {
		if(tiendichvu < 0 )
			throw new IllegalArgumentException("So tien dichvu phai >= 0");
		this.tiendichvu = tiendichvu;
	}

	public BenhNhanNgoaiTru(String hoTen, String soDT, String maBN, LocalDate ngayphatBenh, TinhTrang tinhtrang, double tiendichvu) {
		super(hoTen, soDT, maBN, ngayphatBenh, tinhtrang);
		setTiendichvu(tiendichvu);
	}
	

	@Override
	public double getTienPhaiTra() {
		return tiendichvu ;
	}

	@Override
	public String toString() {
		return super.toString() + " " + "BenhNhanNgoaiTru [tiendichvu=" + tiendichvu + "]";
	}
	
	
}
