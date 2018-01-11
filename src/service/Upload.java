package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userID = user.getUserID();
		String toolName = request.getParameter("toolName");
		String toolDescription = request.getParameter("toolDescription");
		String toolEdition = request.getParameter("toolEdition");
		String toolTypeID = request.getParameter("type");
		String toolTag = request.getParameter("toolTag");
		String toolPath = "tool/toolist";
		// 创建文件目录
		File tempFileDir = new File(toolPath);
		tempFileDir.mkdir();
		if (!tempFileDir.exists()) {
			tempFileDir.mkdir();
		}
		// 创建文件type目录
		File typeFileDir = new File(toolPath + "/" + toolTypeID);
		typeFileDir.mkdir();
		if (!typeFileDir.exists()) {
			typeFileDir.mkdir();
		}
		// 创建文件名称目录
		File toolNameDir = new File(toolPath + "/" + toolTypeID + "/" + toolName);
		toolNameDir.mkdir();
		if (!toolNameDir.exists()) {
			toolNameDir.mkdir();
		}
		// 文件拷贝
		String filename = null;
		File tempfile = new File("tool/temp");
		File[] fs = tempfile.listFiles();
		for (int i = 0; i < fs.length; i++) {
			filename = fs[i].getName();
		}
		if (tempfile.exists()) { // 文件存在时
			InputStream inStream = new FileInputStream("tool/temp/" + filename); // 读入原文件
			FileOutputStream fs1 = new FileOutputStream(toolPath + "/" + toolTypeID + "/" + toolName + "/" + filename);
			byte[] buffer = new byte[1444];
			int length;
			int byteread = 0;
			while ((byteread = inStream.read(buffer)) != -1) {
				fs1.write(buffer, 0, byteread);
			}
			inStream.close();
		}
		// 删除temp区文件
		File move = new File("tool/temp/" + filename);
		if (move.exists())
			move.delete();

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(toolTypeID);
		System.out.println(date);
		Tool tool = new Tool();
		KitDao kitdao = new KitDao();
		tool.setToolPath(toolPath + "/" + toolTypeID + "/" + toolName + "/" + filename);
		tool.setUserID(userID);
		tool.setToolName(toolName);
		tool.setToolDescription(toolDescription);
		tool.setToolEdition(toolEdition);
		tool.setToolTag(toolTag);
		tool.setUploadTime(date);
		tool.setLikeNum(0);
		tool.setDownloadNum(0);
		tool.setToolTypeID(Integer.parseInt(toolTypeID));
		boolean result = kitdao.addTool(tool);
		if (result) {
			RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
			request.setAttribute("result", result);
			rd.forward(request, response);
		}
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
