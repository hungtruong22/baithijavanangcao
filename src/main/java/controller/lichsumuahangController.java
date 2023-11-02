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
import bo.lichsumuahangbo;
import bo.loaibo;

/**
 * Servlet implementation class lichsumuahangController
 */
@WebServlet("/lichsumuahangController")
public class lichsumuahangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsumuahangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loaibo lbo=new loaibo();
			
			ArrayList<loaibean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai); 			
			HttpSession session=request.getSession();
			taikhoanbean tk=(taikhoanbean)session.getAttribute("dn");
			if(tk==null) {
				response.sendRedirect("dangnhapController");
			}else {
				lichsumuahangbo lsbo= new lichsumuahangbo();
				ArrayList<lichsumuahangbean> ls = lsbo.HienThi(tk.getMatk());
				if (ls != null) {
					request.setAttribute("dslichsu", ls);
				}
				
				RequestDispatcher rd= request.getRequestDispatcher("./view/web/lichsumuahang.jsp");
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
