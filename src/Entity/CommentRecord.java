package Entity;

import java.util.Date;

public class CommentRecord {
	private int CommentID; //评论记录ID,（数据库自增的，这个属性不要自己插入）
	private int ToolID; //工具ID
	private int UserID; //评论的用户ID
	private String Comment; //评论内容
	private Date CommentTime; //评论时间，格式为“yyyy-MM-dd hh:mm:ss”
	private String Reply; //回复内容
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
	public String getReply() {
		return Reply;
	}
	public void setReply(String reply) {
		Reply = reply;
	}
	
}
