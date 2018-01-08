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
		User user = new User();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				user.setDepartment(rs.getString("Department"));
				user.setEmail(rs.getString("Email"));
				user.setPhone(rs.getString("Phone"));
				user.setUserID(Integer.parseInt(rs.getString("UserID")));
				user.setUserName(rs.getString("UserName"));
				user.setUserNickname(rs.getString("UserNickname"));
				user.setUserPassword(rs.getString("UserPassword"));
				return user;
		} catch (SQLException se) {
			se.printStackTrace();
			return user;
		}
	}

}
