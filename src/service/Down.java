package service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.KitDao;
import entity.Tool;

/**
 * Servlet implementation class Down
 */
@WebServlet("/Down")
public class Down extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(Down.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Down() {
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
		int toolID =Integer.parseInt(request.getParameter("toolID"));

		/*
		 * 防止盗连，在所有可以下载软件的网站中都会采用的技术，
		 * 在下载页面我先用referer来判断上一页面是不是自己网站，
		 * 如果不是，说明有人盗连了你的下载地址，用自己写的一个表单，来提交，为了能跳过你上一页里的javascript的验证等目的。
		 */
		String referer = request.getHeader("referer");
		//如果不是从kit.jsp过来，那么就阻止下载
		if (!referer.equals("http://localhost:8080/KitTest/kit.jsp")) {
			// 是盗链者
			response.sendRedirect("/KitTest/login.jsp");
			return;
		}
		
		//打印http请求头信息
		/*Enumeration<String> headers=request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header=headers.nextElement();
			String value=request.getHeader(header);
			System.out.println(header+"=  " +value+"<br>");
		}*/
		
		//如果验证成功，就去找到该文件的存储路径
		KitDao kitdao = new KitDao();
		Tool tool = kitdao.findById(toolID);
		String filepath = tool.getToolPath();
		File file = new File(filepath);
		downloadExistsFile(request, response, file);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void downloadExistsFile(HttpServletRequest request, HttpServletResponse response, File proposeFile)
			throws IOException, FileNotFoundException {
		log.debug("下载文件路径：" + proposeFile.getPath());
		//System.out.println("下载文件的路径：" + proposeFile.getPath());
		

		/*
		 * 解决各浏览器的中文乱码问题
		 */
		response.setCharacterEncoding("utf-8");
		String userAgent = request.getHeader("User-Agent");
		byte[] bytes = userAgent.contains("MSIE") ? proposeFile.getName().getBytes() : proposeFile.getName().getBytes("UTF-8"); //处理safari的乱码问题
		String filename=proposeFile.getName();
		filename = new String(bytes, "ISO-8859-1"); // 各浏览器基本都支持ISO编码
		response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", filename));
		
		
		/*
		 * 开始下载
		 */
		response.setContentType("application/x-download");	
		long fSize = proposeFile.length();
		response.setHeader("Accept-Ranges", "bytes");
		response.setHeader("Content-Length", String.valueOf(fSize));
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		long pos = 0;
		if (null != request.getHeader("Range")) {
			// 不是从最开始下载，断点下载响应号为206  
        
			System.out.println("断点下载成功！");
			response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
			try {
				pos = Long.parseLong(request.getHeader("Range").replaceAll("bytes=", "").split("-")[0]);
				System.out.println(pos);
			} catch (NumberFormatException e) {
				log.error(request.getHeader("Range") + " is not Number!");
				pos = 0;
			}
		}
		ServletOutputStream out = response.getOutputStream();
		BufferedOutputStream bufferOut = new BufferedOutputStream(out);
		InputStream inputStream = new FileInputStream(proposeFile);
		
		// 发送响应的格式是:  
        // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小] 
		String contentRange = new StringBuffer("bytes ").append(new Long(pos).toString()).append("-").append(new Long(fSize - 1).toString()).append("/").append(new Long(fSize).toString()).toString();
		response.setHeader("Content-Range", contentRange);
		log.debug("Content-Range: " + contentRange);
		System.out.println("Content-Range: " + contentRange);

		// 从之前下载暂停的地方开始下载
		inputStream.skip(pos);

		// 控制下载速度
		byte[] buffer = new byte[5 * 1024];
		int length = 0;
		while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
			bufferOut.write(buffer, 0, length);
		}
		bufferOut.flush();
		bufferOut.close();
		out.close();
		inputStream.close();
	}

}
