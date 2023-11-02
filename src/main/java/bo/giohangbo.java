package bo;

import java.util.ArrayList;
import java.util.Collection;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds=
			   new ArrayList<giohangbean>();
	   public void GHThem(String masua, String tensua, long soluong, long gia ,
			   String anh) {
		   for(giohangbean h: ds)
			   if(h.getMasua().equals(masua)) {
				   h.setSoluong(h.getSoluong()+ soluong);
				   return;
			   }
		   ds.add(new giohangbean(masua, tensua, soluong, gia, anh));
	   }
	   public long Tongtien() {
		   long s=0;
		   for(giohangbean h: ds)
			   s=s+h.getThanhtien();
		   return s;
	   }

	   public void GHXoa(String masua) {
		  
		   for(giohangbean h: ds)
			   if(h.getMasua().equals(masua)) {
				   ds.remove(h);
				   return;
	   }
	   
	   }
}
