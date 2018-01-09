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
 * Servlet implementation class KitShowByLikeNum
 */
@WebServlet("/KitShowAllbylikenum.do")
public class KitShowByLikeNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currPage = 1;
		int flag = (int) request.getSession().getAttribute("flag");
		flag = 2;
		request.getSession().setAttribute("flag",flag);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String select = (String) request.getSession().getAttribute("select");
		String keyword = (String) request.getSession().getAttribute("keyword");
		KitDao kitDao =new KitDao();
		if(select.equals("1")){
			PageBean<Tool> pageBean = kitDao.findbyNameASC(keyword, currPage);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}
		else if(select.equals("2")){
			PageBean<Tool> pageBean = kitDao.findByDescriptionASC(keyword, currPage);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}
		else if(select.equals("3")){
			PageBean<Tool> pageBean = kitDao.findByUserASC(keyword, currPage);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}
        else{
        	PageBean<Tool> pageBean = kitDao.findByTagASC(keyword, currPage);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
