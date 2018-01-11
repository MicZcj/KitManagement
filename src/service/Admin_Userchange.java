package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToolTypeDao;
import dao.AdminDao;
import entity.Admin;
import entity.ToolType;

/**
 * Servlet implementation class Admin_Userchange
 */
@WebServlet("/Admin_Userchange.do")
public class Admin_Userchange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Userchange() {
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
		String adminid = (String) request.getSession().getAttribute("adminid");
		String tooltypeid = request.getParameter("toolTypeid");
		String adminNickname = request.getParameter("adminnickname");
		String adminName= request.getParameter("adminname");
		Admin admin=new Admin();
		admin.setAdminID(Integer.parseInt(adminid));
		admin.setAdminNickname(adminNickname);
		admin.setAdminName(adminName);
		admin.setToolTypeID(Integer.parseInt(tooltypeid));
		AdminDao dao = new AdminDao();
		boolean result = dao.changeAdmin(admin);
		if (result == true) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminShowAll.do");
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
