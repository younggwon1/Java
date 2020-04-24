# AOP(Aspect Oriented Programming)

### AOP(Aspect Oriented Programming)

- **핵심기능과 부가기능을 분리하자!!**
  - **핵심기능** : dao, service, controller와 같은 업무 로직을 포함하는 모듈
  - **부가기능** : 공통적으로 사용되는 로직을 포함하는 모듈
  - 핵심기능에서 부가기능을 직접 호출하지 않는다. 
    - **핵심기능과 부가기능을 합쳐주는(Weaving) 역할은 Framework가 Runtime에 한다.**
- **AOP를 통해 부가적인 공통 코드들을 효율적으로 관리**
- **관점(관심) 지향 프로그래밍**
- 부가기능적인 측면에서 보았을때 공통된 요소를 추출하자는 것이다. -> **공통된 기능을 재사용하는 기법**
- DI는 낮은 결합도를 위한 것이라면 **AOP는 높은 응집도를 위한 것**

- 특징 : 
  - Spring은 프록시(Proxy) 기반 AOP를 지원한다.
  - 프록시(Proxy)가 호출을 가로챈다(Intercept).
  - Spring AOP는 메서드 조인 포인트만 지원한다.



#### **Target**

- **부가기능을 부여할 대상**
- 핵심기능을 담고 있는 모듈



#### **Aspect**

- 흩어진 관심사를 모듈화 한 것. 주로 부가기능을 모듈화함. **advice + pointcut**(어떤 포인트컷 메서드에 어떤 어드바이스 메소드를 실행할지 결정한다.)
- AOP의 가장 기본이 되는 모듈.
- **Aspect = Advisor (only Spring)**



#### Advisor

- 포인트컷과 어드바이스를 하나씩 갖고 있는 오브젝트이다. AOP의 가장 기본이 되는 모듈.

  

#### **Advice**

- **실질적으로 부가기능을 담은 구현체, 공통기능을 담고있는 모듈**

- 로깅, 인증, 트랜잭션처리, 응답시간 체크 등등

- 유형 : 

  - before : target 호출 전
  - after : target 호출 후, 정상/예외 상관없이 항상 호출
  - after-throwing : target 호출 후, 에러가 발생하면 호출
  - after-returning : target 호출 후, 정상이면 호출
  - around : target 호출 전, 후

- Advice 클래스 작성

  - 메서드에서 JoinPoint, ProceedingJoinPoint을 주입 받는다.

  - joinPoint.getSignature().getName(); <- target 메서드 이름

  - ProceedingJoinPoint - proceed()

  - Spring Bean Conf xml

    ```xml
    <bean id="ptAdvice" class="myspring.aop.xml.PerformanceTraceAdvice"/>
    	<aop:config>
    		<aop:aspect ref="ptAdvice">
    			<aop:around method="trace" pointcut="execution(public * myspring.user..*(..))"/>
    		</aop:aspect>
    	</aop:config>
    ```

  - @Aspect

    - 클래스안에 pointcut 설정
    - @Before, @AfterReturning, @AfterThrowing, @After, @Around



#### **PointCut**

- **부가기능이 적용될 대상(메소드)를 선정하는 방법**을 얘기한다. 즉, 어드바이스를 적용할 조인포인트를 선별하는 기능을 정의한 모듈을 애기한다. **어드바이스를 적용할 타겟을 선정할 때 사용하는 표현식**
- JointPoint의 상세한 스펙을 정의한 것(포인트컷은 필터링된 조인포인트를 의미한다.)



#### **JoinPoint**

- **어드바이스가 적용될 수 있는 위치**, 끼어들 수 있는 지점. 메서드 진입 지점, 생성자 호출 시점, 필드에서 값을 꺼내올 때 등 다양한 시점에 적용가능
- **target에 포함된 메서드, joinpoint 메서드가 런타임 호출될 때 advice와 target이 합쳐진다.**
- 클라이언트가 호출하는 모든 비즈니스 메소드, 모든 메소드를 조인포인트로 생각하면 된다. -> 이 중에서 포인트컷이 결정 됨.



