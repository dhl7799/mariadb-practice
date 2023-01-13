package bookshop_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CartDao {
	
	public List<CartVo> printMyCart(String email){
		List<CartVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="select no, title, count, price from cart where user_email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVo vo = new CartVo();
				vo.setUser_Email(email);
				vo.setNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setCount(rs.getLong(3));
				vo.setPrice(rs.getLong(4));
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
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
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean deleteAllFromCart(String email) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			conn = getConnection();
			

			String sql =
					"delete" + 
					"  from cart" + 
					" where user_email = ?";
			pstmt = conn.prepareStatement(sql);
			

			pstmt.setString(1, email);
			

			int counting = pstmt.executeUpdate();
			

			result = counting == 1;
			
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
		
		return result;
	}
	
	public boolean deleteFromCart(String email, BookVo book, int count) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			conn = getConnection();
			

			String sql =
					"delete" + 
					"  from cart" + 
					" where user_email = ? and title = ? and count = ?";
			pstmt = conn.prepareStatement(sql);
			

			pstmt.setString(1, email);
			pstmt.setString(2, book.getTitle());
			pstmt.setLong(3, (long)count);
			

			int counting = pstmt.executeUpdate();
			

			result = counting == 1;
			
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
		
		return result;
	}
	
	public void putInCart(String email, BookVo book, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into cart values(null,?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setLong(2, (long)(count));
			pstmt.setLong(3, book.getPrice()*count);
			pstmt.setString(4, email);
			
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
