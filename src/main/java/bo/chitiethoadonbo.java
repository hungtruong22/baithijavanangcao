package bo;

import java.sql.PreparedStatement;

import dao.KetNoi;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao= new chitiethoadondao();
	  public int Them(String masua, long soluongmua, long maxmahd) {
		  return ctdao.Them(masua, soluongmua, maxmahd);
	  }
}
