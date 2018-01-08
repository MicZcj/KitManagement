package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import entity.LikeRecord;

/**
 * Servlet implementation class CommentLike
 */
@WebServlet("/CommentLike.do")
public class CommentLike extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String toolID = request.getParameter("toolID");
		String userID = request.getParameter("userID");
		LikeRecord likeRecord = new LikeRecord();
		likeRecord.setToolID(Integer.parseInt(toolID));
		likeRecord.setUserID(Integer.parseInt(userID));
		CommentDao dao = new CommentDao();
		dao.pointLike(likeRecord);
		System.out.println("Servlet---->CommentLike:点赞");
		System.out.println("Servlet---->CommentLike:查所有评论");
		RequestDispatcher rd = request.getRequestDispatcher("CommentFindAll.do?toolID=" + toolID);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
