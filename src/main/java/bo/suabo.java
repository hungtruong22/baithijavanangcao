package bo;

import java.util.ArrayList;

import bean.suabean;
import dao.suadao;


public class suabo {
	suadao sdao= new suadao();
	   ArrayList<suabean> ds;
	   public ArrayList<suabean> getSua(){
		   ds=sdao.getSua();
		   return ds;
	   }
	   public suabean getNewMilk() {
		   return sdao.getNewMilk();
	   }
	   public ArrayList<suabean> getSuaByCategory(String loaiid){
		   return sdao.getSuaByCategory(loaiid);
	   }
	   public suabean getSuaById(String id) {
		   return sdao.getSuaById(id);
	   }
	   public ArrayList<suabean> searchByName(String ts){
		   return sdao.searchByName(ts);
	   }
	   public void xoa(String suaid) {
		   sdao.xoa(suaid);
	   }
	   public void them(String masua, String tensua, long soluong, long gia
			, String anh, String thongtin, String maloai, String tenncc, String ngaynhap) {
		   sdao.them(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc, ngaynhap);
	   }
	   public void sua(String masua, String tensua, long soluong, long gia
			, String anh, String thongtin, String maloai, String tenncc) {
		   sdao.sua(masua, tensua, soluong, gia, anh, thongtin, maloai, tenncc);
	   }
	   public int getTotalMilk() {
		   return sdao.getTotalMilk();
	   }
	   public ArrayList<suabean> pagingMilk(int index){
		   return sdao.pagingMilk(index);
	   }
	   
	   public static void main(String[] args) {
		 suabo sbo = new suabo();
		 ArrayList<suabean> ds = sbo.pagingMilk(3);
		 for(suabean s: ds) {
			 System.out.println(s);
		 }
	}
}
