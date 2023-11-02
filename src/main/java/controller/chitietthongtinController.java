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
 * Servlet implementation class chitietthongtinController
 */
@WebServlet("/chitietthongtinController")
public class chitietthongtinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitietthongtinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		suabo sbo = new suabo();
		loaibo lbo = new loaibo();
		String sid = request.getParameter("sid");
		suabean milk = sbo.getSuaById(sid);
		request.setAttribute("milk", milk);
		String maloai = request.getParameter("maloai");
		ArrayList<suabean> list = sbo.getSuaByCategory(maloai);
		request.setAttribute("dssua", list);
		 ArrayList<loaibean> dsloai = lbo.getloai();
	     request.setAttribute("dsloai", dsloai);
	     suabean last = sbo.getNewMilk();
	     request.setAttribute("last", last);
	     request.setAttribute("maloai", maloai);
		RequestDispatcher rd = request.getRequestDispatcher("./view/web/thongtinchitiet.jsp");
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
