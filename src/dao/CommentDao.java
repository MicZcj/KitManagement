package dao;

import java.util.ArrayList;

import entity.CommentRecord;
import entity.LikeRecord;

public class CommentDao extends BaseDao {
	//添加评论
	public boolean addComment(CommentRecord commentRecord) {
		System.out.println("Dao---->addComment:评论写进数据库");
		return true;
	}
	//找到该工具所有评论
	public ArrayList<CommentRecord> findAll(String toolID) {
		System.out.println("Dao---->findAll:根据toolID查找该工具的所有评论");
		return null;
	}
	public void pointLike(LikeRecord likeRecord) {
		// TODO Auto-generated method stub
		System.out.println("Dao---->pointLike:已点赞");
	}

}
