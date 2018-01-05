package Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CommentDao;
import Entity.CommentRecord;

/**
 * Servlet implementation class CommentFindAll
 */
@WebServlet("/CommentFindAll.do")
public class CommentFindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String toolID = request.getParameter("toolID");
		CommentDao dao = new CommentDao();
		ArrayList<CommentRecord> commentRecord = dao.findAll(toolID);
		request.setAttribute("commentRecord", commentRecord);
		System.out.println("Servlet---->CommentFindAll:找到该toolID的所有评论！跳转到kit.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("kit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
