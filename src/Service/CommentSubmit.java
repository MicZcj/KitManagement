package Service;

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

import Dao.CommentDao;
import Entity.CommentRecord;

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
		System.out.println("Servlet---->CommentSubmit:提交评论");
		System.out.println(format.format(date).toString());
		System.out.println(comment);
		System.out.println(reply);
		System.out.println(toolID);
		System.out.println(userID);
		CommentRecord commentRecord = new CommentRecord();
		commentRecord.setComment(comment);
		commentRecord.setCommentTime(format.format(date).toString());
		commentRecord.setToolID(toolID);
		commentRecord.setReply(reply);
		CommentDao dao = new CommentDao();
		if (dao.addComment(commentRecord)) {
			RequestDispatcher rd = request.getRequestDispatcher("CommentFindAll.do?toolID=" + toolID);
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
