package bean;

import java.util.Date;

public class xacnhanbean {
	private String macthd;
	private String tendn;
	private String tensua;
	private Date ngaymua;
	private long soluongmua;
	private long gia;
	private long thanhtien;
	private boolean damua;
	public xacnhanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xacnhanbean(String macthd, String tendn, String tensua, Date ngaymua, long soluongmua, long gia,
			long thanhtien, boolean damua) {
		super();
		this.macthd = macthd;
		this.tendn = tendn;
		this.tensua = tensua;
		this.ngaymua = ngaymua;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}
	public String getMacthd() {
		return macthd;
	}
	public void setMacthd(String macthd) {
		this.macthd = macthd;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getTensua() {
		return tensua;
	}
	public void setTensua(String tensua) {
		this.tensua = tensua;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
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
		return "xacnhanbean [macthd=" + macthd + ", tendn=" + tendn + ", tensua=" + tensua + ", ngaymua=" + ngaymua
				+ ", soluongmua=" + soluongmua + ", gia=" + gia + ", thanhtien=" + thanhtien + ", damua=" + damua + "]";
	}
	
	
}
