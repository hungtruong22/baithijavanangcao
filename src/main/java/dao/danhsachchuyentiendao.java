package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.danhsachchuyentienbean;

public class danhsachchuyentiendao {
	public ArrayList<danhsachchuyentienbean> HienThiDS() {
		ArrayList<danhsachchuyentienbean> ds = new ArrayList<danhsachchuyentienbean>();
		try {
			// B1: ket noi vao csdl QlSach
			KetNoi kn = new KetNoi();
			kn.KetNoi();

			// B2: lay du lieu ve
			String sql = "select * from viewlsmh where damua = 1";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			// cmd.setLong(1, makh);
			ResultSet rs = cmd.executeQuery();

			// B3: Duyet rs de luu vao
			while (rs.next()) {
				// lay ve maloai a tenloai
				String matk = rs.getString("matk");
				String tensua = rs.getString("tensua");
				long soluongmua = rs.getLong("soluongmua");
				long gia = rs.getLong("gia");
				long thanhtien = rs.getLong("thanhtien");
				boolean damua = rs.getBoolean("damua");
				ds.add(new danhsachchuyentienbean(matk, tensua, soluongmua, gia, thanhtien, damua));
			}

			// B4: Dong cac doi tuong
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
