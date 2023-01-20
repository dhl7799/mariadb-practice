package bookshop_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
	public List<CategoryVo> getCategory() {
		List<CategoryVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			
			String sql ="select *" + 
				    "  from category";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CategoryVo vo = new CategoryVo();
				vo.setNo(rs.getLong(1));
				vo.setCategoryName(rs.getString(2));
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error [getUserInfo]: " + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Error [getUserInfo_fin]: " + e);
			}
		}
		return result;
		
	}
	
	public void addCategory(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql = "insert into category values(null,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
