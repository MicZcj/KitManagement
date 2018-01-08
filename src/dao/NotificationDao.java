package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Notification;
import entity.Tool;

public class NotificationDao extends BaseDao {

	public void addNotification(Notification notification) {
		String sql = "INSERT INTO `kit`.`notification` (`UserID`, `ToolID`, `NotificationTime`, `ReadFlag`) VALUES (?, ?, ?, ?);";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, notification.getUserID());
			pstmt.setInt(2, notification.getToolID());
			pstmt.setDate(3, new java.sql.Date(notification.getNotificationTime().getTime()));
			pstmt.setInt(4, notification.getReadFlag());// 0表示未读 1表示已读
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 查询所有消息通知
	public List<Notification> findById(int userID) {
		String sql = "SELECT * FROM kit.tool,kit.notification,kit.user where tool.ToolID=notification.ToolID AND notification.userID=user.userID AND user.UserID=?;";
		String sql2 = "UPDATE kit.notification SET ReadFlag = 1 WHERE UserID=?;";
		List<Notification> list = new ArrayList<Notification>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
			pstmt.setInt(1, userID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Notification item = new Notification();
				item.setNotificationTime(rs.getDate("NotificationTime"));
				item.setReadFlag(rs.getInt("ReadFlag"));
				item.setToolName(rs.getString("ToolName"));
				item.setUserNickname(rs.getString("UserNickname"));
				item.setToolID(rs.getInt("ToolID"));
				list.add(item);
			}
			pstmt2.setInt(1, userID);
			pstmt2.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return list;

	}

}
