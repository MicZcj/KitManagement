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
import entity.ToolType;

/**
 * Servlet implementation class ToolTypeShowAll_admin
 */
@WebServlet("/ToolTypeShowAll_admin.do")
public class ToolTypeShowAll_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToolTypeShowAll_admin() {
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
		ToolTypeDao tooltypeDao =new ToolTypeDao();
		
		ArrayList<ToolType> tooltype = tooltypeDao.findAllToolType();
		request.getSession().setAttribute("tooltype", tooltype);
		
		ArrayList<ToolType> t = (ArrayList<ToolType>) request.getSession().getAttribute("tooltype");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("admin_usernew.jsp");
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
