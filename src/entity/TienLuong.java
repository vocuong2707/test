package entity;

public class TienLuong {
	private String maLuong;
	private double mucLuong;
	private ChamCongCN chamCongCN;
	private ChamCongNV chamCongNV;

	public TienLuong() {
		super();
	}

	public TienLuong(String maLuong) {
		super();
		this.maLuong = maLuong;
	}

	public TienLuong(String maLuong, double mucLuong, ChamCongCN chamCongCN, ChamCongNV chamCongNV) {
		super();
		this.maLuong = maLuong;
		this.mucLuong = mucLuong;
		this.chamCongCN = chamCongCN;
		this.chamCongNV = chamCongNV;
	}

	public String getMaLuong() {
		return maLuong;
	}

	public void setMaLuong(String maLuong) {
		this.maLuong = maLuong;
	}

	public double getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(double mucLuong) {
		this.mucLuong = mucLuong;
	}

	public ChamCongCN getChamCongCN() {
		return chamCongCN;
	}

	public void setChamCongCN(ChamCongCN chamCongCN) {
		this.chamCongCN = chamCongCN;
	}

	public ChamCongNV getChamCongNV() {
		return chamCongNV;
	}

	public void setChamCongNV(ChamCongNV chamCongNV) {
		this.chamCongNV = chamCongNV;
	}

	@Override
	public String toString() {
		return "TienLuong [maLuong=" + maLuong + ", mucLuong=" + mucLuong + ", chamCongCN=" + chamCongCN
				+ ", chamCongNV=" + chamCongNV + "]";
	}

}