#### **Weaving**

- Advice를 핵심 로직 코드에 적용하는 것을 weaving 이라고 한다.
- 포인트컷에 의해서 결정된 타겟의 **조인 포인트에 부가기능(어드바이스)을 삽입하는 과정**을 뜻한다.

---

#### 의존성 설치하기

1. [Maven Spring AOP](https://mvnrepository.com/artifact/org.springframework/spring-aop/5.2.5.RELEASE)

2. 복사

   ```xml
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-aop</artifactId>
       <version>5.2.5.RELEASE</version>
   </dependency>
   ```

   

3. pom.xml에 붙여넣기

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/80051165-7e3d9900-8552-11ea-8c18-f1810758e73f.PNG)



1. [Maven AspectJ Weaver](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver/1.9.5)

2. 복사

   ```xml
   <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjweaver</artifactId>
       <version>1.9.5</version>
   </dependency>
   ```

   

3. pom.xml에 붙여넣기

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/80051259-b5ac4580-8552-11ea-8cbf-a880642284c4.PNG)



1. [Maven AspectJ Runtime](https://mvnrepository.com/artifact/org.aspectj/aspectjrt/1.9.5)

2. 복사

   ```xml
   <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
   <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjrt</artifactId>
       <version>1.9.5</version>
   </dependency>
   ```

   

3. pom.xml에 붙여넣기

4. 생성 완료

   ![캡처1](https://user-images.githubusercontent.com/42603919/80051261-b6dd7280-8552-11ea-9478-ae684ee10c24.PNG)

---



![캡처](https://user-images.githubusercontent.com/42603919/80058616-b6e66e00-8564-11ea-8021-79bca25f5be3.PNG)

```java
# PerformanceTraceAdvice.java

package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;

//어드바이스 타입 : Around Advice
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메서드의 signature 정보
		String targetMethodName = joinPoint.getSignature().getName();		
		System.out.println(targetMethodName + " 시작");
		
		//타겟 메서드의 Argument 정보
		for(Object arg : joinPoint.getArgs()) {
			System.out.println(targetMethodName + "의 아규먼트 : " + arg);
		}
		
		//타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();
		
		try {
			//new Object[] {new String("dooly")}
			//intercepted된 타겟의 메서드를 호출해 주어야한다.
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(targetMethodName + " 종료");
			System.out.println(targetMethodName + " 실행 시간 : " + 
			   (finish - start) + " ms");
		}
	}
}
```



![캡처](https://user-images.githubusercontent.com/42603919/80064274-a937e500-8572-11ea-8711-c021d5b904fc.PNG)



### XML에 설정해서 해보기

#### spring_beans.xml의 Namespaces에서 aop를 추가하고 4.3 xsd를 추가한다.

**그런 다음 spring_beans.xml에 다음을 추가한다.**

![캡처](https://user-images.githubusercontent.com/42603919/80062344-74c22a00-856e-11ea-852f-9dac4a93414e.PNG)



```
<aop:aspect> 태그의 ref 속성은 Aspect로서 기능을 제공할 Bean을 설정할 때 사용함

<aop:around> 태그의 pointcut 속성의 execution 지시자(designator)는
어드바이스를 적용할 패키지, 클래스, 메서드를 표현할 때 사용됨
```



```xml
# spring_beans.xml

	<!-- AOP 설정 -->
	<bean id="ptAdvice" class="myspring.aop.xml.PerformanceTraceAdvice"/>
	<aop:config>
		<aop:aspect ref="ptAdvice">
			<aop:around method="trace" pointcut="execution(public * myspring.user..*(..))"/>
<!-- 			<aop:around method="trace" pointcut="execution(public void myspring.user..*())"/> -->
<!-- 			<aop:around method="trace" pointcut="execution(public * myspring.user..*User(..))"/> -->
<!-- 			<aop:around method="trace" pointcut="execution(public * myspring.user..read*(..))"/> -->
<!-- 			<aop:around method="trace" pointcut="execution(public * myspring.user.service..*(..))"/> -->
<!-- 			<aop:around method="trace" pointcut="execution(public * myspring.user.dao..*(..))"/> -->			
<!-- 			<aop:around method="trace" pointcut="execution(public void myspring.user..*(..))"/> -->
<!-- 			<aop:around method="trace" pointcut="execution(private * myspring.user..*(..))"/> -->
		</aop:aspect>
	</aop:config>
```

**그리고 나서 실행을 하게 되면 다음과 같은 아이콘이 나오게 된다.**

<img src="https://user-images.githubusercontent.com/42603919/80059964-578a5d00-8568-11ea-892f-5b7e7cc24e77.PNG" alt="캡처" style="zoom: 200%;" />

```java
# MyBatisTest.java

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

결과
getUser 시작
getUser의 아규먼트 : gildong
read 시작
read의 아규먼트 : gildong
selectUserById 시작
selectUserById의 아규먼트 : gildong
2020-04-23 14:51:53 994 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Creating a new SqlSession
2020-04-23 14:51:53 997 [main] DEBUG org.mybatis.spring.SqlSessionUtils - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@b2f4ece] was not registered for synchronization because synchronization is not active
2020-04-23 14:51:54 348 [main] DEBUG org.mybatis.spring.transaction.SpringManagedTransaction - JDBC Connection [47719432, URL=jdbc:oracle:thin:@127.0.0.1:1521:xe, UserName=SCOTT, Oracle JDBC driver] will not be managed by Spring
2020-04-23 14:51:54 355 [main] DEBUG myspring.user.dao.mapper.UserMapper.selectUserById - ==>  Preparing: select * from users where userid=? 
2020-04-23 14:51:54 427 [main] DEBUG myspring.user.dao.mapper.UserMapper.selectUserById - ==> Parameters: gildong(String)
2020-04-23 14:51:54 458 [main] DEBUG myspring.user.dao.mapper.UserMapper.selectUserById - <==      Total: 1
2020-04-23 14:51:54 462 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@b2f4ece]
selectUserById 종료
selectUserById 실행 시간 : 475 ms
read 종료
read 실행 시간 : 475 ms
getUser 종료
getUser 실행 시간 : 475 ms
User [userId=gildong, name=mybatissadsss, gender=남, city=제주]
```



---



### @Aspect 어노테이션을 사용해서 해보기

![캡처](https://user-images.githubusercontent.com/42603919/80065000-5101e280-8574-11ea-957e-fe52ae1ea3a1.PNG)

```java
# LoggingAspect.java

package myspring.aop.annot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	protected static final Logger logger = LogManager.getLogger();
	
	//Before Advice 전처리 어드바이스
    @Before("execution(public * myspring..*(..))")
	public void before(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();	
		if( logger.isDebugEnabled() ) {
			logger.debug(">>>> @Before [ " + signatureString + " ] 메서드 실행 전처리 수행");
		}
		for (Object arg : joinPoint.getArgs()) {
			logger.debug("@Before [ " + signatureString + " ] 아규먼트 " + arg);			
		}		
	}
    //후처리 어드바이스 : target의 메서드가 정상종료 되었을때만 적용됨
    @AfterReturning(pointcut="execution(public * myspring.user.service.*.*(..))", returning="ret")
	public void afterReturning(JoinPoint joinPoint, Object ret) {
		String signatureString = joinPoint.getSignature().getName();		
		logger.debug("@AfterReturing [ " + signatureString + " ] 메서드 실행 후처리 수행");
		logger.debug("@AfterReturing [ " + signatureString + " ] 리턴값=" + ret);

	}
    //후처리 어드바이스 : target의 메서드가 에러가 발생되었을 때만 적용됨
    @AfterThrowing(pointcut="execution(* *..UserService*.*(..))", 
    		throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();	
		logger.debug("@AfterThrowing [ " + signatureString + " ] 메서드 실행 중 예외 발생");
		logger.debug("@AfterThrowing [ " + signatureString + " ] 예외=" + ex.getMessage());
	}
    //후처리 어드바이스 : target의 메서드의 정상/에러에 관계없이 무조건 적용됨
    @After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		logger.debug("@After [ " + signatureString + " ] 메서드 실행 완료");
	}
}
```



##### @Aspect 지원

```xml
# spring_beans.xml

<!-- @Aspect 지원 -->
<aop:aspectj-autoproxy />
```



##### component-scan 수정

```xml
# spring_beans.xml

<!-- 상위 인터페이스로 설정 -->
<!-- Component Auto Scanning 설정 -->
<!-- myspring.aop 추가 -->
<context:component-scan base-package="myspring.user,myspring.aop">
		<!-- @Controller 어노테이션을 선언한 컴포넌트는 제외하겠다. -->
		<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	</context:component-scan>
```



```java
# MyBatisTest.java

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

결과
getUser 시작
getUser의 아규먼트 : gildong
2020-04-23 15:21:38 516 [main] DEBUG myspring.aop.annot.LoggingAspect - >>>> @Before [ getUser ] 메서드 실행 전처리 수행
2020-04-23 15:21:38 516 [main] DEBUG myspring.aop.annot.LoggingAspect - @Before [ getUser ] 아규먼트 gildong
read 시작
read의 아규먼트 : gildong
2020-04-23 15:21:38 517 [main] DEBUG myspring.aop.annot.LoggingAspect - >>>> @Before [ read ] 메서드 실행 전처리 수행
2020-04-23 15:21:38 517 [main] DEBUG myspring.aop.annot.LoggingAspect - @Before [ read ] 아규먼트 gildong
selectUserById 시작
selectUserById의 아규먼트 : gildong
2020-04-23 15:21:38 518 [main] DEBUG myspring.aop.annot.LoggingAspect - >>>> @Before [ selectUserById ] 메서드 실행 전처리 수행
2020-04-23 15:21:38 519 [main] DEBUG myspring.aop.annot.LoggingAspect - @Before [ selectUserById ] 아규먼트 gildong
2020-04-23 15:21:38 530 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Creating a new SqlSession
2020-04-23 15:21:38 537 [main] DEBUG org.mybatis.spring.SqlSessionUtils - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@554cd74a] was not registered for synchronization because synchronization is not active
2020-04-23 15:21:38 913 [main] DEBUG org.mybatis.spring.transaction.SpringManagedTransaction - JDBC Connection [1428664849, URL=jdbc:oracle:thin:@127.0.0.1:1521:xe, UserName=SCOTT, Oracle JDBC driver] will not be managed by Spring
2020-04-23 15:21:38 919 [main] DEBUG myspring.user.dao.mapper.UserMapper.selectUserById - ==>  Preparing: select * from users where userid=? 
2020-04-23 15:21:38 988 [main] DEBUG myspring.user.dao.mapper.UserMapper.selectUserById - ==> Parameters: gildong(String)
2020-04-23 15:21:39 017 [main] DEBUG myspring.user.dao.mapper.UserMapper.selectUserById - <==      Total: 1
2020-04-23 15:21:39 022 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@554cd74a]
selectUserById 종료
selectUserById 실행 시간 : 505 ms
read 종료
read 실행 시간 : 507 ms
2020-04-23 15:21:39 024 [main] DEBUG myspring.aop.annot.LoggingAspect - @After [ getUser ] 메서드 실행 완료
2020-04-23 15:21:39 024 [main] DEBUG myspring.aop.annot.LoggingAspect - @AfterReturing [ getUser ] 메서드 실행 후처리 수행
2020-04-23 15:21:39 024 [main] DEBUG myspring.aop.annot.LoggingAspect - @AfterReturing [ getUser ] 리턴값=User [userId=gildong, name=mybatissadsss, gender=남, city=제주]
getUser 종료
getUser 실행 시간 : 508 ms
User [userId=gildong, name=mybatissadsss, gender=남, city=제주]
```



















