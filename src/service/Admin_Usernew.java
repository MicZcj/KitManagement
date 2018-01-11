package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import entity.Admin;

/**
 * Servlet implementation class Admin_Usernew
 */
@WebServlet("/Admin_Usernew.do")
public class Admin_Usernew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Usernew() {
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
		//用户信息
		String adminNickname = request.getParameter("adminNickname");
		String adminPassword = request.getParameter("adminPassword");
		String adminName= request.getParameter("adminName");
		String toolTypeid = request.getParameter("toolTypeid");
        //得到自增的adminID
		Admin admin=new Admin();
		admin.setAdminNickname(adminNickname);
		admin.setAdminName(adminName);
		admin.setAdminPassword(adminPassword);
		admin.setToolTypeID(Integer.parseInt(toolTypeid));
		
		AdminDao dao = new AdminDao();
		boolean result = dao.addAdmin(admin);
		if (result == true) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminShowAll.do");
			rd.forward(request, response);
			return;
		} else {
			
			response.sendRedirect("admin_usernew.jsp");
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
