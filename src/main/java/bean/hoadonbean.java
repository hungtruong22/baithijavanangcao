package bean;

import java.util.Date;

public class hoadonbean {
	private String mahd;
	private String matk;
	private Date ngaymua;
	private boolean damua;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(String mahd, String matk, Date ngaymua, boolean damua) {
		super();
		this.mahd = mahd;
		this.matk = matk;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	@Override
	public String toString() {
		return "hoadonbean [mahd=" + mahd + ", matk=" + matk + ", ngaymua=" + ngaymua + ", damua=" + damua + "]";
	}
	
	
}
