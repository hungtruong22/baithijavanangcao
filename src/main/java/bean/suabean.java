package bean;

import java.util.Date;

public class suabean {
	private String masua;
	private String tensua;
	private long soluong;
	private long gia;
	private String anh;
	private String thongtin;
	private String maloai;
	private String tenncc;
	private Date ngaynhap;
	public suabean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public suabean(String masua, String tensua, long soluong, long gia, String anh, String thongtin, String maloai,
			String tenncc, Date ngaynhap) {
		super();
		this.masua = masua;
		this.tensua = tensua;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.thongtin = thongtin;
		this.maloai = maloai;
		this.tenncc = tenncc;
		this.ngaynhap = ngaynhap;
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
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getThongtin() {
		return thongtin;
	}
	public void setThongtin(String thongtin) {
		this.thongtin = thongtin;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getTenncc() {
		return tenncc;
	}
	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	@Override
	public String toString() {
		return "suabean [masua=" + masua + ", tensua=" + tensua + ", soluong=" + soluong + ", gia=" + gia + ", anh="
				+ anh + ", thongtin=" + thongtin + ", maloai=" + maloai + ", tenncc=" + tenncc + ", ngaynhap="
				+ ngaynhap + "]";
	}
	
	
}
