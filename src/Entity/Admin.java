package Entity;

public class Admin {
	private int AdminID; //管理员ID, (数据库自增的，这个属性不要自己插入)
	private String AdminNickname; //管理员名
	private String AdminName; //管理员姓名
	private String AdminPassword; //管理员密码
	private int ToolTypeID; //管理的工具类别ID
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
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
	public int getToolTypeID() {
		return ToolTypeID;
	}
	public void setToolTypeID(int toolTypeID) {
		ToolTypeID = toolTypeID;
	}

}
