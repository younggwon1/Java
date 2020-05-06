package jdbc.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.user.vo.UserVO;

public class UserDAO {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String pass = "tiger";

	public UserDAO() {
		//1. Driver class loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading OK!!");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	public void close(Statement stmt, Connection con) throws SQLException {
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	}
	
	
	//Insert �ϴ� �޼���
	public int insertUser(UserVO user) {
		String sql = "insert into users values(?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		int updateCnt = 0;
		try {
			con = getConnection();
			//auto commit ����
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUserid());
			stmt.setString(2, user.getName());
			stmt.setString(3, Character.toString(user.getGender()));
			stmt.setString(4, user.getCity());
			updateCnt = stmt.executeUpdate();
			//Ŀ��
			con.commit();
		}catch(SQLException e) {
			//�ѹ�
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCnt;
	}
	
	
	//update �ϴ� �޼���
	public int updateUser(UserVO user) {
		String sql = "update users set name = ?, gender = ?, city = ? where userid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		int updateCnt = 0;
		try {
			con = getConnection();
			//auto commit ����
			con.setAutoCommit(false);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, Character.toString(user.getGender()));
			stmt.setString(3, user.getCity());
			stmt.setString(4, user.getUserid());
			updateCnt = stmt.executeUpdate();
			//Ŀ��
			con.commit();
		}catch(SQLException e) {
			//�ѹ�
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCnt;
	}
	
	//userid�� �Է� �޾Ƽ� 1���� row�� ��ȯ�ϴ� �޼���
	public UserVO getUser(String userid) {
		String sql = "select * from users where userid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		UserVO user = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			ResultSet rs =  stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO(rs.getString("userid"), 
						          rs.getString("name"), 
						          rs.getString("gender").charAt(0), 
						          rs.getString("city"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	//��ü row�� ��ȯ�ϴ� �޼���
	public List<UserVO> getUsers() {
		String sql = "select * from users order by userid";
		Connection con = null;
		PreparedStatement stmt = null;
		UserVO user = null;
		List<UserVO> userList = new ArrayList<>();
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()) {
				user = new UserVO(rs.getString("userid"), 
						          rs.getString("name"), 
						          rs.getString("gender").charAt(0), 
						          rs.getString("city"));
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(stmt,con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}//getUserList
	
	
}
