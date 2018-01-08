package entity;

import java.util.Date;

public class Notification {
	private int notificationID; //通知ID,（数据库自增的，这个属性不要自己插入）
	private int userID; //用户ID
	private int toolID; //工具ID
	private Date notificationTime; //通知时间，格式为“yyyy-MM-dd hh:mm:ss”
	private int readFlag; //已读或未读 （0为未读，1为已读）
	public int getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getToolID() {
		return toolID;
	}
	public void setToolID(int toolID) {
		this.toolID = toolID;
	}
	public Date getNotificationTime() {
		return notificationTime;
	}
	public void setNotificationTime(Date notificationTime) {
		this.notificationTime = notificationTime;
	}
	public int getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(int readFlag) {
		this.readFlag = readFlag;
	}
	
}
