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
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister.do")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//用户信息
		String userNickname = request.getParameter("userNickname");
		String userPassword = request.getParameter("userPassword");
		String userName= request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String department=request.getParameter("department");
        //得到自增的userID
		User user=new User();
		user.setUserNickname(userNickname);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setDepartment(department);
		
		UserDao dao = new UserDao();
		boolean result = dao.addUser(user);
		if (result == true) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("register.jsp");
		}
	}

}
