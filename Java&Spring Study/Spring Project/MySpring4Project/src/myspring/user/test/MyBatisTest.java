package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.mapper.StudentMapper;
import myspring.user.service.UserService;
import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory SqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentMapper studentMapper;
	
	
	@Test @Ignore
	public void stuMapper() {
		//Test case : StudentMapper -> SqlSession -> StudentMapper.xml
		//new DeptVO(20)은 StudentMapper.xml에서 #{dept.deptid}
		StudentVO student = new StudentVO(1500, "둘리", 10, "3학년", "주간", new DeptVO(20));
		int cnt = studentMapper.insertStudent(student);
		System.out.println("등록학생 건수" + cnt);
		
		
		
		List<StudentVO> selectStudentDeptById = studentMapper.selectStudentDeptById();
		for (StudentVO studentVO : selectStudentDeptById) {
			System.out.println(studentVO);
		}
	}
	
	@Test //@Ignore
	public void service() {
		//순서 : UserService -> UserDao -> SqlSession -> SqlSessionFactory -> DataSource
		UserVO user = userService.getUser("gildong");
		System.out.println(user);
	}
	
	
	
	@Test @Ignore
	public void sql2() {
		List<UserVO> selectList = sqlSession.selectOne("userNS.selectUserList", "gildong");
		for (UserVO userVO : selectList) {
			System.out.println(userVO);
		}
	}
	

	@Test @Ignore
	public void sql() { //sql test 
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "gildong");
		System.out.println(user);
		
		UserVO insertUser = new UserVO("java", "자바", "여", "제주");
		int cnt = sqlSession.insert("insertUser", insertUser);
		System.out.println("등록 건수 : " + cnt);
	}
	
	@Test @Ignore
	public void ss() { //sqlSession test
		System.out.println(sqlSession.getClass().getName());
	}
	
	@Test @Ignore
	public void mybatis_spring() { //mybatis_spring test
		System.out.println(SqlSessionFactory.getClass().getName());
	}
	
	@Test @Ignore
	public void con() { //connection test
		try {
			Connection con = dataSource.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
