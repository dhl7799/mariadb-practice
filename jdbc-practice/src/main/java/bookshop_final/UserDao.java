package bookshop_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UserDao {

	public void SignUp(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into user "
					+ "value (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhoneNumber());
			pstmt.setString(4, vo.getPassword());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error [SignUp]:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Error [SignUp_fin]:" + e);
			}
		}
	}
	
	public String getPassword(String email) {
		String result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			
			String sql ="select password" + 
				    "  from user" +
					" where email = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
			
		} catch (SQLException e) {
			System.out.println("Error [getPassword]:" + e);
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
				System.out.println("Error [getPassword_fin]:" + e);
			}
		}
		
		return result;
	}
	
	public void getUserInfo(UserVo vo,String email, String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			
			String sql ="select *" + 
				    "from user" +
					" where email = ? and password = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setName(rs.getString(2));
				vo.setPhoneNumber(rs.getString(3));
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
		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.19:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}
}
