package entity;

import java.util.Date;

public class CommentRecord {
	private int commentID; //评论记录ID,（数据库自增的，这个属性不要自己插入）
	private int toolID; //工具ID
	private int userID; //评论的用户ID
	private String comment; //评论内容
	private Date commentTime; //评论时间，格式为“yyyy-MM-dd hh:mm:ss”
	private String reply; //回复内容
	
	@Override
	public String toString() {
		return "CommentRecord [commentID=" + commentID + ", toolID=" + toolID + ", userID=" + userID + ", comment="
				+ comment + ", commentTime=" + commentTime + ", reply=" + reply + "]";
	}
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
