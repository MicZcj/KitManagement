package entity;

public class Admin {
	private int adminID; // 管理员ID, (数据库自增的，这个属性不要自己插入)
	private String adminNickname; // 管理员名
	private String adminName; // 管理员姓名
	private String adminPassword; // 管理员密码
	private int toolTypeID; // 管理的工具类别ID

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminNickname() {
		return adminNickname;
	}

	public void setAdminNickname(String adminNickname) {
		this.adminNickname = adminNickname;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getToolTypeID() {
		return toolTypeID;
	}

	public void setToolTypeID(int toolTypeID) {
		this.toolTypeID = toolTypeID;
	}

}
