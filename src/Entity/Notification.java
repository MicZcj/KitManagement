package Entity;

import java.util.Date;

public class Notification {
	String NotificationID; //通知ID
	String UserID; //用户ID
	String ToolID; //工具ID
	Date NotificationTime; //通知时间，格式为“yyyy-MM-dd hh:mm:ss”
	int ReadFlag; //已读或未读 （0为未读，1为已读）
	public String getNotificationID() {
		return NotificationID;
	}
	public void setNotificationID(String notificationID) {
		NotificationID = notificationID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getToolID() {
		return ToolID;
	}
	public void setToolID(String toolID) {
		ToolID = toolID;
	}
	public Date getNotificationTime() {
		return NotificationTime;
	}
	public void setNotificationTime(Date notificationTime) {
		NotificationTime = notificationTime;
	}
	public int getReadFlag() {
		return ReadFlag;
	}
	public void setReadFlag(int readFlag) {
		ReadFlag = readFlag;
	}

}
