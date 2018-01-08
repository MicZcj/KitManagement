package dao;

import java.sql.Connection;
import java.util.Date;

import entity.CommentRecord;
import entity.LikeRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			System.out.println("next3");
			pstmt.executeUpdate();
			System.out.println("next2");
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

	}

	// 找到该工具所有评论
	public ArrayList<CommentRecord> findAll(String toolID) {
		System.out.println("Dao---->findAll:根据toolID查找该工具的所有评论");
		ArrayList<CommentRecord> list=new ArrayList<CommentRecord>();
		String sql = "SELECT * FROM kit.commentrecord;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
		// TODO Auto-generated method stub
		System.out.println("Dao---->pointLike:已点赞");
	}

}
