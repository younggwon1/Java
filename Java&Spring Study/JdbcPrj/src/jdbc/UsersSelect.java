package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.user.vo.UserVO;

public class UsersSelect {

	public static void main(String[] args) {
		
		//1. Driver Class Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loading");
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		
		
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from users";
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String pass = "tiger";
		
		try {
			//2. Connection ����
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection" + con);
			//3. Statement ����
			stmt = con.createStatement();
			System.out.println("Statement" + stmt);
			//4. sql�� ���� : executeQuery()
			rs = stmt.executeQuery(sql);
			System.out.println("ResultSet" + rs);
			//5. Query ����� ó��
			//VO��ü�� ������ ����
			UserVO userVO = null;
			//��ü�� �������̱� ������ List�� ����
			List<UserVO> userList = new ArrayList<>();
			while(rs.next()) {
				String userid = rs.getString("userid");
				String name = rs.getString("name");
				char gender = rs.getString("gender").charAt(0);
				String addr = rs.getString("city");
				
				//UserVO ��ü ����
				userVO = new UserVO(userid, name, gender, addr);
				System.out.println(userid + " " + name + " " + gender + " " + addr);
				System.out.println(userVO);
				//��ü�� �������̱� ������ List�� ����
				userList.add(userVO);
				
			}
			for (UserVO user2 : userList) {
				System.out.println(user2);
			}
			
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
