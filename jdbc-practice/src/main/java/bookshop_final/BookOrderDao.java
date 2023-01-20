package bookshop_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookOrderDao {
	public List<BookOrderVo> showAll() {
		List<BookOrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql ="select * from bookOrder";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookOrderVo vo = new BookOrderVo();
				vo.setBook_no(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setCount(rs.getLong(3));
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error [BookOrderDao showAll()]:" + e);
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
	
	public void insertBookOrder(Long no, String title, Long count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionControl.getConnection();

			String sql2 = "insert into bookOrder "
					+ "value (?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setLong(1, no);
			pstmt.setString(2, title);
			pstmt.setLong(3, count);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error [BookOrderDao insertBookOrder()]: " + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Error: " + e);
			}
		}
	}
	
	public void addBookOrder(Long no, String title, Long count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionControl.getConnection();

			String sql2 = "Update bookOrder set count = count + ? where book_no = ?";
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setLong(1, count);
			pstmt.setLong(2, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Error [BookOrderDao addBookOrder()]: " + e);
			}
		}
	}
	
}
