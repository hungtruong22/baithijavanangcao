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

import bean.danhsachchuyentienbean;
import bean.loaibean;
import bo.danhsachchuyentienbo;
import bo.loaibo;

/**
 * Servlet implementation class danhsachchuyentienController
 */
@WebServlet("/danhsachchuyentienController")
public class danhsachchuyentienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public danhsachchuyentienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			loaibo lbo = new loaibo();

			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);

			HttpSession session = request.getSession();
			
			if (session.getAttribute("dn") == null)
				response.sendRedirect("dangnhapController");
			else {
				danhsachchuyentienbo dsbo = new danhsachchuyentienbo();
				ArrayList<danhsachchuyentienbean> dsct = dsbo.HienThiDS();
				if (dsct != null) {
					request.setAttribute("dschuyentien", dsct);
				}
				RequestDispatcher rd = request.getRequestDispatcher("./view/admin/danhsachkhct.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
