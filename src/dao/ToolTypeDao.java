package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Admin;
import entity.ToolType;
public class ToolTypeDao extends BaseDao {
	        //增加工具
			public boolean addToolType(ToolType tooltype) {
				String sql = "insert into ToolType"
						+ "(ToolTypeName)"
						+ "VALUES(?)";
				try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
					
					pstmt.setString(1, tooltype.getToolTypeName());
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					return false;
				}
			}
		
			// 找到所有工具类别
			public ArrayList<ToolType> findAllToolType() {
				ArrayList<ToolType> list = new ArrayList<ToolType>();
				String sql = "SELECT * FROM kit.tooltype;";
				try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						ToolType tooltype = new ToolType();
						tooltype.setToolTypeID(Integer.parseInt(rs.getString("ToolTypeID")));
						tooltype.setToolTypeName(rs.getString("ToolTypeName"));
						System.out.println(tooltype.toString());
						list.add(tooltype);
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
				return list;
			}
			
			//修改工具类别
			public boolean changeToolType(int tooltypeid,String tooltypename) {
				String sql = "update kit.tooltype set ToolTypeName=? where ToolTypeID=?;";
				try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, tooltypename);
					pstmt.setInt(2, tooltypeid);
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					return false;
				}
			}
			//删除工具类别
			public boolean deleteToolType(int tooltypeid){
				String sql = "delete from kit.tooltype  where ToolTypeID=?;";
				try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setInt(1, tooltypeid);
					pstmt.executeUpdate();
					return true;
				} catch (SQLException se) {
					se.printStackTrace();
					return false;
				}
			}
			

}
