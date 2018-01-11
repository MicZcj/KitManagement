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
 * 
 *
 * Servlet implementation class KitShowAll
 */
@WebServlet("/KitShowAll.do")
public class KitShowAll extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int pagesize = 15;
		String select = (String) request.getSession().getAttribute("select");
		String keyword = (String) request.getSession().getAttribute("keyword");	
		KitDao kitDao =new KitDao();
		String s = request.getParameter("currPage");
		int currPage = Integer.parseInt(s);
		int flag = (int) request.getSession().getAttribute("flag");
		if(flag != 1){
			if(flag != 2){
				if(flag != 3){
						if(select.equals("1")){
							PageBean<Tool> pageBean = kitDao.findByName(keyword, currPage,pagesize);
							request.setAttribute("pageBean", pageBean.getList());
							request.setAttribute("page", pageBean);
							request.getSession().setAttribute("select", select);
							request.getSession().setAttribute("keyword", keyword);
							RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
							rd.forward(request, response);
						}
						else if(select.equals("2")){
							PageBean<Tool> pageBean = kitDao.findByDescription(keyword, currPage,pagesize);
							request.setAttribute("pageBean", pageBean.getList());
							request.setAttribute("page", pageBean);
							request.getSession().setAttribute("select", select);
							request.getSession().setAttribute("keyword", keyword);
							RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
							rd.forward(request, response);
						}
						else if(select.equals("3")){
							PageBean<Tool> pageBean = kitDao.findByUser(keyword, currPage,pagesize);
							request.setAttribute("pageBean", pageBean.getList());
							request.setAttribute("page", pageBean);
							request.getSession().setAttribute("select", select);
							request.getSession().setAttribute("keyword", keyword);
							RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
							rd.forward(request, response);
						}
				        else{
				        	PageBean<Tool> pageBean = kitDao.findByTag(keyword, currPage,pagesize);
							request.setAttribute("pageBean", pageBean.getList());
							request.setAttribute("page", pageBean);
							request.getSession().setAttribute("select", select);
							request.getSession().setAttribute("keyword", keyword);
							RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
							rd.forward(request, response);
						}
				}
				else{
					PageBean<Tool> pageBean = kitDao.findByPage(currPage,pagesize);
					request.setAttribute("pageBean", pageBean.getList());
					request.setAttribute("page", pageBean);
					RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
					rd.forward(request, response);
				}
			}
			else{
				if(select.equals("1")){
					PageBean<Tool> pageBean = kitDao.findByNameASC(keyword, currPage,pagesize);
					request.setAttribute("pageBean", pageBean.getList());
					request.setAttribute("page", pageBean);
					request.getSession().setAttribute("select", select);
					request.getSession().setAttribute("keyword", keyword);
					RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
					rd.forward(request, response);
				}
				else if(select.equals("2")){
					PageBean<Tool> pageBean = kitDao.findByDescriptionASC(keyword, currPage,pagesize);
					request.setAttribute("pageBean", pageBean.getList());
					request.setAttribute("page", pageBean);
					request.getSession().setAttribute("select", select);
					request.getSession().setAttribute("keyword", keyword);
					RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
					rd.forward(request, response);
				}
				else if(select.equals("3")){
					PageBean<Tool> pageBean = kitDao.findByUserASC(keyword, currPage,pagesize);
					request.setAttribute("pageBean", pageBean.getList());
					request.setAttribute("page", pageBean);
					request.getSession().setAttribute("select", select);
					request.getSession().setAttribute("keyword", keyword);
					RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
					rd.forward(request, response);
				}
		        else{
		        	PageBean<Tool> pageBean = kitDao.findByTagASC(keyword, currPage,pagesize);
					request.setAttribute("pageBean", pageBean.getList());
					request.setAttribute("page", pageBean);
					request.getSession().setAttribute("select", select);
					request.getSession().setAttribute("keyword", keyword);
					RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
					rd.forward(request, response);
				}
			}	
		}
		else{
			if(select.equals("1")){
				PageBean<Tool> pageBean = kitDao.findByNameDesc(keyword, currPage,pagesize);
				request.setAttribute("pageBean", pageBean.getList());
				request.setAttribute("page", pageBean);
				request.getSession().setAttribute("select", select);
				request.getSession().setAttribute("keyword", keyword);
				RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
				rd.forward(request, response);
			}
			else if(select.equals("2")){
				PageBean<Tool> pageBean = kitDao.findByDescriptionDesc(keyword, currPage,pagesize);
				request.setAttribute("pageBean", pageBean.getList());
				request.setAttribute("page", pageBean);
				request.getSession().setAttribute("select", select);
				request.getSession().setAttribute("keyword", keyword);
				RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
				rd.forward(request, response);
			}
			else if(select.equals("3")){
				PageBean<Tool> pageBean = kitDao.findByUserDesc(keyword, currPage,pagesize);
				request.setAttribute("pageBean", pageBean.getList());
				request.setAttribute("page", pageBean);
				request.getSession().setAttribute("select", select);
				request.getSession().setAttribute("keyword", keyword);
				RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
				rd.forward(request, response);
			}
	        else{
	        	PageBean<Tool> pageBean = kitDao.findByTagDesc(keyword, currPage,pagesize);
				request.setAttribute("pageBean", pageBean.getList());
				request.setAttribute("page", pageBean);
				request.getSession().setAttribute("select", select);
				request.getSession().setAttribute("keyword", keyword);
				RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
				rd.forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currPage = 1;
		int flag = 0;
		int pagesize = 15;
		request.getSession().setAttribute("flag", flag);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String select = request.getParameter("select");
		String keyword = request.getParameter("keyword");
		KitDao kitDao =new KitDao();
		if(select.equals("1")){
			PageBean<Tool> pageBean = kitDao.findByName(keyword, currPage,pagesize);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}
		else if(select.equals("2")){
			PageBean<Tool> pageBean = kitDao.findByDescription(keyword, currPage,pagesize);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}
		else if(select.equals("3")){
			PageBean<Tool> pageBean = kitDao.findByUser(keyword, currPage,pagesize);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}
        else{
        	PageBean<Tool> pageBean = kitDao.findByTag(keyword, currPage,pagesize);
			request.setAttribute("pageBean", pageBean.getList());
			request.setAttribute("page", pageBean);
			request.getSession().setAttribute("select", select);
			request.getSession().setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("allKit.jsp");
			rd.forward(request, response);
		}		
	}

}
