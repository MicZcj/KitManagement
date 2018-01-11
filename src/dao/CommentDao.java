package dao;

import java.sql.Connection;
import java.util.Date;

import entity.CommentRecord;
import entity.LikeRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommentDao extends BaseDao {
	// 添加评论
	public boolean addComment(CommentRecord commentRecord) {
		System.out.println(commentRecord.toString());
		System.out.println("Dao---->addComment:评论写进数据库");
		String sql = "INSERT INTO `kit`.`commentrecord` (`ToolID`, `UserID`, `Comment`, `CommentTime`, `Reply`) VALUES (?, ?, ?, ?, ?);";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, commentRecord.getToolID());
			pstmt.setInt(2, commentRecord.getUserID());
			pstmt.setString(3, commentRecord.getComment());
			pstmt.setDate(4, new java.sql.Date(commentRecord.getCommentTime().getTime()));
			pstmt.setString(5, commentRecord.getReply());
			System.out.println(commentRecord.toString());
			pstmt.executeUpdate();

			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 找到该工具所有评论
	public ArrayList<CommentRecord> findAll(String toolID) {
		System.out.println("Dao---->findAll:根据toolID查找该工具的所有评论");
		ArrayList<CommentRecord> list = new ArrayList<CommentRecord>();
		String sql = "SELECT * FROM kit.commentrecord WHERE ToolID= ?;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Integer.parseInt(toolID));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentRecord commentRecord = new CommentRecord();
				commentRecord.setToolID(Integer.parseInt(rs.getString("ToolID")));
				commentRecord.setUserID(Integer.parseInt(rs.getString("UserID")));
				commentRecord.setComment(rs.getString("Comment"));
				commentRecord.setCommentTime(rs.getDate("COmmentTime"));
				commentRecord.setReply(rs.getString("Reply"));
				list.add(commentRecord);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return list;
	}

	public void pointLike(LikeRecord likeRecord) {
		String sql = "INSERT INTO `kit`.`likerecord` (`ToolID`, `UserID`) VALUES (?, ?);";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, likeRecord.getToolID());
			pstmt.setInt(2, likeRecord.getUserID());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public boolean isLike(int userID, int toolID) {
		String sql = "SELECT * FROM `kit`.`likerecord` WHERE ToolID = ? AND UserID = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, toolID);
			pstmt.setInt(2, userID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return false;
	}

	public void likeNumPlus(int toolID) {
		String sql = "SELECT LikeNum FROM `kit`.`tool` WHERE ToolID = ?";
		String sql2 = "UPDATE `kit`.`tool` SET LikeNum = ? WHERE ToolID = ? ";
		int likeNum = 0;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
			pstmt.setInt(1, toolID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				likeNum = rs.getInt("LikeNum") + 1;
			}
			pstmt2.setInt(1, likeNum);
			pstmt2.setInt(2, toolID);
			pstmt2.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}
