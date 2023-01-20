package bookshop_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
	public List<OrderVo> showAll(){
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql ="select * from orders";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVo vo = new OrderVo();
				vo.setNo(rs.getLong(1));
				vo.setUsrName(rs.getString(2));
				vo.setTotalPrice(rs.getLong(3));
				vo.setAddress(rs.getString(4));
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
	
	public List<OrderVo> showInfoByName(String name){
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql ="select * from orders where usrName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVo vo = new OrderVo();
				vo.setNo(rs.getLong(1));
				vo.setUsrName(rs.getString(2));
				vo.setTotalPrice(rs.getLong(3));
				vo.setAddress(rs.getString(4));
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
	
	

	public void insertOrder(String name, Long price, String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionControl.getConnection();
			
			String sql = "insert into orders "
					+ "value (null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setLong(2, price);
			pstmt.setString(3, address);
			
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
}
