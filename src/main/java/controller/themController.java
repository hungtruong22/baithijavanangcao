package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;
import bo.suabo;

/**
 * Servlet implementation class themController
 */
@WebServlet("/themController")
public class themController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themController() {
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
		
		String mahang = request.getParameter("mahang");
		String tenhang = request.getParameter("tenhang");
		long slhang = Long.parseLong(request.getParameter("slhang"));
		long giahang = Long.parseLong(request.getParameter("giahang"));
		String anhhang = request.getParameter("anhhang");
		String thongtinhang = request.getParameter("thongtinhang");
		String loaihang = request.getParameter("loaihang");
		String tenncchang = request.getParameter("tenncchang");
		String ngaynhaphang = request.getParameter("ngaynhaphang");
					
		HttpSession session= request.getSession();
		session.getAttribute("dn");
		sbo.them(mahang, tenhang, slhang, giahang, anhhang, thongtinhang, loaihang, tenncchang, ngaynhaphang);
		response.sendRedirect("quanlysuaController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
