package Entity;

import java.util.Date;

public class Notification {
	private int NotificationID; //通知ID,（数据库自增的，这个属性不要自己插入）
	private int UserID; //用户ID
	private int ToolID; //工具ID
	private Date NotificationTime; //通知时间，格式为“yyyy-MM-dd hh:mm:ss”
	private int ReadFlag; //已读或未读 （0为未读，1为已读）
	public int getNotificationID() {
		return NotificationID;
	}
	public void setNotificationID(int notificationID) {
		NotificationID = notificationID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getToolID() {
		return ToolID;
	}
	public void setToolID(int toolID) {
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
