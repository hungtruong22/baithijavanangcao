package bean;

public class taikhoanbean {
	private String matk;
	private String tendn;
	private String matkhau;
	private boolean iscustomer;
	private boolean isadmin;
	public taikhoanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public taikhoanbean(String matk, String tendn, String matkhau, boolean iscustomer, boolean isadmin) {
		super();
		this.matk = matk;
		this.tendn = tendn;
		this.matkhau = matkhau;
		this.iscustomer = iscustomer;
		this.isadmin = isadmin;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public boolean isIscustomer() {
		return iscustomer;
	}
	public void setIscustomer(boolean iscustomer) {
		this.iscustomer = iscustomer;
	}
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	@Override
	public String toString() {
		return "taikhoanbean [matk=" + matk + ", tendn=" + tendn + ", matkhau=" + matkhau + ", iscustomer=" + iscustomer
				+ ", isadmin=" + isadmin + "]";
	}
	
	
}
