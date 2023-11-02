package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.suabean;
import bo.loaibo;
import bo.suabo;

/**
 * Servlet implementation class htsua
 */
@WebServlet("/htsua")
public class htsua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htsua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
	     suabo sbo = new suabo();
	     loaibo lbo = new loaibo();
	     ArrayList<loaibean> dsloai = lbo.getloai();
	     request.setAttribute("dsloai", dsloai);
	     ArrayList<suabean> dssua = sbo.getSua();
	     request.setAttribute("dssua", dssua);
	     suabean last = sbo.getNewMilk();
	     request.setAttribute("last", last);
	     
	     String indexPage = request.getParameter("trang");
	     
	     	if(indexPage == null) {
	     		indexPage = "1";
	     	}
	     int trang = Integer.parseInt(indexPage);
	     
	     //b1: lấy về tổng số sữa có trong csdl
	     int dem = sbo.getTotalMilk();
			
			int endPage = dem/6;
			if(dem % 3 != 0) {
				endPage++;
			}
			
			ArrayList<suabean> dstrang = sbo.pagingMilk(trang);
			request.setAttribute("dstrang", dstrang);
			
			request.setAttribute("endPage", endPage);
			request.setAttribute("tag", trang);
			
	     RequestDispatcher rd = request.getRequestDispatcher("./view/web/htsua.jsp");
	       rd.forward(request, response);
	}

	/**	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
