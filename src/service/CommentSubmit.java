package service;

import java.awt.image.SampleModel;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import entity.CommentRecord;

/**
 * Servlet implementation class Commit
 */
@WebServlet("/CommentSubmit.do")
public class CommentSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String reply = request.getParameter("reply");
		String toolID = request.getParameter("toolID");
		String comment = request.getParameter("comment");
		String userID = request.getParameter("userID");
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CommentRecord commentRecord = new CommentRecord();
		commentRecord.setComment(comment);
		commentRecord.setCommentTime(date);
		commentRecord.setToolID(Integer.parseInt(toolID));
		commentRecord.setReply(reply);
		commentRecord.setUserID(Integer.parseInt(userID));
		CommentDao dao = new CommentDao();
		if (dao.addComment(commentRecord)) {
			RequestDispatcher rd = request.getRequestDispatcher("KitShowSingle.do");
			rd.forward(request, response);
		} else {
			System.out.println("失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
