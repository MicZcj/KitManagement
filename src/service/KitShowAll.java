package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KitDao;
import entity.PageBean;
import entity.Tool;

/**
 * Servlet implementation class KitShowAll
 */
@WebServlet("/KitShowAll.do")
public class KitShowAll extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int currPage=Integer.parseInt(request.getParameter("currPage")); 
		KitDao kitDao =new KitDao();
		PageBean<Tool> pageBean = kitDao.findByPage(currPage);
		request.setAttribute("pageBean", pageBean.getList());
		request.setAttribute("page", pageBean);
		RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
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
