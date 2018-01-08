package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Notification;

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

}
