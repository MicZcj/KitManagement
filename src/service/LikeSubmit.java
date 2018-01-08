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
@WebServlet("/LikeSubmit.do")
public class LikeSubmit extends HttpServlet {

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
		dao.likeNumPlus(Integer.parseInt(toolID));
		dao.pointLike(likeRecord);
		RequestDispatcher rd = request.getRequestDispatcher("KitShowSingle.do");
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
