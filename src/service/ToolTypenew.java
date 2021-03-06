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
 * Servlet implementation class ToolTypenew
 */
@WebServlet("/ToolTypenew.do")
public class ToolTypenew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToolTypenew() {
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
		
		String tooltypename = request.getParameter("tooltypename");
       
		ToolType tooltype=new ToolType();
		tooltype.setToolTypeName(tooltypename);
		
		ToolTypeDao dao = new ToolTypeDao();
		boolean result = dao.addToolType(tooltype);
		if (result == true) {
			ToolTypeDao tooltypeDao =new ToolTypeDao();
			
			ArrayList<ToolType> tooltype1 = tooltypeDao.findAllToolType();
			request.getSession().setAttribute("tooltype", tooltype1);
			RequestDispatcher rd = request.getRequestDispatcher("admin_type.jsp");
			rd.forward(request, response);
			return;
		} else {
			
			response.sendRedirect("admin_type.jsp");
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
