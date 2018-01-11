package service;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class Bigupload
 */
@WebServlet("/Bigupload")
public class Bigupload extends HttpServlet {
	private String chunk; // 当前第几个分片
	private String chunks;// 总分片个数
	private String size;// 单个文件的总大小
	private String fileMd5;// 单个文件的总大小
	private String fileName;
	List items;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Bigupload() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savePath = "tool/";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		Map param = null;
		if (!request.getContentType().equals("application/x-www-form-urlencoded; charset=UTF-8")) {
			try {
				request.setCharacterEncoding("UTF-8");
				items = upload.parseRequest(request);
				param = new HashMap();
				for (Object object : items) {
					FileItem fileItem = (FileItem) object;
					if (fileItem.isFormField()) {
						param.put(fileItem.getFieldName(), fileItem.getString("utf-8"));// 如果你页面编码是utf-8的
					}

				}
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		// 为每个文件创建一个目录，并保存这个文件的所有分块文件

		if (param != null) {
			chunk = (String) param.get("chunk");
			chunks = (String) param.get("chunks");
			fileMd5 = (String) param.get("fileMd5");
			fileName = (String) param.get("name");
			System.out.println(chunk);
			System.out.println(chunks);
			System.out.println(fileMd5);
			
			// 判断是否已经分块上传
			if (chunks != null) {

				// 进行分块上传了
				// 建立一个临时目录，用于保存所有分块文件
				File chunksDir = new File(savePath + "/fileMd5/" + fileMd5);
				System.out.println();
				if (!chunksDir.exists()) {
					chunksDir.mkdir();
				}
				for (Object object : items) {
					FileItem fileItem = (FileItem) object;
					if (fileItem.isFormField()) {
						// 普通信息
					} else if (chunk != null) {
						// 保存分块文件
						File chunkFile = new File(chunksDir.getPath() + "/" + chunk);
						System.out.println(chunksDir.getPath());
						FileUtils.copyInputStreamToFile(fileItem.getInputStream(), chunkFile);
					}

				}

			}
		}
		// 后台合并所有分块文件
		String action = request.getParameter("action");
		System.out.println(action);
		if ("mergeChunks".equals(action)) {

			// 合并文件

			// 读取目录里面的所有文件
			File f = new File(savePath+ "/fileMd5/" + fileMd5);

			File[] fileArray = f.listFiles(new FileFilter() {
				// 排除目录，只要文件
				public boolean accept(File pathname) {
					if (pathname.isDirectory()) {
						return false;
					}
					return true;
				}
			});
			// 转成集合，便于排序
			List<File> fileList = new ArrayList<File>(Arrays.asList(fileArray));
			// 从小到大排序
			Collections.sort(fileList, new Comparator<File>() {
				public int compare(File o1, File o2) {
					if (Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName())) {
						return -1;
					}
					return 1;
				}
			});
			//创建目录
			File tempFileDir=new File(savePath+"/temp");
			if (!tempFileDir.exists()) {
				tempFileDir.mkdir();
			}
			File outputFile = new File(savePath+"/temp"+"/"+fileName);
			System.out.println(outputFile.getAbsolutePath());
			// 创建文件
			outputFile.createNewFile();
			// 输出流
			FileChannel outChannel = new FileOutputStream(outputFile).getChannel();
			// 合并
			FileChannel inChannel;
			for (File file : fileList) {
				inChannel = new FileInputStream(file).getChannel();
				inChannel.transferTo(0, inChannel.size(), outChannel);
				inChannel.close();
				// 删除分片
				file.delete();
			}
			// 清除文件夹
			File tempFile = new File("tool" + "/fileMd5/" + fileMd5);
			if (tempFile.isDirectory() && tempFile.exists()) {
				tempFile.delete();
			}
			// 关闭流
			outChannel.close();
			response.setContentType("text/html;charset=utf-8");
		}
	}
}