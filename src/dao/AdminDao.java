package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Admin;

public class AdminDao extends BaseDao {
	// 检查管理员密码
	public Admin checkAdmin(String username, String password) {
		String sql = "SELECT * FROM kit.admin where AdminNickname=? AND AdminPassword = ? ;";
		Admin admin = null;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setAdminID(Integer.parseInt(rs.getString("AdminID")));
				admin.setAdminName(rs.getString("AdminName"));
				admin.setAdminNickname(rs.getString("AdminNickname"));
				admin.setAdminPassword(rs.getString("AdminPassword"));
				admin.setToolTypeID(Integer.parseInt(rs.getString("ToolTypeID")));
			}

		} catch (SQLException se) {
			se.printStackTrace();

		}
		return admin;
	}

	// 增加管理员
	public boolean addAdmin(Admin admin) {
		String sql = "insert into admin" + "(AdminNickname,AdminName,AdminPassword,ToolTypeID)" + "VALUES(?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, admin.getAdminNickname());
			pstmt.setString(2, admin.getAdminName());
			pstmt.setString(3, admin.getAdminPassword());
			pstmt.setInt(4, admin.getToolTypeID());
			System.out.println(admin.toString());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 找到所有管理员
	public ArrayList<Admin> findAllAdmin() {
		ArrayList<Admin> list = new ArrayList<Admin>();
		String sql = "SELECT * FROM kit.admin,kit.tooltype where kit.admin.ToolTypeID=kit.tooltype.ToolTypeID;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminID(Integer.parseInt(rs.getString("AdminID")));
				admin.setAdminName(rs.getString("AdminName"));
				admin.setAdminNickname(rs.getString("AdminNickname"));
				admin.setAdminPassword(rs.getString("AdminPassword"));
				admin.setToolTypeID(Integer.parseInt(rs.getString("ToolTypeID")));
				admin.setToolTypeName(rs.getString("toolTypeName"));
				list.add(admin);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return list;
	}

	// 删除管理员
	public boolean deleteAdmin(int adminid) {
		String sql = "delete from kit.admin  where 	AdminID=?;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, adminid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 修改管理员
	public boolean changeAdmin(Admin admin) {
		String sql = "update kit.admin set AdminNickName=?, Adminname=?,ToolTypeID=? where AdminID=?;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, admin.getAdminNickname());
			pstmt.setString(2, admin.getAdminName());
			pstmt.setInt(3, admin.getToolTypeID());
			pstmt.setInt(4, admin.getAdminID());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 修改密码
	public boolean changeAdminps(Admin admin) {
		String sql = "update kit.admin set AdminPassword=? where AdminID=?;";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, admin.getAdminPassword());
			pstmt.setInt(2, admin.getAdminID());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

}
