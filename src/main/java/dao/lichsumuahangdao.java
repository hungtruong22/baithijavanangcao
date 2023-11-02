package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsumuahangbean;

public class lichsumuahangdao {
	public ArrayList<lichsumuahangbean> HienThi(String tkid) {
		ArrayList<lichsumuahangbean> ds= new ArrayList<lichsumuahangbean>();
	try {
		//B1: ket noi vao csdl QlSach
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		
		//B2: lay du lieu ve
		String sql = "select * from viewlsmh where matk=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tkid);
		ResultSet rs = cmd.executeQuery();
		
		//B3: Duyet rs de luu vao
		while(rs.next()) {
			// lay ve maloai a tenloai
			String matk=rs.getString("matk");
			String tensua=rs.getString("tensua");
			long soluongmua=rs.getLong("soluongmua");
			long gia = rs.getLong("gia");
			long thanhtien = rs.getLong("thanhtien");
			boolean damua = rs.getBoolean("damua");
			ds.add(new lichsumuahangbean(matk, tensua, soluongmua, gia, thanhtien, damua));
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
	
	

	
	public long Tongtienthongke() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select sum(thanhtien)\r\n"
					+ "from viewlsmh\r\n"
					+ "where damua = 1";
			
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			return rs.getLong(1);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String KHmuanhieunhat() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="select viewlsmh.matk, tendn, sum(soluongmua)\r\n"
					+ "from viewlsmh join taikhoan\r\n"
					+ "on viewlsmh.matk = taikhoan.matk\r\n"
					+ "where damua = 1\r\n"
					+ "group by viewlsmh.matk, tendn\r\n"
					+ "having sum(soluongmua) >= all (\r\n"
					+ "									select sum(soluongmua)\r\n"
					+ "									from viewlsmh join taikhoan\r\n"
					+ "									on viewlsmh.matk = taikhoan.matk\r\n"
					+ "									where damua = 1\r\n"
					+ "									group by viewlsmh.matk, tendn\r\n"
					+ "\r\n"
					+ ")";
			
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			return rs.getString(2);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public long Slhoadonbanduoc() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			String sql="select count(*)\r\n"
					+ "from viewlsmh\r\n"
					+ "where damua = 1;";
			
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
    		ResultSet rs = cmd.executeQuery();
    		while(rs.next()) {
    			return rs.getLong(1);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

	public static void main(String[] args) {
		lichsumuahangdao sldao = new lichsumuahangdao();
//		ArrayList<lichsumuahangbean> ds = sldao.HienThi("2");
//		for(lichsumuahangbean l : ds) {
//			System.out.println(l);
//		}
		System.out.println(sldao.KHmuanhieunhat());
	}
}
