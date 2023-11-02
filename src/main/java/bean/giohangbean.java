package bean;

public class giohangbean {
	private String masua;
	private String tensua;
	private long soluong;
	private long gia;
	private String anh;
	private long thanhtien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String masua, String tensua, long soluong, long gia, String anh, long thanhtien) {
		super();
		this.masua = masua;
		this.tensua = tensua;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.thanhtien = thanhtien;
	}
	
	
	public giohangbean(String masua, String tensua, long soluong, long gia, String anh) {
		super();
		this.masua = masua;
		this.tensua = tensua;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
	}
	
	
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMasua() {
		return masua;
	}
	public void setMasua(String masua) {
		this.masua = masua;
	}
	public String getTensua() {
		return tensua;
	}
	public void setTensua(String tensua) {
		this.tensua = tensua;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return soluong*gia;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	@Override
	public String toString() {
		return "giohangbean [masua=" + masua + ", tensua=" + tensua + ", soluong=" + soluong + ", gia=" + gia
				+ ", thanhtien=" + thanhtien + "]";
	}
	
	
}
