package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsumuahangbean;
import bean.thongkebean;

public class thongkedao {
	public ArrayList<thongkebean> dssuabanchay(){
		ArrayList<thongkebean> dssuabanchay = new ArrayList<thongkebean>();
			try {
				KetNoi kn = new KetNoi();
				kn.KetNoi();
				
				String sql="select viewlsmh.tensua,sum(soluongmua), sua.anh \r\n"
						+ "						from viewlsmh join sua\r\n"
						+ "						on viewlsmh.tensua = sua.tensua\r\n"
						+ "						where damua = 1\r\n"
						+ "						group by viewlsmh.tensua, sua.anh\r\n"
						+ "						having sum(soluongmua) >= all (\r\n"
						+ "														select sum(soluongmua) \r\n"
						+ "														from viewlsmh join sua\r\n"
						+ "														on viewlsmh.tensua = sua.tensua\r\n"
						+ "														where damua = 1\r\n"
						+ "														group by viewlsmh.tensua\r\n"
						+ "						)";
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    		ResultSet rs = cmd.executeQuery();
	    		while(rs.next()) {
	    			String tensua = rs.getString(1);
	    			long tongsl = rs.getLong(2);
	    			String anh = rs.getString(3);
	    			dssuabanchay.add(new thongkebean(tensua, tongsl, anh));
	    		}
	    		
	    		rs.close();
				kn.cn.close();
				return dssuabanchay;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public ArrayList<thongkebean> dssuabancham(){
		ArrayList<thongkebean> dssuabancham = new ArrayList<thongkebean>();
			try {
				KetNoi kn = new KetNoi();
				kn.KetNoi();
				
				String sql="select viewlsmh.tensua,sum(soluongmua), sua.anh \r\n"
						+ "						from viewlsmh join sua\r\n"
						+ "						on viewlsmh.tensua = sua.tensua\r\n"
						+ "						where damua = 1\r\n"
						+ "						group by viewlsmh.tensua, sua.anh\r\n"
						+ "						having sum(soluongmua) <= all (\r\n"
						+ "														select sum(soluongmua) \r\n"
						+ "														from viewlsmh join sua\r\n"
						+ "														on viewlsmh.tensua = sua.tensua\r\n"
						+ "														where damua = 1\r\n"
						+ "														group by viewlsmh.tensua\r\n"
						+ "						)";
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    		ResultSet rs = cmd.executeQuery();
	    		while(rs.next()) {
	    			String tensua = rs.getString(1);
	    			long tongsl = rs.getLong(2);
	    			String anh = rs.getString(3);
	    			dssuabancham.add(new thongkebean(tensua, tongsl, anh));
	    		}
	    		
	    		rs.close();
				kn.cn.close();
				return dssuabancham;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public static void main(String[] args) {
		thongkedao tk = new thongkedao();
		System.out.println(tk.dssuabancham());
	}
}
