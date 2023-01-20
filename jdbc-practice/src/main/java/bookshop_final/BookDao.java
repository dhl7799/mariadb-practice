package bookshop_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BookDao {
	
	public List<BookVo> findAllBooks() {
		List<BookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = conn = ConnectionControl.getConnection();
			
			String sql ="select * from book";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVo vo = new BookVo();
				vo.setNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getLong(3));
				vo.setCategoryNo(rs.getLong(4));
				
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
	
	public void insertBook(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = conn = ConnectionControl.getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategoryNo());
			
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
	
	public BookVo findBookByNo(Long num) {
		BookVo result = new BookVo();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql ="select * from book where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, num);	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.setNo(rs.getLong(1));
				result.setTitle(rs.getString(2));
				result.setPrice(rs.getLong(3));
				result.setCategoryNo(rs.getLong(4));
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
				System.out.println("Error [findbyNo]: " + e);
			}
		}
		
		return result;
	}
	
	public BookVo findBookByTitle(String title) {
		BookVo result = new BookVo();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql ="select * from book where title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.setNo(rs.getLong(1));
				result.setTitle(rs.getString(2));
				result.setPrice(rs.getLong(3));
				result.setCategoryNo(rs.getLong(4));
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
				System.out.println("Error [findbyNo]: " + e);
			}
		}
		
		return result;
	}
	
	public List<BookVo> findBookByCategory(Long category) {
		List<BookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql ="select * from book where category_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, category);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVo vo = new BookVo();
				vo.setNo(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getLong(3));
				vo.setCategoryNo(rs.getLong(4));
				
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
	
}
