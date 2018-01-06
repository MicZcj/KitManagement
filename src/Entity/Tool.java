package Entity;

public class Tool {
	String ToolID; //工具ID
	String UserID; //上传的用户ID
	String ToolName; //工具名称
	String ToolDescription; //工具描述
	String ToolEdition; //工具版本号
	String ToolTypeID; //工具类别ID
	String ToolTag; //工具标签
	String ToolPath; //工具存储路径
	int LikeNum; //点赞数
	int DownloadNum; //下载数
	
	public String getToolPath() {
		return ToolPath;
	}
	public void setToolPath(String toolPath) {
		ToolPath = toolPath;
	}
	public String getToolID() {
		return ToolID;
	}
	public void setToolID(String toolID) {
		ToolID = toolID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
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
	public String getToolTypeID() {
		return ToolTypeID;
	}
	public void setToolTypeID(String toolTypeID) {
		ToolTypeID = toolTypeID;
	}
	public String getToolTag() {
		return ToolTag;
	}
	public void setToolTag(String toolTag) {
		ToolTag = toolTag;
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
