package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.suabean;

public class suadao {
	public ArrayList<suabean> getSua(){
		ArrayList<suabean> ds = new ArrayList<suabean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from sua";
    		PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String masua=rs.getString("masua");
				String tensua=rs.getString("tensua");
				long soluong=rs.getLong("soluong");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				String thongtin =rs.getString("thongtin");
				String maloai=rs.getString("maloai");
				String tenncc=rs.getString("tenncc");
				Date ngaynhap=rs.getDate("ngaynhap");
				ds.add(new suabean(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc, ngaynhap));
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public suabean getNewMilk() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql = "select top 1 * from sua\r\n"
					+ "order by masua desc";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String masua=rs.getString("masua");
				String tensua=rs.getString("tensua");
				long soluong=rs.getLong("soluong");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				String thongtin =rs.getString("thongtin");
				String maloai=rs.getString("maloai");
				String tenncc=rs.getString("tenncc");
				Date ngaynhap=rs.getDate("ngaynhap");
				return new suabean(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc, ngaynhap);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<suabean> getSuaByCategory(String loaiid){
		ArrayList<suabean> ds = new ArrayList<suabean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from sua\r\n"
    				+ "where maloai=?;";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, loaiid);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String masua=rs.getString("masua");
				String tensua=rs.getString("tensua");
				long soluong=rs.getLong("soluong");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				String thongtin =rs.getString("thongtin");
				String maloai=rs.getString("maloai");
				String tenncc=rs.getString("tenncc");
				Date ngaynhap=rs.getDate("ngaynhap");
				ds.add(new suabean(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc, ngaynhap));
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public suabean getSuaById(String id){
		ArrayList<suabean> ds = new ArrayList<suabean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from sua\r\n"
    				+ "where masua=?;";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, id);		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String masua=rs.getString("masua");
				String tensua=rs.getString("tensua");
				long soluong=rs.getLong("soluong");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				String thongtin =rs.getString("thongtin");
				String maloai=rs.getString("maloai");
				String tenncc=rs.getString("tenncc");
				Date ngaynhap=rs.getDate("ngaynhap");
				return new suabean(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc, ngaynhap);
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<suabean> searchByName(String ts){
		ArrayList<suabean> ds = new ArrayList<suabean>();
		try {
			//B1: ket noi vao csdl QlSach
    		KetNoi kn = new KetNoi();
    		kn.KetNoi();
    		
    		//B2: lay du lieu ve
    		String sql = "select * from sua\r\n"
    				+ "where tensua like ? ";
    		PreparedStatement cmd = null;
    		cmd = kn.cn.prepareStatement(sql);
    		cmd.setString(1, "%"+ts+"%");		
    		ResultSet rs = cmd.executeQuery();
    		
    		//B3: Duyet rs de luu vao
    		while(rs.next()) {
    			// lay ve maloai a tenloai
    			String masua=rs.getString("masua");
				String tensua=rs.getString("tensua");
				long soluong=rs.getLong("soluong");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				String thongtin =rs.getString("thongtin");
				String maloai=rs.getString("maloai");
				String tenncc=rs.getString("tenncc");
				Date ngaynhap=rs.getDate("ngaynhap");
				ds.add(new suabean(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc, ngaynhap));
    		}
    		
    		//B4: Dong cac doi tuong
    		rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void xoa(String suaid) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "delete from sua\r\n"
					+ "where masua = ?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, suaid);		
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void them(String masua, String tensua, long soluong, long gia
			, String anh, String thongtin, String maloai, String tenncc, String ngaynhap) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			DateFormat d= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date doi= d.parse(ngaynhap);
			java.sql.Date nn=new java.sql.Date(doi.getTime());
			String sql="insert into sua(masua,tensua,soluong,gia,anh,thongtin,maloai,tenncc,ngaynhap)\r\n"
					+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, masua);
			cmd.setString(2, tensua);
			cmd.setLong(3, soluong);
			cmd.setLong(4, gia);
			cmd.setString(5, anh);
			cmd.setString(6, thongtin);
			cmd.setString(7, maloai);
			cmd.setString(8, tenncc);
			cmd.setDate(9, nn);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sua(String masua, String tensua, long soluong, long gia
			, String anh, String thongtin, String maloai, String tenncc) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="update sua\r\n"
					+ "set tensua=?, soluong=?, gia=?,\r\n"
					+ " anh=?, thongtin=?, maloai=?, tenncc=?\r\n"
					+ " where masua=?";
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tensua);
			cmd.setLong(2, soluong);
			cmd.setLong(3, gia);
			cmd.setString(4, anh);
			cmd.setString(5, thongtin);
			cmd.setString(6, maloai);
			cmd.setString(7, tenncc);
			cmd.setString(8, masua);
			cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTotalMilk() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select count(*) from sua";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			return rs.getInt(1);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ArrayList<suabean> pagingMilk(int index){
		ArrayList<suabean> list = new ArrayList<suabean>();
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select * from sua\r\n"
					+ "order by masua\r\n"
					+ "offset ? rows fetch next 6 rows only";
			
			PreparedStatement cmd = null;
			cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, (index-1)*6);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			String masua=rs.getString("masua");
				String tensua=rs.getString("tensua");
				long soluong=rs.getLong("soluong");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				String thongtin =rs.getString("thongtin");
				String maloai=rs.getString("maloai");
				String tenncc=rs.getString("tenncc");
				Date ngaynhap=rs.getDate("ngaynhap");
				list.add(new suabean(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc, ngaynhap));
    		}
    		rs.close();
			kn.cn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		suadao sdao = new suadao();
		System.out.println(sdao.pagingMilk(1));
	}
}
