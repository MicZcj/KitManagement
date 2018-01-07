package Entity;

public class Tool {
	private int ToolID; //工具ID,（数据库自增的，这个属性不要自己插入）
	private int UserID; //上传的用户ID
	private String ToolName; //工具名称
	private String ToolDescription; //工具描述
	private String ToolEdition; //工具版本号
	private int ToolTypeID; //工具类别ID
	private String ToolTag; //工具标签
	private String ToolPath; //工具存储路径
	private int LikeNum; //点赞数
	private int DownloadNum; //下载数
	public int getToolID() {
		return ToolID;
	}
	public void setToolID(int toolID) {
		ToolID = toolID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getToolName() {
		return ToolName;
	}
	public void setToolName(String toolName) {
		ToolName = toolName;
	}
	public String getToolDescription() {
		return ToolDescription;
	}
	public void setToolDescription(String toolDescription) {
		ToolDescription = toolDescription;
	}
	public String getToolEdition() {
		return ToolEdition;
	}
	public void setToolEdition(String toolEdition) {
		ToolEdition = toolEdition;
	}
	public int getToolTypeID() {
		return ToolTypeID;
	}
	public void setToolTypeID(int toolTypeID) {
		ToolTypeID = toolTypeID;
	}
	public String getToolTag() {
		return ToolTag;
	}
	public void setToolTag(String toolTag) {
		ToolTag = toolTag;
	}
	public String getToolPath() {
		return ToolPath;
	}
	public void setToolPath(String toolPath) {
		ToolPath = toolPath;
	}
	public int getLikeNum() {
		return LikeNum;
	}
	public void setLikeNum(int likeNum) {
		LikeNum = likeNum;
	}
	public int getDownloadNum() {
		return DownloadNum;
	}
	public void setDownloadNum(int downloadNum) {
		DownloadNum = downloadNum;
	}
	

}
