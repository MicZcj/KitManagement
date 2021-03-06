package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PageBean;
import entity.Tool;
import entity.ToolType;

public class KitDao extends BaseDao {

	public PageBean<Tool> findByPage(int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		Integer totalCount = findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = find(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	// 按标签查询(按点赞数升序)
	public PageBean<Tool> findByTagASC(String tag, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyTagASC(tag, begin, pageSize);
		Integer totalCount = findCountbyTag(tag);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyTagASC(String tag, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolTag like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID order by LikeNum DESC limit ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tag);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按发布者查询(按点赞数升序)
	public PageBean<Tool> findByUserASC(String user, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyUserASC(user, begin, pageSize);
		Integer totalCount = findCountbyUser(user);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyUserASC(String user, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype,kit.user where user.UserNickname like concat('%',?,'%') and tool.UserID=user.UserID and tool.ToolTypeID=tooltype.ToolTypeID order by LikeNum DESC limit ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按描述查询(按点赞数升序)
	public PageBean<Tool> findByDescriptionASC(String description, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyDescriptionASC(description, begin, pageSize);
		Integer totalCount = findCountbyDescription(description);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyDescriptionASC(String description, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolDescription like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID order by LikeNum DESC limit ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, description);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按名字查询(按点赞数升序)
	public PageBean<Tool> findByNameASC(String name, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyNameASC(name, begin, pageSize);
		Integer totalCount = findCountbyName(name);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyNameASC(String name, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolName like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID order by LikeNum DESC limit ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按标签查询(按下载量降序)
	public PageBean<Tool> findByTagDesc(String tag, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyTagDesc(tag, begin, pageSize);
		Integer totalCount = findCountbyTag(tag);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyTagDesc(String tag, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolTag like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID limit order by DownloadNum DESC ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tag);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按发布者查询(按下载量降序)
	public PageBean<Tool> findByUserDesc(String user, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyUserDesc(user, begin, pageSize);
		Integer totalCount = findCountbyUser(user);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyUserDesc(String user, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype,kit.user where user.UserNickname like concat('%',?,'%') and tool.UserID=user.UserID and tool.ToolTypeID=tooltype.ToolTypeID order by DownloadNum DESC limit ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按描述查询(按下载量降序)
	public PageBean<Tool> findByDescriptionDesc(String description, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyDescriptionDesc(description, begin, pageSize);
		Integer totalCount = findCountbyDescription(description);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyDescriptionDesc(String description, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolDescription like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID order by DownloadNum DESC limit ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, description);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按名字查询(按下载量降序)
	public PageBean<Tool> findByNameDesc(String name, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyNameDesc(name, begin, pageSize);
		Integer totalCount = findCountbyName(name);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private List<Tool> findbyNameDesc(String name, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolName like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID order by DownloadNum desc limit ?,? ;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按标签查询
	public PageBean<Tool> findByTag(String tag, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyTag(tag, begin, pageSize);
		Integer totalCount = findCountbyTag(tag);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private Integer findCountbyTag(String tag) {
		String sql = "SELECT count(*) FROM kit.tool,kit.tooltype where tool.ToolTag like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID;";
		int count = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tag);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				count = Integer.parseInt(rs.getString(1));
			return count;
		} catch (SQLException se) {
			se.printStackTrace();
			return count;
		}
	}

	private List<Tool> findbyTag(String tag, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolTag like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID limit ?,?;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, tag);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按发布者查询
	public PageBean<Tool> findByUser(String user, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyUser(user, begin, pageSize);
		Integer totalCount = findCountbyUser(user);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private Integer findCountbyUser(String user) {
		String sql = "SELECT count(*) FROM kit.tool,kit.tooltype,kit.user where user.UserNickname like concat('%',?,'%') and tool.UserID=user.UserID and tool.ToolTypeID=tooltype.ToolTypeID;";
		int count = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				count = Integer.parseInt(rs.getString(1));
			return count;
		} catch (SQLException se) {
			se.printStackTrace();
			return count;
		}
	}

	private List<Tool> findbyUser(String user, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype,kit.user where user.UserNickname like concat('%',?,'%') and tool.UserID=user.UserID and tool.ToolTypeID=tooltype.ToolTypeID limit ?,?;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按描述查询
	public PageBean<Tool> findByDescription(String description, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyDescription(description, begin, pageSize);
		Integer totalCount = findCountbyDescription(description);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private Integer findCountbyDescription(String description) {
		String sql = "SELECT count(*) FROM kit.tool,kit.tooltype where tool.ToolDescription like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID;";
		int count = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, description);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				count = Integer.parseInt(rs.getString(1));
			return count;
		} catch (SQLException se) {
			se.printStackTrace();
			return count;
		}
	}

	private List<Tool> findbyDescription(String description, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolDescription like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID limit ?,?;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, description);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	// 按名字查询
	public PageBean<Tool> findByName(String name, int currPage, int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbyName(name, begin, pageSize);
		Integer totalCount = findCountbyName(name);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		pageBean.setList(list);
		return pageBean;
	}

	private Integer findCountbyName(String name) {
		String sql = "SELECT count(*) FROM kit.tool,kit.tooltype where tool.ToolName like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID;";
		int count = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				count = Integer.parseInt(rs.getString(1));
			return count;
		} catch (SQLException se) {
			se.printStackTrace();
			return count;
		}
	}

	private List<Tool> findbyName(String name, int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolName like concat('%',?,'%') and tool.ToolTypeID=tooltype.ToolTypeID limit ?,?;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	private List<Tool> find(int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolTypeID=tooltype.ToolTypeID limit ?,?;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

	private Integer findCount() {
		String sql = "SELECT count(*) FROM kit.tool;";
		int count = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				count = Integer.parseInt(rs.getString(1));
			return count;
		} catch (SQLException se) {
			se.printStackTrace();
			return count;
		}
	}

	public Tool findById(int id) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype,kit.user where tool.ToolTypeID=tooltype.ToolTypeID AND tool.userID=user.userID AND tool.toolID=?;";
		Tool tool = new Tool();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tool.setUserNickname(rs.getString("UserNickname"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tool;
	}

	/** 查找所有工具类型 */
	public List<ToolType> findToolType() {
		List<ToolType> result = new ArrayList();
		String sql = "Select * from tooltype";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ToolType tooltype = new ToolType();
				tooltype.setToolTypeID(rs.getInt("ToolTypeID"));
				tooltype.setToolTypeName(rs.getString("ToolTypeName"));
				result.add(tooltype);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean addTool(Tool tool) {
		String sql = "insert into tool"
				+ "(ToolID,UserID,ToolName,ToolDescription,ToolEdition,ToolTypeID,ToolTag,ToolPath,uploadTime,DownloadNum,LikeNum)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, tool.getToolID());
			pstmt.setLong(2, tool.getUserID());
			pstmt.setString(3, tool.getToolName());
			pstmt.setString(4, tool.getToolDescription());
			pstmt.setString(5, tool.getToolEdition());
			pstmt.setLong(6, tool.getToolTypeID());
			pstmt.setString(7, tool.getToolTag());
			pstmt.setString(8, tool.getToolPath());
			pstmt.setDate(9, new java.sql.Date(tool.getUploadTime().getTime()));
			pstmt.setLong(10, tool.getDownloadNum());
			pstmt.setLong(11, tool.getLikeNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public int findToolId(String name) {
		List<ToolType> result = new ArrayList();
		String sql = "Select ToolTypeID from tooltype where ToolTypeName=?";
		int id = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("ToolTypeID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public void updateToolDLNum(int toolID){
		String sql = "update tool set DownloadNum=DownloadNum+1 where ToolID=?;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, toolID);
			pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	public boolean deleteTool(int toolID){
		String sql = "delete from tool where ToolID=?;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, toolID);
			pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
		return true;
	}

public PageBean<Tool> findByDownloadnumDesc(int currPage,int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		//每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		Integer totalCount = findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbydownloadNumDesc(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	
	public PageBean<Tool> findByLikeNumDesc(int currPage,int pagesize) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		//每页显示几条记录
		Integer pageSize = pagesize;
		pageBean.setPageSize(pageSize);
		Integer totalCount = findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = findbylikeNumDesc(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	
	private List<Tool> findbylikeNumDesc(int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolTypeID=tooltype.ToolTypeID order by LikeNum DESC limit ?,?;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}
	
	
	private List<Tool> findbydownloadNumDesc(int begin, int end) {
		String sql = "SELECT * FROM kit.tool,kit.tooltype where tool.ToolTypeID=tooltype.ToolTypeID order by DownloadNum DESC limit ?,?;";
		List<Tool> tools = new ArrayList<Tool>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Tool tool = new Tool();
				tool.setDownloadNum(Integer.parseInt(rs.getString("DownloadNum")));
				tool.setLikeNum(Integer.parseInt(rs.getString("LikeNum")));
				tool.setToolDescription(rs.getString("ToolDescription"));
				tool.setToolEdition(rs.getString("ToolEdition"));
				tool.setToolID(rs.getInt("ToolID"));
				tool.setToolName(rs.getString("ToolName"));
				tool.setToolPath(rs.getString("ToolPath"));
				tool.setToolTag(rs.getString("ToolTag"));
				tool.setToolTypeID(rs.getInt("ToolTypeID"));
				tool.setUserID(rs.getInt("UserID"));
				tool.setToolTypeName(rs.getString("ToolTypeName"));
				tools.add(tool);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tools;
	}

}
