package bean;

public class danhsachchuyentienbean {
	private String matk;
	private String tensua;
	private long soluongmua;
	private long gia;
	private long thanhtien;
	private boolean damua;
	public danhsachchuyentienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public danhsachchuyentienbean(String matk, String tensua, long soluongmua, long gia, long thanhtien, boolean damua) {
		super();
		this.matk = matk;
		this.tensua = tensua;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public String getTensua() {
		return tensua;
	}
	public void setTensua(String tensua) {
		this.tensua = tensua;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	@Override
	public String toString() {
		return "danhsachchuyentienbean [matk=" + matk + ", tensua=" + tensua + ", soluongmua=" + soluongmua + ", gia=" + gia
				+ ", thanhtien=" + thanhtien + ", damua=" + damua + "]";
	}
}
