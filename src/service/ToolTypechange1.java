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
 * Servlet implementation class ToolTypechange1
 */
@WebServlet("/ToolTypechange1.do")
public class ToolTypechange1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToolTypechange1() {
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
		String tooltypeid = (String) request.getSession().getAttribute("tooltypeid");
		String tooltypename = request.getParameter("tooltypename");
		ToolType tooltype=new ToolType();
		tooltype.setToolTypeID(Integer.parseInt(tooltypeid));
		tooltype.setToolTypeName(tooltypename);
		ToolTypeDao dao = new ToolTypeDao();
		boolean result = dao.changeToolType(tooltype.getToolTypeID(),tooltype.getToolTypeName());
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
