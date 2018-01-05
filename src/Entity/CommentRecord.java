package Entity;

public class CommentRecord {
	String ToolID; //工具ID
	String UserID; //评论的用户ID
	String Comment; //评论内容
	String CommentTime; //评论时间
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
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public String getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(String commentTime) {
		CommentTime = commentTime;
	}

}
