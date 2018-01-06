package Entity;

import java.util.Date;

public class CommentRecord {
	String ToolID; //工具ID
	String UserID; //评论的用户ID
	String Comment; //评论内容
	Date CommentTime; //评论时间，格式为“yyyy-MM-dd hh:mm:ss”
	String Reply; //回复内容
	public String getReply() {
		return Reply;
	}
	public void setReply(String reply) {
		Reply = reply;
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
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public Date getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(Date commentTime) {
		CommentTime = commentTime;
	}

}
