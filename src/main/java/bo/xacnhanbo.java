package bo;

import dao.xacnhandao;

import java.util.ArrayList;

import bean.xacnhanbean;

public class xacnhanbo {
	xacnhandao xndao = new xacnhandao();

	public ArrayList<xacnhanbean> getdanhsach() {
		return xndao.getdanhsach();
	}

	public void UpdateDaMua(long mact) {
		for (xacnhanbean xn : xndao.getdanhsach()) {
			if (Long.parseLong(xn.getMacthd()) == (mact)) {
				xndao.UpdateDamua(mact);
			}
		}
	}
	
	public static void main(String[] args) {
		xacnhanbo xnbo = new xacnhanbo();
		xnbo.UpdateDaMua(13);
	}
}
