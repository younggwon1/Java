# Spring&JDBC

## Oracle

실행화면

<img src="https://user-images.githubusercontent.com/42603919/79036074-70f1e780-7bff-11ea-9769-67cbc8ef8491.PNG" alt="캡처" style="zoom:67%;" />



![캡처](https://user-images.githubusercontent.com/42603919/79036192-cc70a500-7c00-11ea-9d75-e6263afefe31.PNG)



**Run SQL Command Line에 다음 순서대로 작성하기**

```sql
SQL> start C:\Users\sku66\java\sql_oracle\hr.sql
```



```sql
SQL> start C:\Users\sku66\java\sql_oracle\scott.sql

// root로 접속하겠다. , scott이라는 sql을 생성
```



```sql
SQL> start C:\Users\sku66\java\sql_oracle\user.sql
```



```sql
SQL> start C:\Users\sku66\java\sql_oracle\student.sql
```



```sql
SQL> start C:\Users\sku66\java\sql_oracle\person.sql
```



### Oracle용 JDBC Driver가 필요하다.

[download](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html)

Oracle은 Maven Repository가 아닌 직접 사이트에 가서 다운받기.



##### 1. javase 포함된 JDBC api는 인터페이스가 대부분을 차지한다.

##### 2. java.sql, javax.sql package

##### 3. 인터페이스 구현은 DB vender가 한다.

##### 4. 접속하기 위해서 DB vender가 제공하는 JDBC Driver jar(zip)을 사용해야 한다.



## JDBC Coding 절차 

1. **Driver 등록**

   ```java
   Class.forName("oracle.jdbc.OracleDriver");
   Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
   Class.forName("org.gjt.mm.mysql.Driver");
   ...
   벤더 중립적이게끔 하기위해서 forName을 사용한다.
   new OracleDriver() 식으로 사용한다면 다른 db도 이렇게 작성해야하기 때문에 개발하기에 불편하다. <- vender 종속적
   ```

2. **DBMS와 연결**

   ```java
   String url = "db 접속 정보";
   String user = "user 정보";
   String pass = "비밀번호";
   Connection con = DriverManager.getConnection(url, user, pass);
   ```

3. **Statement 생성** : Query문을 실행해주는 역할

   ```java
   Statement stmt = con.createStatement();
   ```

4. **SQL 전송**

   ```java
   ResultSet rs = stmt.executeQuery(sql); //select sql문(조회)
   int result = stmt.executeUpdate(sql); //DML(등록, 갱신, 삭제)
   ```

5. **결과 받기**

   ```java
   while( rset.next() ){  //rset.next()는 true or false(boolean type)
    System.out.println( rset.getString( "ID“ ) + "\t\t\t" +
    rset.getString( 2 ) );
    }
   ```

   ![캡처](https://user-images.githubusercontent.com/42603919/79038959-ace57680-7c18-11ea-8eac-12566b848248.PNG)

6. **닫기**

   - rset.close()
   - stmt.close()
   - conn.close()
   
   
   
   

**프로젝트 만들기**



![캡처](https://user-images.githubusercontent.com/42603919/79036921-06917500-7c08-11ea-8f2c-4a3a5cef6976.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79036931-1f9a2600-7c08-11ea-9cd9-b848c2e29b6d.PNG)



**JdbcPrj우측버튼 클릭 -> Build path -> configure build path**



![캡처](https://user-images.githubusercontent.com/42603919/79037027-bbc42d00-7c08-11ea-9b2a-cce266c3fa1f.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79037036-cda5d000-7c08-11ea-8874-2bf6f78643d8.PNG)



**src 밑에 jdbc파일 추가하기**



![캡처](https://user-images.githubusercontent.com/42603919/79037183-ca5f1400-7c09-11ea-8d05-3b4af6d0a356.PNG)



**jdbc 밑에 UserSelect.java 생성, UserVO.java 이용**

![캡처](https://user-images.githubusercontent.com/42603919/79085138-51c79700-7d72-11ea-862e-50dd0588d63a.PNG)





```java
# UsersSelect.java

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
			//2. Connection 생성
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection" + con);
			//3. Statement 생성
			stmt = con.createStatement();
			System.out.println("Statement" + stmt);
			//4. sql문 실행 : executeQuery()
			rs = stmt.executeQuery(sql);
			System.out.println("ResultSet" + rs);
			//5. Query 결과값 처리
			//VO객체에 변수로 저장
			UserVO userVO = null;
			//객체가 여러개이기 때문에 List로 저장
			List<UserVO> userList = new ArrayList<>();
			while(rs.next()) {
				String userid = rs.getString("userid");
				String name = rs.getString("name");
				char gender = rs.getString("gender").charAt(0);
				String addr = rs.getString("city");
				
				//UserVO 객체 저장
				userVO = new UserVO(userid, name, gender, addr);
				System.out.println(userid + " " + name + " " + gender + " " + addr);
				System.out.println(userVO);
				//객체가 여러개이기 때문에 List로 저장
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

결과
Driver Loading
Connectionoracle.jdbc.driver.T4CConnection@ff5b51f
Statementoracle.jdbc.driver.OracleStatementWrapper@64d2d351
ResultSetoracle.jdbc.driver.OracleResultSetImpl@534df152
gildong 홍길동 남 서울
UserVO [userid=gildong, name=홍길동, gender=남, city=서울]
spring springs b busan
UserVO [userid=spring, name=springs, gender=b, city=busan]
UserVO [userid=gildong, name=홍길동, gender=남, city=서울]
UserVO [userid=spring, name=springs, gender=b, city=busan]
```



```java
# UserVO.java

package jdbc.user.vo;
/**
 * VO(Value Object)
 * Java Beans, DTO(Data Transfer Object, Entity를 통칭해서 VO라고 한다.
 *	
 */

public class UserVO {
	private String userid;
	private String name;
	private char gender;
	private String city;

	public UserVO() {
	}

	public UserVO(String userid, String name, char gender, String city) {
		super();
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", name=" + name + ", gender=" + gender + ", city=" + city + "]";
	}

	
}
```



---



### ORM(Object Relational Mapping)

- MyBatis, JPA

- Mapping Rule(중요, 기억할 것)

  ```
  java                db
  Class(Vo)  < = >    Table
  Object     < = >    Row(Record)
  Variable   < = >    Column
  ```

  

---



### Run SQL Command Line

#### Update query

```
SQL> update users set name='gildong', gender='girl', city='inchen' where userid='gildong';

//db에 반영
SQL> commit;
```



#### Eclipse에서 동작해보기

**jdbc 밑에 UserUpdate.java 생성**

![캡처](https://user-images.githubusercontent.com/42603919/79086343-abca5b80-7d76-11ea-9cf4-449f9b1d481b.PNG)



[PreparedStatement](https://docs.oracle.com/javase/7/docs/api/)

> 가변적으로 바뀌는 부분은 ?로 설정하고 나머지는 db에 보내어 db가 생성될 수 있도록 함.
>
> 같은 Query를 반복 수행해야 하는 경우 성능이 좋다. (loop 이용이 용이)

```java
# UserUpdate.java

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

결과
Driver Loading
갱신된 건수1
```



### JDBC는 여기까지..



---

