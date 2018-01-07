package Entity;

public class LikeRecord {
	private int CommentID; //评论记录ID,（数据库自增的，这个属性不要自己插入）
	private int ToolID; //工具ID
	private int UserID; //点赞的用户ID
	public int getCommentID() {
		return CommentID;
	}
	public void setCommentID(int commentID) {
		CommentID = commentID;
	}
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
	

}
