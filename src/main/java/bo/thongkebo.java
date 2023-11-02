package bo;

import java.util.ArrayList;

import bean.thongkebean;
import dao.thongkedao;

public class thongkebo {
	thongkedao tkdao = new thongkedao();
	ArrayList<thongkebean> ds;
	public ArrayList<thongkebean> dssuabanchay(){
		return tkdao.dssuabanchay();
	}
	
	public ArrayList<thongkebean> dssuabancham(){
		return tkdao.dssuabancham();
	}
	
	public static void main(String[] args) {
		thongkebo tk = new thongkebo();
		ArrayList<thongkebean> tk1 = tk.dssuabancham();
		for(thongkebean s : tk1) {
			System.out.println(s);
		}
	}
}
