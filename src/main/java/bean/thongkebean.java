package bean;

public class thongkebean {
	private String tensua;
	private long tongsoluongmua;
	private String anh;
	public thongkebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public thongkebean(String tensua, long tongsoluongmua, String anh) {
		super();
		this.tensua = tensua;
		this.tongsoluongmua = tongsoluongmua;
		this.anh = anh;
	}
	public String getTensua() {
		return tensua;
	}
	public void setTensua(String tensua) {
		this.tensua = tensua;
	}
	public long getTongsoluongmua() {
		return tongsoluongmua;
	}
	public void setTongsoluongmua(long tongsoluongmua) {
		this.tongsoluongmua = tongsoluongmua;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	@Override
	public String toString() {
		return "thongkebean [tensua=" + tensua + ", tongsoluongmua=" + tongsoluongmua + ", anh=" + anh + "]";
	}
	
	
}
