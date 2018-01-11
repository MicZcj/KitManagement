package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword.do")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = null;
		String oldPassword = (String) request.getParameter("oldPassword");
		String password1 = (String) request.getParameter("password1");
		String password2 = (String) request.getParameter("password2");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(oldPassword);
		System.out.println(user.getUserPassword());
		if (oldPassword.equals(user.getUserPassword())) {
			if (password1.equals(password2)) {
				user.setUserPassword(password2);
				result = "true";
				//修改数据库密码
				UserDao userdao=new UserDao();
				userdao.updatePassword(password1);
				
				request.setAttribute("result", result);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);		
			}
			else
			{
				result="noequal";
				request.setAttribute("result", result);
				RequestDispatcher rd = request.getRequestDispatcher("center_password.jsp");
				rd.forward(request, response);
			}
				
		}
		else
		{
			result = "false";
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("center_password.jsp");
			rd.forward(request, response);
		}
	}

}
