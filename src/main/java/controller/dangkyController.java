package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.taikhoanbean;
import bo.loaibo;
import bo.suabo;
import bo.taikhoanbo;
import dao.taikhoandao;

/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		suabo sbo = new suabo();
		loaibo lbo = new loaibo();
		taikhoanbo tkbo = new taikhoanbo();
		taikhoandao tkdao = new taikhoandao();
		String tendn = request.getParameter("user");
		String matkhau = request.getParameter("pass");
		String nhaplaimatkhau = request.getParameter("repass");
		
		if(!matkhau.equals(nhaplaimatkhau)) {
			response.sendRedirect("./view/web/dangnhap.jsp");
		}
		else {
			taikhoanbean tk = tkbo.kiemtrataikhoantontai(tendn);
			if(tk == null) { // tai khoan chua co thi dc dang ky
				tkbo.signup(tendn, matkhau);
				response.sendRedirect("htsua");
			}
			else {
				response.sendRedirect("./view/web/dangnhap.jsp");
			}
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
