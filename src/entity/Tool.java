package entity;

public class Tool {
	private int toolID; // 工具ID,（数据库自增的，这个属性不要自己插入）
	private int userID; // 上传的用户ID
	private String toolName; // 工具名称
	private String toolDescription; // 工具描述
	private String toolEdition; // 工具版本号
	private int toolTypeID; // 工具类别ID
	private String toolTag; // 工具标签
	private String toolPath; // 工具存储路径
	private int likeNum; // 点赞数
	private int downloadNum; // 下载数
	private String toolTypeName; // 工具类别名称

	public int getToolID() {
		return toolID;
	}

	public void setToolID(int toolID) {
		this.toolID = toolID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getToolDescription() {
		return toolDescription;
	}

	public void setToolDescription(String toolDescription) {
		this.toolDescription = toolDescription;
	}

	public String getToolEdition() {
		return toolEdition;
	}

	public void setToolEdition(String toolEdition) {
		this.toolEdition = toolEdition;
	}

	public int getToolTypeID() {
		return toolTypeID;
	}

	public void setToolTypeID(int toolTypeID) {
		this.toolTypeID = toolTypeID;
	}

	public String getToolTag() {
		return toolTag;
	}

	public void setToolTag(String toolTag) {
		this.toolTag = toolTag;
	}

	public String getToolPath() {
		return toolPath;
	}

	public void setToolPath(String toolPath) {
		this.toolPath = toolPath;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getDownloadNum() {
		return downloadNum;
	}

	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}

	public String getToolTypeName() {
		return toolTypeName;
	}

	public void setToolTypeName(String toolTypeName) {
		this.toolTypeName = toolTypeName;
	}

}
