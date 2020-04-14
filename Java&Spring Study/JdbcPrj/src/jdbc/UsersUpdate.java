package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsersUpdate {

	public static void main(String[] args) {
		
		String sql = "update users set name=?, gender=?, city=? where userid=?";
		
		//class Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loading");
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		
		Connection con =null;
		PreparedStatement stmt = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pass = "tiger";
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "mybatis"); //name
			stmt.setString(2, "girl"); //gender
			stmt.setString(3, "chungbuk"); //city
			stmt.setString(4, "gildong"); //userid
			
			int cnt = stmt.executeUpdate();
			System.out.println("갱신된 건수" + cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
