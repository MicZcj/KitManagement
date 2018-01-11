package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Admin;

/**
 * Servlet implementation class Admin_Userchangeps
 */
@WebServlet("/Admin_Userchangeps.do")
public class Admin_Userchangeps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Userchangeps() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String adminid = request.getParameter("id");
		String adminpassword="123";
		Admin admin=new Admin();
		admin.setAdminID(Integer.parseInt(adminid));
		admin.setAdminPassword(adminpassword);
		AdminDao dao = new AdminDao();
		boolean result = dao.changeAdminps(admin);
		request.setAttribute("alert", "<script type=\"text/javascript\">alert(\"重置成功！\");</script>");
		RequestDispatcher rd = request.getRequestDispatcher("AdminShowAll.do");
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
