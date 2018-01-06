package Entity;

public class Admin {
	String AdminID; //管理员ID
	String AdminNickname; //管理员名
	String AdminName; //管理员姓名
	String AdminPassword; //管理员密码
	String ToolTypeID; //管理的工具类别ID
	public String getAdminID() {
		return AdminID;
	}
	public void setAdminID(String adminID) {
		AdminID = adminID;
	}
	public String getAdminNickname() {
		return AdminNickname;
	}
	public void setAdminNickname(String adminNickname) {
		AdminNickname = adminNickname;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	public String getToolTypeID() {
		return ToolTypeID;
	}
	public void setToolTypeID(String toolTypeID) {
		ToolTypeID = toolTypeID;
	}

}
