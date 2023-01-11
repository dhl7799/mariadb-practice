package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectionTest02 {
	public static void main(String[] args) {
		search("pat");
	}
	
	public static void search(String keyword) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mariadb://192.168.0.19:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			String sql =
					"select emp_no, first_name, last_name" + 
				    "  from employees" +
					" where first_name like '%" + keyword + "%'";
			
			//3. Statement 준비
			stmt = conn.prepareStatement(sql);
			
			//4. binding
			stmt.setString(1,"%" + keyword + "%");
			
			rs = stmt.executeQuery();
			
			//5. 결과 처리
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				
				System.out.println(empNo + ":" + firstName + ":" + lastName);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stmt != null) {
					stmt.close();
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