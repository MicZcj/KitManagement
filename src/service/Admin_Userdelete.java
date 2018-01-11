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
 * Servlet implementation class Admin_Userdelete
 */
@WebServlet("/Admin_Userdelete.do")
public class Admin_Userdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Userdelete() {
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
		String id = request.getParameter("id");
		int adminid= Integer.parseInt(id);
		AdminDao dao = new AdminDao();
		boolean result = dao.deleteAdmin(adminid);
		if (result == true) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminShowAll.do");
			request.setAttribute("alert", "<script type=\"text/javascript\">alert(\"删除成功！\");</script>");
			rd.forward(request, response);
			return;
		} else {
			
			response.sendRedirect("AdminShowAll.do");
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
