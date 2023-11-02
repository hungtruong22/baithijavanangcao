package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.xacnhanbean;

public class xacnhandao {
	public ArrayList<xacnhanbean> getdanhsach() {
		ArrayList<xacnhanbean> ds= new ArrayList<xacnhanbean>();
		try {
			KetNoi kn= new KetNoi();
			kn.KetNoi();
			String sql="select * from viewxacnhan";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			ResultSet rs= cmd.executeQuery();
			xacnhanbean xn= null;
			while(rs.next()) {
				String macthd= rs.getString("macthd");
				String tendn=rs.getString("tendn");
				String tensua=rs.getString("tensua");
				Date ngaymua=rs.getDate("ngaymua");
				long soluongmua=rs.getLong("soluongmua");
				long gia=rs.getLong("gia");
				long thanhtien=rs.getLong("thanhtien");
				boolean damua=rs.getBoolean("damua");
				ds.add(new xacnhanbean(macthd, tendn, tensua, ngaymua, soluongmua, gia, thanhtien, damua));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	 public void UpdateDamua(long mact) {
	      try {
	    	  KetNoi kn= new KetNoi();
	  		kn.KetNoi();
	  		String sql="update chitiethoadon set damua = 1 where macthd = ?";
	  		PreparedStatement cmd= kn.cn.prepareStatement(sql);
	  		cmd.setLong(1, mact);
	  		cmd.executeUpdate();
	  		kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	    }
	 
	 public static void main(String[] args) {
		xacnhandao xndao = new xacnhandao();
		ArrayList<xacnhanbean> dsxn = xndao.getdanhsach();
		for(xacnhanbean s : dsxn) {
			System.out.println(s);
		}
	}
}
