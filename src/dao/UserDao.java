package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao extends BaseDao {

	// 检查用户密码
	public User checkUser(String username, String password) {
		String sql = "SELECT * FROM kit.user where UserNickname=? AND UserPassword = ?;";
		User user = null;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setDepartment(rs.getString("Department"));
				user.setEmail(rs.getString("Email"));
				user.setPhone(rs.getString("Phone"));
				user.setUserID(Integer.parseInt(rs.getString("UserID")));
				user.setUserName(rs.getString("UserName"));
				user.setUserNickname(rs.getString("UserNickname"));
				user.setUserPassword(rs.getString("UserPassword"));
			}
			return user;
		} catch (SQLException se) {
			se.printStackTrace();
			return user;
		}
	}

	// 增加用戶
	public boolean addUser(User user) {
		String sql = "insert into User" + "(UserID,UserNickname,UserPassword,UserName,Email,Phone,Department)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, user.getUserID());
			pstmt.setString(2, user.getUserNickname());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserName());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getDepartment());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	public void updatePassword(String password1) {
		// TODO Auto-generated method stub
		String sql = "Update User set UserPassword=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, password1);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
