package dao;

import java.sql.PreparedStatement;

public class chitiethoadondao {
	public int Them(String masua, long soluongmua, long maxmahd) {
		try {
			KetNoi kn= new KetNoi();
			kn.KetNoi();
			String sql="insert into chitiethoadon(masua,soluongmua, mahd,damua) values(?,?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, masua);
			cmd.setLong(2, soluongmua);
			cmd.setLong(3, maxmahd);
			cmd.setBoolean(4, false);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
	}
}
