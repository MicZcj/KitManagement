package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import dao.KitDao;
import entity.CommentRecord;
import entity.LikeRecord;
import entity.Tool;
import entity.User;

/**
 * Servlet implementation class KitShowSingle
 */
@WebServlet("/KitShowSingle.do")
public class KitShowSingle extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// 显示工具详情
		int toolID = Integer.parseInt(request.getParameter("toolID"));
		KitDao kitDao = new KitDao();
		Tool tool = kitDao.findById(toolID);
		request.setAttribute("tool", tool);// 工具信息

		// 查找评论
		String id = request.getParameter("toolID");
		CommentDao dao = new CommentDao();
		ArrayList<CommentRecord> commentRecord = dao.findAll(id);
		request.setAttribute("commentRecord", commentRecord);// 评论列表

		// 查找点赞
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			int userID = user.getUserID();
			boolean likeRecord = dao.isLike(userID, toolID);
			System.out.println(likeRecord + "" + userID + toolID);
			request.setAttribute("likeRecord", likeRecord);// 点赞与否
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("kit.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
