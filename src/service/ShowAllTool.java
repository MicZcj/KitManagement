package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KitDao;
import entity.PageBean;
import entity.Tool;

/**
 * Servlet implementation class ShowAllTool
 */
@WebServlet("/showAlltool.do")
public class ShowAllTool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = "0";
		request.getSession().setAttribute("select", select);
		String keyword = "0";
		request.getSession().setAttribute("keyword", keyword);
		int flag = 3;
		int pagesize = 15;
		request.getSession().setAttribute("flag",flag);
		String s = request.getParameter("currPage");
		KitDao kitDao = new KitDao();
		int currPage = Integer.parseInt(s);
		PageBean<Tool> pageBean = kitDao.findByPage(currPage,pagesize);
		request.setAttribute("pageBean", pageBean.getList());
		request.setAttribute("page", pageBean);
		RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
