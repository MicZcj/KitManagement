package entity;

public class LikeRecord {
	private int commentID; //评论记录ID,（数据库自增的，这个属性不要自己插入）
	private int toolID; //工具ID
	private int userID; //点赞的用户ID
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
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
	

}
