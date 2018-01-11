package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KitDao;
import entity.ToolType;

/**
 * Servlet implementation class ShowUpload
 */
@WebServlet("/ShowUpload.do")
public class ShowUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KitDao kitdao=new KitDao();
		List<ToolType> tooltypelist=kitdao.findToolType();
		request.setAttribute("tooltypelist", tooltypelist);
		System.out.println(tooltypelist.get(0).getToolTypeName());
		System.out.println(tooltypelist.get(1).getToolTypeName());
		RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
