package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.lichsumuahangbean;
import bean.loaibean;
import bean.taikhoanbean;
import bean.thongkebean;
import bo.lichsumuahangbo;
import bo.loaibo;
import bo.thongkebo;

/**
 * Servlet implementation class thongkeController
 */
@WebServlet("/thongkeController")
public class thongkeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thongkeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loaibo lbo=new loaibo();
			thongkebo tkbo = new thongkebo();
			
			ArrayList<loaibean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai); 
			
			
			HttpSession session=request.getSession();
			taikhoanbean tk=(taikhoanbean)session.getAttribute("dn");
			if(tk==null) {
				response.sendRedirect("dangnhapController");
			}else {
				lichsumuahangbo lsbo= new lichsumuahangbo();
				String khmuanhieunhat = lsbo.KHmuanhieunhat();
				long tongtien = lsbo.Tongtienthongke();
				long slhoadon = lsbo.Slhoadonbanduoc();
				
				ArrayList<thongkebean> dsbanchay = tkbo.dssuabanchay();
				ArrayList<thongkebean> dsbancham = tkbo.dssuabancham();
				
					request.setAttribute("dsbanchay", dsbanchay);
					request.setAttribute("dsbancham", dsbancham);
					request.setAttribute("khmuanhieunhat", khmuanhieunhat);
					request.setAttribute("tongtien", tongtien);
					request.setAttribute("slhoadon", slhoadon);
					
				RequestDispatcher rd= request.getRequestDispatcher("./view/admin/thongke.jsp");
				rd.forward(request, response);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
