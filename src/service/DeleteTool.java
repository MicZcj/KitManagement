package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KitDao;

/**
 * Servlet implementation class DeleteTool
 */
@WebServlet("/DeleteTool")
public class DeleteTool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTool() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int toolID =Integer.parseInt(request.getParameter("toolID"));
		KitDao kitdao = new KitDao();
		if(kitdao.deleteTool(toolID)){
			RequestDispatcher rd = request.getRequestDispatcher("showAlltool.do?currPage=1");
			request.setAttribute("alert", "<script type=\"text/javascript\">alert(\"删除成功！\");</script>");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("showAlltool.do?currPage=1");
			request.setAttribute("alert", "<script type=\"text/javascript\">alert(\"删除失败！\");</script>");
			rd.forward(request, response);
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
