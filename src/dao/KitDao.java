package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PageBean;
import entity.Tool;

public class KitDao extends BaseDao {

	public PageBean<Tool> findByPage(int currPage) {
		PageBean<Tool> pageBean = new PageBean<Tool>();
		pageBean.setCurrPage(currPage);
		// 每页显示几条记录
		Integer pageSize = 1;
		pageBean.setPageSize(pageSize);
		Integer totalCount = findCount();
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage - 1) * pageSize;
		List<Tool> list = find(begin, begin + pageSize);
		pageBean.setList(list);
		return pageBean;
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
				tool.setUploadTime(rs.getDate("uploadTime"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return tool;
	}

}
