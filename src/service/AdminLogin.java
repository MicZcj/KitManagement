package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.ToolTypeDao;
import entity.Admin;
import entity.ToolType;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("form-username");
		String password = request.getParameter("form-password");
		AdminDao dao = new AdminDao();
		Admin admin = dao.checkAdmin(username, password);
		RequestDispatcher rd;
		if (admin == null) {
			request.setAttribute("message", "管理员用户名或密码错误");
			rd = request.getRequestDispatcher("admin_login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			if(admin.getToolTypeID()==0)
				rd = request.getRequestDispatcher("admin_index.jsp");
			else
				rd = request.getRequestDispatcher("index.jsp");
		}
		rd.forward(request, response);
		
	}
	

}
