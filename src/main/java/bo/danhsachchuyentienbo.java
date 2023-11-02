package bo;

import java.util.ArrayList;

import bean.danhsachchuyentienbean;
import dao.danhsachchuyentiendao;

public class danhsachchuyentienbo {
	danhsachchuyentiendao dsdao = new danhsachchuyentiendao();
	ArrayList<danhsachchuyentienbean> ds;

	public ArrayList<danhsachchuyentienbean> HienThiDS() {
		return dsdao.HienThiDS();
	}

}
