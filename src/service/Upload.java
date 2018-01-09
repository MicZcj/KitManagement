package service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KitDao;
import entity.Tool;
import entity.User;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		int userID=user.getUserID();
		String toolName=request.getParameter("toolName");
		String toolDescription=request.getParameter("toolDescription");
		String toolEdition=request.getParameter("toolEdition");
		String toolTypeName=request.getParameter("type");
		String toolTag=request.getParameter("toolTag");
		String toolPath =("/WEB-INF/upload");
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date uploadTime = null;
//		try {
//			uploadTime = (Date) df.parse(uploadTime1);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(toolTypeName);
		System.out.println(date);
	    Tool tool=new Tool();
	    KitDao kitdao=new KitDao();
	    tool.setUserID(userID);
	    tool.setToolName(toolName);
	    tool.setToolDescription(toolDescription);
	    tool.setToolEdition(toolEdition);
	    tool.setToolTypeName(toolTypeName);
	    tool.setToolTag(toolTag);
	    tool.setToolPath(toolPath);
	    tool.setUploadTime(date);
	    tool.setLikeNum(0);
	    tool.setDownloadNum(0);;
	    tool.setToolID(kitdao.findToolId(toolTypeName));
	    boolean result=kitdao.addTool(tool);
	    if(result)
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
