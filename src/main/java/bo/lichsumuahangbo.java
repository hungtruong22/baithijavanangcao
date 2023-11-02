package bo;

import java.util.ArrayList;

import bean.giohangbean;
import bean.lichsumuahangbean;
import bean.suabean;
import dao.lichsumuahangdao;

public class lichsumuahangbo {
	lichsumuahangdao lsdao= new lichsumuahangdao();
	   ArrayList<lichsumuahangbean> ds;
	   public ArrayList<lichsumuahangbean> HienThi(String tkid){
		   return lsdao.HienThi(tkid);
	   }
	   public String KHmuanhieunhat() {
		   return lsdao.KHmuanhieunhat();
	   }
	   
	   public long Tongtienthongke() {
		   return lsdao.Tongtienthongke();
	   }
	   public long Slhoadonbanduoc() {
		   return lsdao.Slhoadonbanduoc();
	   }
	   
	  
	   
	   public static void main(String[] args) {
		  lichsumuahangbo lsbo = new lichsumuahangbo();
		  System.out.println(lsbo.KHmuanhieunhat());
		  System.out.println(lsbo.Tongtienthongke());
		  System.out.println(lsbo.Slhoadonbanduoc());
	}
}
