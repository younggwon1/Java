package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesRead2 {

	public static void main(String[] args) {
		//1. Driver class loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading OK!!");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String pass = "hr";
		String sql = "select * from departments";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//2. DB ���� : Connection ����
			con = DriverManager.getConnection(url, user, pass);
			System.out.println(con.getClass().getName());
			//3. SQL �����ϱ� ���� �غ�: Statement ����
			stmt = con.createStatement();
			System.out.println(stmt.getClass().getName());
			//4. SQL ����
			rs = stmt.executeQuery(sql);
			//5. query ��� ó��
			while(rs.next()) {
				String id = rs.getString("manager_id");
				String name = rs.getString("location_id");
				System.out.println(id+" " + name);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
