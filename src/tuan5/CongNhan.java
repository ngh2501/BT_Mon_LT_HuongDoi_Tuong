package tuan5;

public class CongNhan {
		private String mHo;
		private String mTen;
		private int mSoSP;
		private String maCN;
		
		public CongNhan() {
			this.maCN="";			
			this.mHo="";
			this.mTen="";
			this.mSoSP= 1;
		}
		public CongNhan(String maCN, String mHo, String mTen, int mSoSP) {
			this.maCN=maCN;
			this.mHo=mHo;
			this.mTen=mTen;
			this.mSoSP=mSoSP;
		}
		public int getSoSanPham() {
		    return mSoSP;
		}

		public String getMaCN() {
			return maCN;
		}
	
		public void setMaCN(String maCN) {
			this.maCN = maCN;
		}

		public String getmHo() {
			return mHo;
		}
	
		public void setmHo(String mHo) {
			this.mHo = mHo;
		}

		public String getmTen() {
			return mTen;
		}

		public void setmTen(String mTen) {
			this.mTen = mTen;
		}

		public int getmSoSP() {
			return mSoSP;
		}

		public void setmSoSP(int mSoSP) {
			this.mSoSP = mSoSP;
		}
		public double TinhLuong() {
			double price = 0;
			if (mSoSP >= 600) 
				price = 0.65;
			if (mSoSP >= 400 && mSoSP <= 599)
				price = 0.6;
			if (mSoSP >= 200 && mSoSP <= 399)
				price =0.55;
			if (mSoSP >= 1 && mSoSP <= 199)
				price =0.5;
		return mSoSP * price;
		}
		
		@Override
		public String toString() {
		return "MaCongNhan" + maCN +
			   "Ho" + mHo +
			   "Ten" + mTen +
			   "SoSP" + mSoSP +
			   "Luong" + TinhLuong();
		}
}