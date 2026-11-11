package tuan9;

public class PhongThiNghiem extends PhongHoc {
	private String chuyenNganh;
	private int sucChua;
	private boolean coBonRua;

	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	public boolean isCoBonRua() {
		return coBonRua;
	}
	public void setCoBonRua(boolean coBonRua) {
		this.coBonRua = coBonRua;
	}

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh,
			int sucChua, boolean coBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.coBonRua = coBonRua;
	}

	public PhongThiNghiem() {
	}

	@Override
	public boolean datChuan() {
		return duAnhSang() && coBonRua;
	}

	@Override
	public String toString() {
		return "PhongThiNghiem [chuyenNganh=" + chuyenNganh + ", sucChua=" + sucChua + ", coBonRua="
				+ (coBonRua ? "Co" : "Khong") + ", " + super.toString() + "]";
	}
}