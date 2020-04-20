# Spring&MyBatis

> MyBatis는 자바 오브젝트와 SQL문 사이의 자동 Mapping 기능을 지원하는 ORM 프레임워크이다.
>
>  SQL을 별도의 파일로 분리해서 관리

[MyBatis Introduce](https://mybatis.org/mybatis-3/)

[mybatis 3.5.4 API](https://javadoc.io/doc/org.mybatis/mybatis/latest/index.html)

[mybatis-spring 2.0.4 API](https://mybatis.org/spring/apidocs/index.html)



**다음 3가지를 pom.xml에 붙여넣기**

1. [Maven MyBatis](https://mvnrepository.com/artifact/org.mybatis/mybatis/3.5.4)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79091184-4cc11280-7d87-11ea-8737-e620029828ab.PNG)

3. pom.xml에 붙여넣기

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>10</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<properties>
   		<spring.version>4.3.26.RELEASE</spring.version>
   	</properties>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-test</artifactId>
   			<version>${spring.version}</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		
   		<!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis</artifactId>
   			<version>3.5.4</version>
   		</dependency>
   	</dependencies>
   </project>
   ```

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/79091282-a295ba80-7d87-11ea-91af-1eeae15a2114.PNG)





1. [Maven MyBatis Spring](https://mvnrepository.com/artifact/org.mybatis/mybatis-spring/2.0.4)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79091351-dec91b00-7d87-11ea-92d0-f9ca85ac6bdf.PNG)

3. pom.xml에 붙여넣기

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>10</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<properties>
   		<spring.version>4.3.26.RELEASE</spring.version>
   	</properties>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-test</artifactId>
   			<version>${spring.version}</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis</artifactId>
   			<version>3.5.4</version>
   		</dependency>
           
           <!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis-spring</artifactId>
   			<version>2.0.4</version>
   		</dependency>
   
   	</dependencies>
   </project>
   ```

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/79091523-952d0000-7d88-11ea-9915-d15e678bea01.PNG)





1. [Maven Spring JDBC](https://mvnrepository.com/artifact/org.springframework/spring-jdbc/5.2.5.RELEASE)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79091452-454e3900-7d88-11ea-8688-f580d04d55d9.PNG)

3. pom.xml에 붙여넣기

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>10</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<properties>
   		<spring.version>4.3.26.RELEASE</spring.version>
   	</properties>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-test</artifactId>
   			<version>${spring.version}</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis</artifactId>
   			<version>3.5.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis-spring</artifactId>
   			<version>2.0.4</version>
   		</dependency>
           
           <!-- 추가한 부분 --> 
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-jdbc</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   
   	</dependencies>
   </project>
   ```

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/79091422-28b20100-7d88-11ea-83c4-f4573d4fc3a7.PNG)



---



### JDBC Driver 준비

![캡처](https://user-images.githubusercontent.com/42603919/79092396-bb07d400-7d8b-11ea-9315-d72eefe14942.PNG)



#### pom.xml에 추가

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>MySpring4Project</groupId>
	<artifactId>MySpring4Project</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>10</release>
				</configuration>
			</plugin>
			<plugin>
				<artifactId>maven-war-plugin</artifactId>
				<version>3.2.1</version>
				<configuration>
					<warSourceDirectory>WebContent</warSourceDirectory>
				</configuration>
			</plugin>
		</plugins>
	</build>
	<properties>
		<spring.version>4.3.26.RELEASE</spring.version>
	</properties>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13</version>
			<!-- <scope>test</scope> -->
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${spring.version}</version>
			<!-- <scope>test</scope> -->
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.5.4</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>2.0.4</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${spring.version}</version>
		</dependency>

        
        
		<!-- 추가한 부분 -->
		<!-- Oracle JDBC Driver -->
		<!-- 해당 파일이 Local에 있는 경우 -->
		<dependency>
			<groupId>ojdbc</groupId>
			<artifactId>ojdbc</artifactId>
			<version>6</version>
			<scope>system</scope>
			<systemPath>${basedir}/WebContent/WEB-INF/lib/ojdbc6.jar</systemPath>
		</dependency>

        
        
	</dependencies>
</project>
```



![캡처](https://user-images.githubusercontent.com/42603919/79092610-644eca00-7d8c-11ea-9e76-20928564c0da.PNG)



---



## DBCP(DataBase Connection Pool)

> 효율적인 DB 커넥션을 위해 DBCP를 사용한다.
>
> WAS 실행 시 미리 일정량의 DB Connection 객체를 생성하고 Pool 이라는 공간에 저장해둔다.
>
> 그리고 DB 연결 요청이 있으면, 이 Pool 이라는 공간에서 Connection 객체를 가져다 쓰고 반환 하게 된다.



**JDBC만을 사용할 경우라면 DB접속 시** 아래와 같은 순서가 반복되게 된다.

1. DB 접속을 위한 JDBC 드라이버 로드

2. getConnection Method로 부터 DB 커넥션 객체를 얻음

3. 쿼리 수행을 위한 PreparedStatement 객체 생성

4. excuteQuery를 실행해서 결과를 받아옴.



여기서 비효율적인 부분은 1번과 2번이다.

**DB 연결 시 마다 Driver를 로드하고 커넥션 객체를 얻는 작업을 반복하게 된다.**

**이 부분을 효율적으로 처리하도록 바꾸는 것이 DBCP의 역할이다.**



DBCP를 사용하므로써 설정할 수 있는 옵션은 아래와 같다.

1. maxActive : 동시에 사용할 수 있는 최대 커넥션 개수
2. maxIdle : Connection Pool에 반납할 때 최대로 유지될 수 있는 커넥션 개수
3. minIdle : 최소한으로 유지할 커넥션 개수
4. initialSize : 최소로 getConnection() Method를 통해 커넥션 풀에 채워 넣을 커넥션 개수



1. [Apache Commons DBCP](https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2/2.7.0)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79094007-04a6ed80-7d91-11ea-92b3-cf7e3533a01c.PNG)



3. pom.xml에 붙여넣기

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>10</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<properties>
   		<spring.version>4.3.26.RELEASE</spring.version>
   	</properties>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-test</artifactId>
   			<version>${spring.version}</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis</artifactId>
   			<version>3.5.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis-spring</artifactId>
   			<version>2.0.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-jdbc</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   
   		<!-- Oracle JDBC Driver -->
   		<!-- 해당 파일이 Local에 있는 경우 -->
   		<dependency>
   			<groupId>ojdbc</groupId>
   			<artifactId>ojdbc</artifactId>
   			<version>6</version>
   			<scope>system</scope>
   			<systemPath>${basedir}/WebContent/WEB-INF/lib/ojdbc6.jar</systemPath>
   		</dependency>
   
           
           
           <!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
   		<dependency>
   			<groupId>org.apache.commons</groupId>
   			<artifactId>commons-dbcp2</artifactId>
   			<version>2.7.0</version>
   		</dependency>
           
          
   
   
   	</dependencies>
   </project>
   ```

   

4. 생성 완료

![캡처](https://user-images.githubusercontent.com/42603919/79094059-33bd5f00-7d91-11ea-9ef8-3d1f5736d258.PNG)



---



## MyBatis 설정

![캡처](https://user-images.githubusercontent.com/42603919/79102575-f4e5d400-7da5-11ea-8aad-bc6a36f011fb.PNG)

### MyBatis-Spring의 주요 컴포넌트의 역할

- **MyBatis 설정파일 (SqlMapConfig.xml)**
  - VO 객체의 정보를 설정한다. 
- **SqlSession FactoryBean**
  - MyBatis 설정파일을 바탕으로 SqlSessionFactory를 생성한다. 
  - Spring Bean으로 등록해야 한다.
- **SqlSessionTemplate**
  - 핵심적인 역할을 하는 클래스로서 SQL 실행이나 트랜잭션 관리를 실행한다. 
  - SqlSession 인터페이스를 구현하며, Thread-safe하다. 
  - Spring Bean으로 등록해야 한다.
- **Mapping 파일 (UserMapper.xml)**
  - SQL문과 OR Mapping을 설정한다. 
- **Spring Bean 설정파일(beans.xml)**
  - SqlSessionFactoryBean을 Bean 등록할 때 DataSource 정보와 MyBatis Config 파일정보, Mapping 파일의 정보를 함께 설정한다. 
  - SqlSesseionTemplate을 Bean으로 등록한다.





## Datasource 구현체인 BasicDataSource 클래스

### Properties 설정

```
# valies.properties

db.driverClass=oracle.jdbc.OracleDriver
db.url=jdbc:oracle:thin:@127.0.0.1:1521:xe
db.username=scott
db.password=tiger
```



```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

    
    
	<!-- 추가한 부분 -->
	<!-- Datasource 구현체인 BasicDataSource 클래스를 Bean으로 등록 -->
	<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="driverClassName" value="${db.driverClass}"/>
		<property name="url" value="${db.url}"/>
		<property name="username" value="${db.username}"/>
		<property name="password" value="${db.password}"/>
	</bean>
	
	
    <context:property-placeholder location="classpath:config/values.properties"/>
    
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan base-package="myspring.di.annot" />
	
	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성함 -->
		<property name="name" value="Spring" /> <!-- String -->
		<property name="printer" ref="sPrinter" /> <!-- Printer -->
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- consturctor injection : 아규먼트가 있는 (중복정의된) constructor 를 사용해서 객체를 생성-->
		<constructor-arg index="0" value="Constructor" />
		<constructor-arg index="1" ref="cPrinter" /> <!-- Hello가 ConsolePrinter를 참조하게 됨 -->
		<property name="names">  <!-- setNames(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
		<property name="ages"> <!-- setAges(Map<String,Integer>) -->
			<map>
				<entry key="java" value="10" />
				<entry key="js" value="20" />
				<entry key="react" value="30" />
			</map>
		</property>
	</bean>
</beans>
```



### Test 해보기

![캡처](https://user-images.githubusercontent.com/42603919/79096627-a5e57200-7d98-11ea-958d-66645f19fbb1.PNG)

```java
# MyBatisTest.java

package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void con() { //connection test
		try {
			Connection con = dataSource.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
```



---



![캡처](https://user-images.githubusercontent.com/42603919/79097621-2dcc7b80-7d9b-11ea-9d4b-5958614bdb3f.PNG)



#### java8에서는 동작을 하지만 java10이상에서는 오류가 발생한다.

![캡처](https://user-images.githubusercontent.com/42603919/79098763-a0d6f180-7d9d-11ea-9daf-6a14a8c38b12.PNG)

1. [Maven JAXB API](https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.3.1)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79098862-d085f980-7d9d-11ea-9332-461a7d2b8c06.PNG)

3. pom.xml에 붙여넣기

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>10</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<properties>
   		<spring.version>4.3.26.RELEASE</spring.version>
   	</properties>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-test</artifactId>
   			<version>${spring.version}</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis</artifactId>
   			<version>3.5.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis-spring</artifactId>
   			<version>2.0.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-jdbc</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   
   		<!-- Oracle JDBC Driver -->
   		<!-- 해당 파일이 Local에 있는 경우 -->
   		<dependency>
   			<groupId>ojdbc</groupId>
   			<artifactId>ojdbc</artifactId>
   			<version>6</version>
   			<scope>system</scope>
   			<systemPath>${basedir}/WebContent/WEB-INF/lib/ojdbc6.jar</systemPath>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
   		<dependency>
   			<groupId>org.apache.commons</groupId>
   			<artifactId>commons-dbcp2</artifactId>
   			<version>2.7.0</version>
   		</dependency>
   
           
           
           
           <!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
   		<dependency>
   			<groupId>javax.xml.bind</groupId>
   			<artifactId>jaxb-api</artifactId>
   			<version>2.3.1</version>
   		</dependency>
   
           
           
           
   	</dependencies>
   </project>
   ```

4. 생성 완료

   ![캡처](https://user-images.githubusercontent.com/42603919/79098936-00350180-7d9e-11ea-8f44-63f146a4bded.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79098968-12af3b00-7d9e-11ea-80a3-256390cfee45.PNG)



---



### SqlSessionFactoryBean 클래스

```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">

    
    
    
	<!-- 추가한 부분 -->
	<!-- SqlSessionFactoryBean 클래스를  Bean으로 등록-->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="configLocation" value="classpath:config/SqlMapConfig.xml"/>
		<property name="mapperLocations">
			<list>
				<!-- *Mapper.xml을 사용하면  StudentMapper.xml, UserMapper.xml을
				동시에 처리가능하다.-->
				<value>classpath:config/*Mapper.xml</value> 
			</list>
		</property>
	</bean>



    <context:property-placeholder location="classpath:config/values.properties"/>
    
	<!-- Datasource 구현체인 BasicDataSource 클래스를 Bean으로 등록 -->
	<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="driverClassName" value="${db.driverClass}"/>
		<property name="url" value="${db.url}"/>
		<property name="username" value="${db.username}"/>
		<property name="password" value="${db.password}"/>
	</bean>
	
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan base-package="myspring.di.annot" />
	
	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성함 -->
		<property name="name" value="Spring" /> <!-- String -->
		<property name="printer" ref="sPrinter" /> <!-- Printer -->
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- consturctor injection : 아규먼트가 있는 (중복정의된) constructor 를 사용해서 객체를 생성-->
		<constructor-arg index="0" value="Constructor" />
		<constructor-arg index="1" ref="cPrinter" /> <!-- Hello가 ConsolePrinter를 참조하게 됨 -->
		<property name="names">  <!-- setNames(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
		<property name="ages"> <!-- setAges(Map<String,Integer>) -->
			<map>
				<entry key="java" value="10" />
				<entry key="js" value="20" />
				<entry key="react" value="30" />
			</map>
		</property>
	</bean>
</beans>
```



### Test 해보기

```java
# MyBatisTest.java

package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory SqlSessionFactory;
	
	@Test
	public void mybatis_spring() { //mybatis_spring test
		System.out.println(SqlSessionFactory.getClass().getName());
	}
	
	@Test @Ignore(잠시 정지)
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
Hello Default Constructor called...
Hello Default Constructor called...
Hello setName() called..Spring
Hello setPrinter() called..myspring.di.xml.StringPrinter
OverLoading Hello Constructor called..
org.apache.ibatis.session.defaults.DefaultSqlSessionFactory
```



---



### SqlSessionTemplate 클래스

```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">




	<!-- 추가한 부분 -->
	<!-- SqlSessionTemplate 클래스를  Bean으로 등록 -->
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactory"/>
	</bean>
	
	
	
    

	<!-- SqlSessionFactoryBean 클래스를  Bean으로 등록-->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="configLocation" value="classpath:config/SqlMapConfig.xml"/>
		<property name="mapperLocations">
			<list>
				<!-- *Mapper.xml을 사용하면  StudentMapper.xml, UserMapper.xml을
				처리가능하다.-->
				<value>classpath:config/*Mapper.xml</value> 
			</list>
		</property>
	</bean>

    <context:property-placeholder location="classpath:config/values.properties"/>

	<!-- Datasource 구현체인 BasicDataSource 클래스를 Bean으로 등록 -->
	<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="driverClassName" value="${db.driverClass}"/>
		<property name="url" value="${db.url}"/>
		<property name="username" value="${db.username}"/>
		<property name="password" value="${db.password}"/>
	</bean>
    
    
<!-- 	<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource"  -->
<!-- 		p:driverClassName="${db.driverClass}" -->
<!-- 		p:url="${db.url}" -->
<!-- 		p:username="${db.username}" -->
<!-- 		p:password="${db.password}" -->
<!-- 	/> -->
	
	
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan base-package="myspring.di.annot" />
	
	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />
	
	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성함 -->
		<property name="name" value="Spring" /> <!-- String -->
		<property name="printer" ref="sPrinter" /> <!-- Printer -->
	</bean>
	
	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- consturctor injection : 아규먼트가 있는 (중복정의된) constructor 를 사용해서 객체를 생성-->
		<constructor-arg index="0" value="Constructor" />
		<constructor-arg index="1" ref="cPrinter" /> <!-- Hello가 ConsolePrinter를 참조하게 됨 -->
		<property name="names">  <!-- setNames(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
		<property name="ages"> <!-- setAges(Map<String,Integer>) -->
			<map>
				<entry key="java" value="10" />
				<entry key="js" value="20" />
				<entry key="react" value="30" />
			</map>
		</property>
	</bean>
</beans>

```



### Test 해보기

```java
# MyBatisTest.java

package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory SqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;

	
	@Test
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
Hello Default Constructor called...
Hello Default Constructor called...
Hello setName() called..Spring
Hello setPrinter() called..myspring.di.xml.StringPrinter
OverLoading Hello Constructor called..
org.mybatis.spring.SqlSessionTemplate
```



---



### sql Test

```java
package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

	@Test
	public void sql() { //sql test 
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "gildong");
		System.out.println(user);
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
    
Hello Default Constructor called...
Hello Default Constructor called...
Hello setName() called..Spring
Hello setPrinter() called..myspring.di.xml.StringPrinter
OverLoading Hello Constructor called..
```



### Insert 해보기

```java
package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	

	@Test 
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
```



### List 불러오기

```java
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

import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
    
	@Test
	public void sql2() {
		//특정 user를 update
		UserVO updateUser = new UserVO("java", "자바2", "여2", "제주2");
		int cnt = sqlSession.update("userNS.updateUser", updateUser);
		System.out.println("update cnt " + cnt);
		
		List<UserVO> selectList = sqlSession.selectList("userNS.selectUserList");
		for (UserVO userVO : selectList) {
			System.out.println(userVO);
		}
	}
	
    
    
	@Test @Ignore
	public void sql() {
		//SqlSession의 selectOne()
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "gildong");
		System.out.println(user);
		
		UserVO insertUser = new UserVO("java", "자바", "여", "제주");
		int cnt = sqlSession.insert("insertUser", insertUser);
		System.out.println("등록된 건수 : " + cnt);
	}
	
	@Test @Ignore
	public void mybatis_spring() {
		System.out.println(sqlSessionFactory.getClass().getName());
		System.out.println(sqlSession.getClass().getName());
		
	}
	
	//DataSource dataSource = new BasicDataSource();
	@Test @Ignore
	public void con() {
		try {
			Connection con = dataSource.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
```



---



## log4j2

> query문을 log에 출력해주는 설정, logging을 위한 open source library
>
> Log Level : Trace, Debug, Info, Warn, Error

```
Logger logger = LogManager.getLogger();

for(int i=0;i++){
	logger.debug("i값은" + i); <- 1)
	logger.error("error msg" + e.getMessage()); <- 2)
}

현재 log level이 debug이면 1), 2) 둘 다 출력
현재 log level이 error이면 2) 출력
```



[Log4j2 참고](https://cofs.tistory.com/354)



#### 설치하기

1. [Maven log4j2](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core/2.13.1)

2. 복사

   ![캡처](https://user-images.githubusercontent.com/42603919/79176672-d3372c00-7e3b-11ea-8878-f92dbf86d195.PNG)

3. 붙여넣기

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
   	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>
   	<groupId>MySpring4Project</groupId>
   	<artifactId>MySpring4Project</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>war</packaging>
   	<build>
   		<sourceDirectory>src</sourceDirectory>
   		<plugins>
   			<plugin>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.8.0</version>
   				<configuration>
   					<release>10</release>
   				</configuration>
   			</plugin>
   			<plugin>
   				<artifactId>maven-war-plugin</artifactId>
   				<version>3.2.1</version>
   				<configuration>
   					<warSourceDirectory>WebContent</warSourceDirectory>
   				</configuration>
   			</plugin>
   		</plugins>
   	</build>
   	<properties>
   		<spring.version>4.3.26.RELEASE</spring.version>
   	</properties>
   	<dependencies>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-context</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/junit/junit -->
   		<dependency>
   			<groupId>junit</groupId>
   			<artifactId>junit</artifactId>
   			<version>4.13</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-test</artifactId>
   			<version>${spring.version}</version>
   			<!-- <scope>test</scope> -->
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis</artifactId>
   			<version>3.5.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   		<dependency>
   			<groupId>org.mybatis</groupId>
   			<artifactId>mybatis-spring</artifactId>
   			<version>2.0.4</version>
   		</dependency>
   		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   		<dependency>
   			<groupId>org.springframework</groupId>
   			<artifactId>spring-jdbc</artifactId>
   			<version>${spring.version}</version>
   		</dependency>
   
   		<!-- Oracle JDBC Driver -->
   		<!-- 해당 파일이 Local에 있는 경우 -->
   		<dependency>
   			<groupId>ojdbc</groupId>
   			<artifactId>ojdbc</artifactId>
   			<version>6</version>
   			<scope>system</scope>
   			<systemPath>${basedir}/WebContent/WEB-INF/lib/ojdbc6.jar</systemPath>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
   		<dependency>
   			<groupId>org.apache.commons</groupId>
   			<artifactId>commons-dbcp2</artifactId>
   			<version>2.7.0</version>
   		</dependency>
   
   		<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
   		<dependency>
   			<groupId>javax.xml.bind</groupId>
   			<artifactId>jaxb-api</artifactId>
   			<version>2.3.1</version>
   		</dependency>
   
   
   
   
   		<!-- 추가한 부분 -->
   		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
   		<dependency>
   			<groupId>org.apache.logging.log4j</groupId>
   			<artifactId>log4j-core</artifactId>
   			<version>2.13.1</version>
   		</dependency>
   
           
           
   
   	</dependencies>
   </project>
   ```

4. 생성완료

   ![캡처](https://user-images.githubusercontent.com/42603919/79176758-12657d00-7e3c-11ea-81b9-81da8f28bd61.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/79177786-9456a580-7e3e-11ea-88c9-a119c9d8bc99.PNG)

#### log4j2.xml에서는 log level 설정, appender(log 출력을 콘솔에 할지 파일에 할지 지정하는 것)를 설정



```xml
# log4j2.xml

<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO">
	<Appenders>
		<File name="File" fileName="c:/temp/log/logfile.log" append="true">
			<PatternLayout
				pattern="%d{yyyy-MM-dd HH:mm:ss SSS} [%t] %-5level %logger{36} - %msg%n" />
		</File>
		<Console name="console" target="SYSTEM_OUT">
			<PatternLayout
				pattern="%d{yyyy-MM-dd HH:mm:ss SSS} [%t] %-5level %logger{36} - %msg%n" />
		</Console>
	</Appenders>

	<Loggers>
<!-- 		<Logger name="org.springframework" level="DEBUG" additivity="false"> -->
<!-- 			<AppenderRef ref="console" /> -->
<!-- 			<AppenderRef ref="File" /> -->
<!-- 		</Logger> -->
<!-- 		<Logger name="myspring" level="DEBUG"> -->
<!-- 			<AppenderRef ref="console" /> -->
<!-- 			<AppenderRef ref="File" /> -->
<!-- 		</Logger> -->

		<!-- Level 설정 -->
		<Root level="TRACE">
			<AppenderRef ref="console" level="DEBUG" /> 
			<AppenderRef ref="File" level="DEBUG" />
		</Root>
	</Loggers>
</Configuration>
```



---

**Controller** : 화면과 Service를 연결해주는 객체

**Service** : Business Logic을 포함하는 객체

**DAO** : Data Access Logic을 포함하는 객체

**VO** : Value Object 값을 저장하는 객체

---



## Mapper Interface

> Type Safe하게 Query를 호출해보자!

```
User는 myspring.user.vo.UserVO 클래스를 줄여쓴 alias 문자열이다.
VO에 대한 aliasing 설정은 SqlMapConfig.xml(MyBatis Config xml)에 설정

<mapper namespace="userNS">
	<select id="selectUserByID" parameterType="string" resultType="User">
		select * from users where userid=#{value}
	</select>
</mapper>


SqlSession 인터페이스 : Mapper XML(Sql문 포함)에 있는 SQL을 실행(수행)
=> SelectOne() :
	//SQL Id값이 단순 문자열이므로 Type Safe하지 않아서, 잠재적인 run time 에러를
	//발생시킬 수 있다. -> 그래서 Mapper 인터페이스를 사용
	UserVO user = sqlSession.selectOne("userNS.selectUserByID","gildong")
	
,  SelectList() ,  insert(),  update(),  delete()
```



### Mapper Interface 작성

- **Mapper 인터페이스 내의 메서드명은 Mapper xml에 선언된 SQL id와 반드시 같아야한다**.

  Mapper Interface를 사용하는 이유는? **잠재적인 run time 에러를 줄이기 위해서 사용.** 

  직접 문자열로 하는것이 아니라 Mapper 인터페이스 내의 메서드, sqlSession을 불러준다. 

  **흐름 : Service -> DAO -> (User)Mapper -> SqlSession -> Mapper.xml**

```java
public interface UserMapper {
   UserVO selectUserById(String id);
}
@Repository("userDao")
public class UserDaoImplMapper implements UserDao {
     @Autowired
     private UserMapper userMapper;	
}
//Level 1 : UserMapper가 SqlSession을 의존하는 설정
//아래와 같이 설정하면 Mapper 인터페이스가 추가될때 마다 설정을 계속 추가해야 한다.
<bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
    <property name="mapperInterface" value="myspring.user.dao.mapper.UserMapper" />
    <property name="sqlSessionTemplate" ref="sqlSession" />
</bean>

//Level2 : 
//사용자 정의 어노테이션 선언
public @interface MyMapper {
}
@MyMapper  //나는 Mapper 인터페이스 역할을 합니다.
public interface UserMapper {
   UserVO selectUserById(String id);
}
@MyMapper 
public interface ProductMapper {
}
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
   <property name="basePackage" value="myspring.user.dao.mapper"/>
  <property name="annotationClass" value="myspring.user.dao.mapper.MyMapper" /> 
</bean>
```





![캡처](https://user-images.githubusercontent.com/42603919/79180696-8c4e3400-7e45-11ea-90f2-6e06dd8e2b42.PNG)



```java
# UserMapper.xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
<!-- <mapper namespace="userNS"> -->    
<mapper namespace="myspring.user.dao.mapper.UserMapper">

	<select id="selectUserById" parameterType="string" resultType="User">
		select * from users where userid=#{value}
	</select>

	<select id="selectUserList" resultType="User">
		select * from users order by userid
	</select>

	<insert id="insertUser" parameterType="User">
		insert into users
		values(#{userId},#{name},#{gender},#{city} )
	</insert>

	<update id="updateUser" parameterType="User">
		update users set
		name = #{name},
		gender = #{gender},
		city = #{city}
		where userid = #{userId}
	</update>

	<delete id="deleteUser" parameterType="string">
		delete from users where
		userid = #{value}
	</delete>

	<insert id="insertPerson" parameterType="Person">
		<selectKey resultType="integer" keyProperty="seq" order="BEFORE">
			SELECT person_seq.nextval from dual
		</selectKey>
		INSERT INTO person (seq, ssn, name, address, phone)
		VALUES(#{seq}, #{ssn}, #{name},#{address},#{phone})
	</insert>
	
</mapper>
```



```java
# UserMapper.java

package myspring.user.dao.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import myspring.user.vo.UserVO;

@MyMapper
public interface UserMapper {
	//@Select("select * from users where userid=#{id}")
	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	void insertUser(UserVO userVO);
	void updateUser(UserVO userVO);
	void deleteUser(String id);
}
```



```java
# UserDaoImplMapper.java

package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImplMapper implements UserDao {
	@Autowired
	private UserMapper userMapper;	
	
	@Override
	public UserVO read(String id) {
		UserVO user  = userMapper.selectUserById(id);
		return user;
	}
	
	public List<UserVO> readAll() {
		List<UserVO> userList = userMapper.selectUserList();
		return userList;
	}

	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("등록된 Record UserId=" + user.getUserId() + 
				" Name=" + user.getName());
	}

	@Override
	public void update(UserVO user) {
		userMapper.updateUser(user);
	}
	
	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println("삭제된 Record with ID = " + id ); 
	}
}
```



```java
# UserDaoImpl.java

package myspring.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;
//@Repository("userDao")
public class UserDaoImpl implements UserDao {

	//@Autowired
    private SqlSession session;
	
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public UserVO read(String id) {
		UserVO user  = session.selectOne("userNS.selectUserById", id);
		return user;
	}

	public List<UserVO> readAll() {
		List<UserVO> userList = session.selectList("userNS.selectUserList");
		return userList;
	}
	
	public void insert(UserVO user) {
		session.update("userNS.insertUser", user);
		System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
	}

	@Override
	public void update(UserVO user) {
		session.update("userNS.updateUser", user);
	}

	@Override
	public void delete(String id) {
		session.delete("userNS.deleteUser", id);
		System.out.println("삭제된 Record with ID = " + id ); 
	}

}
```



```xml
# spring_beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context-4.3.xsd">




	<!-- UserMapper 설정 -->
	<!-- MapperScannerConfigurer 설정 -->
	<!-- myspring.user.dao.mapper package 아래에 @MyMapper라는 어노테이션을 선언한 Mapper 인터페이스를
		모두 찾으세요라는 의미이다. -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="myspring.user.dao.mapper" />
		<property name="annotationClass" value="myspring.user.dao.mapper.MyMapper" />
	</bean>


	<!-- Mapper 설정 -->
	<!-- 다음과 같이 설정하면, Mapper 인터페이스가 추가될 때마다 계속 Mapper 인터페이스 이름을 설정해 주어야한다.(단점) -->
	<!-- <bean id="userMapper" -->
	<!-- class="org.mybatis.spring.mapper.MapperFactoryBean"> -->
	<!-- <property name="mapperInterface" value="myspring.user.dao.mapper.UserMapper" 
		/> -->
	<!-- <property name="sqlSessionTemplate" ref="sqlSession" /> -->
	<!-- </bean> -->




	<!-- SqlSessionTemplate 클래스를 Bean으로 등록 -->
	<bean id="sqlSession"
		class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="sqlSessionFactory" />
	</bean>


	<!-- SqlSessionFactoryBean 클래스를 Bean으로 등록 -->
	<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation"
			value="classpath:config/SqlMapConfig.xml" />
		<property name="mapperLocations">
			<list>
				<!-- *Mapper.xml을 사용하면 StudentMapper.xml, UserMapper.xml을 처리가능하다. -->
				<value>classpath:config/*Mapper.xml</value>
			</list>
		</property>
	</bean>

    <context:property-placeholder location="classpath:config/values.properties"/>

	<!-- Datasource 구현체인 BasicDataSource 클래스를 Bean으로 등록 -->
	<bean id="dataSource"
		class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="driverClassName" value="${db.driverClass}" />
		<property name="url" value="${db.url}" />
		<property name="username" value="${db.username}" />
		<property name="password" value="${db.password}" />
	</bean>

	<!-- <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" -->
	<!-- p:driverClassName="${db.driverClass}" -->
	<!-- p:url="${db.url}" -->
	<!-- p:username="${db.username}" -->
	<!-- p:password="${db.password}" -->
	<!-- /> -->







	<!-- 고친 부분 -->
	<!-- 상위 인터페이스로 설정 -->
	<!-- Component Auto Scanning 설정 -->
	<context:component-scan
		base-package="myspring.user" />





	<!-- StringPrinter 클래스를 Bean으로 설정 -->
	<bean id="sPrinter" class="myspring.di.xml.StringPrinter" />
	<!-- ConsolePrinter 클래스를 Bean으로 설정 -->
	<bean id="cPrinter" class="myspring.di.xml.ConsolePrinter" />

	<!-- Hello 클래스를 Bean으로 설정 -->
	<!-- scope : singleton, prototype, request, session -->
	<bean id="hello" class="myspring.di.xml.Hello" scope="singleton">
		<!-- setter injection : default constructor를 사용해서 객체를 생성함 -->
		<property name="name" value="Spring" /> <!-- String -->
		<property name="printer" ref="sPrinter" /> <!-- Printer -->
	</bean>

	<bean id="helloC" class="myspring.di.xml.Hello">
		<!-- consturctor injection : 아규먼트가 있는 (중복정의된) constructor 를 사용해서 객체를 생성 -->
		<constructor-arg index="0" value="Constructor" />
		<constructor-arg index="1" ref="cPrinter" /> <!-- Hello가 ConsolePrinter를 참조하게 됨 -->
		<property name="names">  <!-- setNames(List<String>) -->
			<list>
				<value>Java</value>
				<value>Kotlin</value>
				<value>Scalar</value>
				<value>Java</value>
			</list>
		</property>
		<property name="ages"> <!-- setAges(Map<String,Integer>) -->
			<map>
				<entry key="java" value="10" />
				<entry key="js" value="20" />
				<entry key="react" value="30" />
			</map>
		</property>
	</bean>
</beans>
```



```sql
# user.sql

CREATE TABLE USERS 
(
	userid     VARCHAR2(30)  NOT NULL PRIMARY KEY,
	name       VARCHAR2(100) NOT NULL,
    gender     VARCHAR2(10),
	city       VARCHAR2(30)
);

insert into users values ('gildong','홍길동','남','서울');
commit;
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

import myspring.user.service.UserService;
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
	
    
    
    
	@Test
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
```



---

### **하지만 다음과 같은 상황이 더 많다. 따라서 다음과 같은 상황에 대해서 더 공부할 것**

```java
# StudentVO.java

package myspring.user.vo;

import java.util.List;

public class StudentVO {
	private Integer id;
	private String name;
	private Integer age;
	private String grade;
	private String daynight;

	private DeptVO dept; //1:1 관계

	private List<CourseStatusVO> courseStatus; //1:n 관계

	public StudentVO() {

	}

	public StudentVO(Integer id, String name, Integer age, String grade, String daynight, DeptVO dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.daynight = daynight;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDaynight() {
		return daynight;
	}

	public void setDaynight(String daynight) {
		this.daynight = daynight;
	}

	public DeptVO getDept() {
		return dept;
	}

	public void setDept(DeptVO dept) {
		this.dept = dept;
	}

	public List<CourseStatusVO> getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(List<CourseStatusVO> courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", daynight=" + daynight
				+ ", dept=" + dept + ", courseStatus=" + courseStatus + "]";
	}

}
```



```java
# DeptVO.java

package myspring.user.vo;

public class DeptVO {
	private Integer deptid;
	private String deptname;
	
	public DeptVO() {
		
	}

	public DeptVO(Integer deptid) {
		this.deptid = deptid;
	}
	public DeptVO(Integer deptid, String deptname) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", deptname=" + deptname + "]";
	}
}

```



```xml
# StudentMapper.xml

<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- <mapper namespace="studentNS"> -->
<mapper namespace="myspring.user.dao.mapper.StudentMapper">
	
	<!-- Student : StudentVO를 나타낸다. -->
	<!-- 컬럼명과 VO객체의 setter method를 수동으로 매핑해주어야한다. -->
    <!-- type에서 Student는 myspring.user.vo.StudentVO를 가리킨다. --> 
	<resultMap id="studentDeptResultMap" type="Student">
		<id property="id" column="stu_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="name" column="stu_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="age" column="stu_age" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="grade" column="stu_grade" javaType="String"
			jdbcType="VARCHAR" />
		<result property="daynight" column="stu_daynight" javaType="String"
			jdbcType="VARCHAR" />
        <!-- property="dept"는 SetDept(DeptVO dept)를 가리킨다. -->
		<association property="dept" column="dept_id" javaType="Dept"
			resultMap="deptResultMap" />
	</resultMap>
			
	<resultMap id="studentCourseStatusResultMap" type="Student">
		<id property="id" column="stu_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="name" column="stu_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="age" column="stu_age" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="grade" column="stu_grade" javaType="String"
			jdbcType="VARCHAR" />
		<result property="daynight" column="stu_daynight" javaType="String"
			jdbcType="VARCHAR" />
		<collection property="courseStatus" ofType="CourseStatus" 
			resultMap="coursestatusResultMap" />			
	</resultMap>
	
	<resultMap id="studentResultMap" type="Student">
		<id property="id" column="stu_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="name" column="stu_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="age" column="stu_age" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="grade" column="stu_grade" javaType="String"
			jdbcType="VARCHAR" />
		<result property="daynight" column="stu_daynight" javaType="String"
			jdbcType="VARCHAR" />
	</resultMap>
	
	<resultMap id="deptResultMap" type="Dept">
		<id property="deptid" column="dept_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="deptname" column="dept_name" javaType="String"
			jdbcType="VARCHAR" />
	</resultMap>

	<resultMap id="courseResultMap" type="Course">
		<id property="courseId" column="course_id" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="courseName" column="course_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="courseInstructor" column="course_instructor"
			javaType="String" jdbcType="VARCHAR" />
	</resultMap>

	<resultMap id="coursestatusResultMap" type="CourseStatus">
		<id property="statusId" column="status_id" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="courseScore" column="course_score" javaType="Integer"
			jdbcType="NUMERIC" />
		<association property="course" column="course_id" javaType="Course"
			resultMap="courseResultMap" />
	</resultMap>

	<select id="selectStudentDeptById" resultMap="studentDeptResultMap">
		select s.stu_id,
		s.stu_name,
		s.stu_age,
		s.stu_grade,
		s.stu_daynight,
		d.dept_id,
		d.dept_name
		from student s, dept d
		where s.dept_id = d.dept_id
	</select>

	<select id="selectStudentCourseStatusById" resultMap="studentCourseStatusResultMap">
		select  s.stu_id,
		        s.stu_name,
		        s.stu_age,
		        s.stu_grade,
		        s.stu_daynight,
		        c.course_id,
		        c.course_name,
		        c.course_instructor,
		        t.status_id,
		        t.COURSE_SCORE
		from  SCOTT.student s, SCOTT.COURSE_STATUS t, scott.course c
		where s.stu_id = t.stu_id
		  and t.course_id = c.course_id
	</select>
	<select id="selectStudentByName" parameterType="String"
		resultMap="studentResultMap">
		<include refid="selectStudent" />
		where stu_name like '%' || #{value} || '%'
	</select>

	<select id="selectStudentByGradeorDay2" parameterType="Student"
		resultMap="studentResultMap">
		<include refid="selectStudent" />
		<where>
			<if test="grade != null">
				stu_grade = #{grade}
			</if>
			<if test="daynight != null">
				and stu_daynight = #{daynight}
			</if>
		</where>
	</select>

	<select id="selectStudentByGradeorDay" parameterType="Map"
		resultMap="studentResultMap">
		<include refid="selectStudent" />
		<where>
			<if test="grade != null">
				stu_grade = #{grade}
			</if>
			<if test="day != null">
				or stu_daynight = #{day}
			</if>
		</where>
	</select>

	<sql id="selectStudent">
		select * from student
	</sql>

	<select id="selectStudentGrade" resultType="integer">
		select count(*) cnt
		from STUDENT
		group by grade
	</select>

	<insert id="insertStudent" parameterType="Student">
		insert into student
		(stu_id,stu_name,stu_age,stu_grade,stu_daynight,dept_id)
		values(
		#{id},
		#{name},
		#{age},
		#{grade},#{daynight},#{dept.deptid} )
	</insert>

	<update id="updateStudent" parameterType="Student">
		update student set
		stu_name = #{name},
		stu_age = #{age},
		stu_grade = #{grade},
		stu_daynight
		= #{daynight},
		dept_id = #{dept.deptid}
		where stu_id = #{id}
	</update>

	<insert id="insertCourseStatus" parameterType="CourseStatus">
		insert into COURSE_STATUS 
		(STATUS_ID,STU_ID,COURSE_ID,COURSE_SCORE)
		values (
		#{statusId},
		#{student.id},
		#{course.courseId},
		#{courseScore})
	</insert>
	
	<!-- <delete id="deleteStudent" parameterType="Integer"> -->
	<!-- delete from student where id = #{value} -->
	<!-- </delete> -->

</mapper>
```



```sql
# student.sql

CREATE TABLE DEPT 
(
	DEPT_ID     NUMBER (4) NOT NULL PRIMARY KEY,
	DEPT_NAME   VARCHAR2 (30) CONSTRAINT DEPT_NAME_NN NOT NULL
);

insert into DEPT values (10,'경제학과');
insert into DEPT values (20,'컴퓨터공학과');
insert into DEPT values (30,'영어영문학과');
insert into DEPT values (40,'건축공학과');
commit;

CREATE TABLE STUDENT 
(
	STU_ID         NUMBER (6) NOT NULL PRIMARY KEY,
	STU_NAME       VARCHAR2 (20) NOT NULL,
	STU_AGE        NUMBER (3) NOT NULL,
	STU_GRADE      VARCHAR2 (20),
	STU_DAYNIGHT   VARCHAR2 (20),
	DEPT_ID        NUMBER (4) NOT NULL,
	FOREIGN KEY (DEPT_ID) REFERENCES DEPT (DEPT_ID)
);

insert into student values (1002,'홍길동',20,'1학년','주간',30);
commit;

CREATE TABLE COURSE 
(
	COURSE_ID     NUMBER (4) NOT NULL PRIMARY KEY,
	COURSE_NAME   VARCHAR2 (50),
	COURSE_INSTRUCTOR VARCHAR2 (50)
);
insert into COURSE values (1,'자바프로그래밍','김자바');
insert into COURSE values (2,'파이썬프로그래밍','박파이썬');
commit;

CREATE TABLE COURSE_STATUS 
(
    STATUS_ID   NUMBER (6) NOT NULL PRIMARY KEY,
	STU_ID      NUMBER (6) NOT NULL,
	COURSE_ID   NUMBER (4) NOT NULL,
	COURSE_SCORE NUMBER (4) NOT NULL,
	FOREIGN KEY(STU_ID) REFERENCES STUDENT(STU_ID),
	FOREIGN KEY(COURSE_ID) REFERENCES COURSE(COURSE_ID) 
);
insert into COURSE_STATUS values (1,1002,1,90);
insert into COURSE_STATUS values (2,1002,2,80);
commit;

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
	
	
	@Test
	public void stuMapper() {
		List<StudentVO> selectStudentDeptById = studentMapper.selectStudentDeptById();
		for (StudentVO studentVO : selectStudentDeptById) {
			System.out.println(studentVO);
		}
	}
	
	@Test @Ignore
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
```



---



### Insert하기(등록하기)

```xml
# StudentMapper.xml

<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- <mapper namespace="studentNS"> -->
<mapper namespace="myspring.user.dao.mapper.StudentMapper">

	<resultMap id="studentDeptResultMap" type="Student">
		<id property="id" column="stu_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="name" column="stu_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="age" column="stu_age" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="grade" column="stu_grade" javaType="String"
			jdbcType="VARCHAR" />
		<result property="daynight" column="stu_daynight" javaType="String"
			jdbcType="VARCHAR" />
		<association property="dept" column="dept_id" javaType="Dept"
			resultMap="deptResultMap" />
	</resultMap>
			
	<resultMap id="studentCourseStatusResultMap" type="Student">
		<id property="id" column="stu_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="name" column="stu_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="age" column="stu_age" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="grade" column="stu_grade" javaType="String"
			jdbcType="VARCHAR" />
		<result property="daynight" column="stu_daynight" javaType="String"
			jdbcType="VARCHAR" />
		<collection property="courseStatus" ofType="CourseStatus" 
			resultMap="coursestatusResultMap" />			
	</resultMap>
	
	<resultMap id="studentResultMap" type="Student">
		<id property="id" column="stu_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="name" column="stu_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="age" column="stu_age" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="grade" column="stu_grade" javaType="String"
			jdbcType="VARCHAR" />
		<result property="daynight" column="stu_daynight" javaType="String"
			jdbcType="VARCHAR" />
	</resultMap>
	
	<resultMap id="deptResultMap" type="Dept">
		<id property="deptid" column="dept_id" javaType="Integer" jdbcType="NUMERIC" />
		<result property="deptname" column="dept_name" javaType="String"
			jdbcType="VARCHAR" />
	</resultMap>

	<resultMap id="courseResultMap" type="Course">
		<id property="courseId" column="course_id" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="courseName" column="course_name" javaType="String"
			jdbcType="VARCHAR" />
		<result property="courseInstructor" column="course_instructor"
			javaType="String" jdbcType="VARCHAR" />
	</resultMap>

	<resultMap id="coursestatusResultMap" type="CourseStatus">
		<id property="statusId" column="status_id" javaType="Integer"
			jdbcType="NUMERIC" />
		<result property="courseScore" column="course_score" javaType="Integer"
			jdbcType="NUMERIC" />
		<association property="course" column="course_id" javaType="Course"
			resultMap="courseResultMap" />
	</resultMap>

	<select id="selectStudentDeptById" resultMap="studentDeptResultMap">
		select s.stu_id,
		s.stu_name,
		s.stu_age,
		s.stu_grade,
		s.stu_daynight,
		d.dept_id,
		d.dept_name
		from student s, dept d
		where s.dept_id = d.dept_id
	</select>

	<select id="selectStudentCourseStatusById" resultMap="studentCourseStatusResultMap">
		select  s.stu_id,
		        s.stu_name,
		        s.stu_age,
		        s.stu_grade,
		        s.stu_daynight,
		        c.course_id,
		        c.course_name,
		        c.course_instructor,
		        t.status_id,
		        t.COURSE_SCORE
		from  SCOTT.student s, SCOTT.COURSE_STATUS t, scott.course c
		where s.stu_id = t.stu_id
		  and t.course_id = c.course_id
	</select>
	<select id="selectStudentByName" parameterType="String"
		resultMap="studentResultMap">
		<include refid="selectStudent" />
		where stu_name like '%' || #{value} || '%'
	</select>

	<select id="selectStudentByGradeorDay2" parameterType="Student"
		resultMap="studentResultMap">
		<include refid="selectStudent" />
		<where>
			<if test="grade != null">
				stu_grade = #{grade}
			</if>
			<if test="daynight != null">
				and stu_daynight = #{daynight}
			</if>
		</where>
	</select>

	<select id="selectStudentByGradeorDay" parameterType="Map"
		resultMap="studentResultMap">
		<include refid="selectStudent" />
		<where>
			<if test="grade != null">
				stu_grade = #{grade}
			</if>
			<if test="day != null">
				or stu_daynight = #{day}
			</if>
		</where>
	</select>

	<sql id="selectStudent">
		select * from student
	</sql>

	<select id="selectStudentGrade" resultType="integer">
		select count(*) cnt
		from STUDENT
		group by grade
	</select>

	<!-- Student : 등록하려는 입력데이터를 저장하고 있는 StudentVO 객체이다. -->
	<!-- VO객체에 저장되어있는 데이터를 꺼내 써야하므로 getid, getname, getage, getgrade, ...이다. -->
	<!-- dept.deptid는  getDept().getDeptid()를 의미한다.-->
	<insert id="insertStudent" parameterType="Student">
		insert into student
		(stu_id,stu_name,stu_age,stu_grade,stu_daynight,dept_id)
		values(
		#{id}, 
		#{name},
		#{age},
		#{grade},#{daynight},#{dept.deptid} )
	</insert>

	<update id="updateStudent" parameterType="Student">
		update student set
		stu_name = #{name},
		stu_age = #{age},
		stu_grade = #{grade},
		stu_daynight
		= #{daynight},
		dept_id = #{dept.deptid}
		where stu_id = #{id}
	</update>

	<insert id="insertCourseStatus" parameterType="CourseStatus">
		insert into COURSE_STATUS 
		(STATUS_ID,STU_ID,COURSE_ID,COURSE_SCORE)
		values (
		#{statusId},
		#{student.id},
		#{course.courseId},
		#{courseScore})
	</insert>
	
	<!-- <delete id="deleteStudent" parameterType="Integer"> -->
	<!-- delete from student where id = #{value} -->
	<!-- </delete> -->

</mapper>
```



```java
# StudentVO.java

package myspring.user.vo;

import java.util.List;

public class StudentVO {
	private Integer id;
	private String name;
	private Integer age;
	private String grade;
	private String daynight;

	private DeptVO dept; //1:1 관계

	private List<CourseStatusVO> courseStatus; //1:n 관계

	public StudentVO() {

	}

	public StudentVO(Integer id, String name, Integer age, String grade, String daynight, DeptVO dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.daynight = daynight;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDaynight() {
		return daynight;
	}

	public void setDaynight(String daynight) {
		this.daynight = daynight;
	}

	public DeptVO getDept() {
		return dept;
	}

	public void setDept(DeptVO dept) {
		this.dept = dept;
	}

	public List<CourseStatusVO> getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(List<CourseStatusVO> courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", daynight=" + daynight
				+ ", dept=" + dept + ", courseStatus=" + courseStatus + "]";
	}

}
```



```java
# DeptVO.java

package myspring.user.vo;

public class DeptVO {
	private Integer deptid;
	private String deptname;
	
	public DeptVO() {
		
	}

	public DeptVO(Integer deptid) {
		this.deptid = deptid;
	}
	public DeptVO(Integer deptid, String deptname) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", deptname=" + deptname + "]";
	}
}

```



```java
# StudentMapper.java

package myspring.user.dao.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import myspring.user.vo.CourseStatusVO;
import myspring.user.vo.StudentVO;

@MyMapper
public interface StudentMapper {
	@ResultMap("studentResultMap")
	@Select("select * from student where stu_id=#{id}")
	StudentVO selectStudentById(@Param("id") int id);
	List<StudentVO> selectStudentDeptById();
	List<StudentVO> selectStudentCourseStatusById();
	
	int insertStudent(StudentVO studentVO);
	int updateStudent(StudentVO studentVO);
	int insertCourseStatus(CourseStatusVO courseStatusVO);
	
}


```



```java
# MyBatis.java

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
	
	
	@Test
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
	
	@Test @Ignore
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

```



![캡처](https://user-images.githubusercontent.com/42603919/79192184-36888480-7e63-11ea-82bd-c5926abe78de.PNG)