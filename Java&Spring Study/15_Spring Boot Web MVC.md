# Spring Boot Web MVC 

---

#### 참고사항

```
hashCode, equals란??

equals()
	두 객체의 내용이 같은지 확인하는 Method이다.
	equals()를 @Override하면 문제를 해결할 수 있다.
hashCode()
	두 객체가 같은 객체인지 확인하는 Method이다.
	hashCode()를 @Override하면 문제를 해결할 수 있다.
```

```java
# MyDate.java

package jdbc.user.vo;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate() {
		
	}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate myDate = (MyDate)obj;
			if((this.year == myDate.year)&&
			   (this.month == myDate.month)&&
			   (this.day == myDate.day)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return this.year ^ this.month ^ this.day;
	}
	
}
```

```java
# MyDateHashCodeTest.java

package lambda;

import java.util.HashSet;
import java.util.Set;

import jdbc.user.vo.MyDate;

public class MyDateHashCodeTest {

	public static void main(String[] args) {
		
		MyDate date1 = new MyDate(2020,4,24);
		System.out.println(date1);
		MyDate date2 = new MyDate(2020,4,24);
		System.out.println(date2);
		
		MyDate date3 = new MyDate(2020,4,25);
		System.out.println(date3);
		
		//주소 비교
		System.out.println(date1 == date2);
		//값 비교
		//object에 있는 equals가 호출되므로 false이다. MyDate에는 equals 선언 안해놨음.
		//하지만 값을 비교하도록 MyDate에는 equals 선언 해놔서 true가 나옴.
		System.out.println(date1.equals(date2)); 
		
		
		//hashSet - 중복을 허용하지 않음
		Set<MyDate> set = new HashSet<>();
		set.add(date1);
		set.add(date2);
		set.add(date3);
		
		//중복되어도 출력이 된다. hash값이 일치하지 않기 때문이다.
		//hash 값을 비교하도록 MyDate에는 hash 선언 해놔서 중복된 값은 출력되지 않는다.
		set.forEach(date -> System.out.println(date));
		
		
	}

}

결과
MyDate [year=2020, month=4, day=24]
MyDate [year=2020, month=4, day=24]
MyDate [year=2020, month=4, day=25]
false
true
MyDate [year=2020, month=4, day=24]
MyDate [year=2020, month=4, day=25]
```

---

####  Spring Boot Web MVC : RestController (JSON) – Entity와 Repository



![캡처](https://user-images.githubusercontent.com/42603919/80168933-1ef98a80-861f-11ea-808c-64a429dc6866.PNG)



```java
# User.java

package com.dudrnjs.myspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id @GeneratedValue
	private Long id;
	
	@Column 
	private String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Column(unique = true)
	private String email;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
```

<img src="https://user-images.githubusercontent.com/42603919/80166072-fcb03e80-8617-11ea-9980-c098529a48b4.PNG" alt="캡처" style="zoom:80%;" />



![캡처](https://user-images.githubusercontent.com/42603919/80174431-97674800-862d-11ea-8946-0d3d9829f3ae.PNG)



```java
# UserRepository.java

package com.dudrnjs.myspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dudrnjs.myspringboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByName(String name);
	Optional<User> findByEmail(String email);
}
```



---



####  Spring Boot Web MVC : RestController (JSON) – Controller

![캡처](https://user-images.githubusercontent.com/42603919/80174769-a7335c00-862e-11ea-9494-91d1177d6b8b.PNG)



#### post

```java
# UserRestController.java

package com.dudrnjs.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
}
```

<img src="https://user-images.githubusercontent.com/42603919/80175223-f75eee00-862f-11ea-8b9e-230c1c11175e.PNG" alt="1" style="zoom:80%;" />

#### 전체 조회

```java
# UserRestController.java

package com.dudrnjs.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	//전체 조회
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
}
```



#### 로직상에 문제가 발생했을 때 사용

![캡처](https://user-images.githubusercontent.com/42603919/80175425-83711580-8630-11ea-87e4-0836de0f0928.PNG)

```java
# ResourceNotFoundException.java

package com.dudrnjs.myspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)//404 에러
public class ResourceNotFoundException extends RuntimeException{
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}


	public String getResourceName() {
		return resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public Object getFieldValue() {
		return fieldValue;
	}
	
}
```



#### 상세조회

```java
# UserRestController.java

package com.dudrnjs.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	//전체 조회
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	//상세 조회
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
}
```

<img src="https://user-images.githubusercontent.com/42603919/80176326-2b87de00-8633-11ea-8996-3c847534b323.PNG" alt="캡처" style="zoom:80%;" />

<img src="https://user-images.githubusercontent.com/42603919/80176328-2c207480-8633-11ea-89b6-3f799910c0be.PNG" alt="2" style="zoom:80%;" />



#### 수정하기

```java
# UserRestController.java

package com.dudrnjs.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	//전체 조회
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	//상세 조회
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
	
	//수정하기
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		
		User updateUser = repository.save(user);
		return updateUser;
		
		
	}
}
```

<img src="https://user-images.githubusercontent.com/42603919/80178167-938cf300-8638-11ea-967b-7583fad9312d.PNG" alt="캡처" style="zoom:80%;" />



![캡처](https://user-images.githubusercontent.com/42603919/80178262-c1723780-8638-11ea-9190-5c671e550fa8.PNG)



#### 삭제하기

##### 현재 DB상태

<img src="https://user-images.githubusercontent.com/42603919/80178876-3bef8700-863a-11ea-943e-a4196990d7b7.PNG" alt="캡처" style="zoom:80%;" />

```java
# UserRestController.java

package com.dudrnjs.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	//전체 조회
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	//상세 조회
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
	
	//수정하기
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		
		User updateUser = repository.save(user);
		return updateUser;
		
		
	}
	
	//삭제하기
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		repository.delete(user);
		return new ResponseEntity<String>(user.getId() + "delete", HttpStatus.OK);
	}
}
```



<img src="https://user-images.githubusercontent.com/42603919/80180000-b6210b00-863c-11ea-814d-79e60fa6961d.PNG" alt="1" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/80180005-b9b49200-863c-11ea-920e-5c3d0a3999f0.PNG" alt="2" style="zoom:80%;" />

---

#### Spring Boot Web MVC : RestController (XML)

- **ViewResolver** : Controller에서 반환한 값(ModelAndView 혹은 Model)을 통해 뷰를 만드는 역할
- **ContentNegotiatingViewResolver** : 동일한 URI에서 HTTP Request에 있는 Content-type 및 Accept 헤더를 기준으로 다양한 Content-type으로 응답할 수 있게 하는 ViewResolver



##### XML 메시지 컨버터 의존성 추가하기

```xml
# pom.xml

<dependency>
 	<groupId>com.fasterxml.jackson.dataformat</groupId>
 	<artifactId>jackson-dataformat-xml</artifactId>
 	<version>2.9.6</version>
</dependency>
```



```java
# UserRestController.java

//xml
@GetMapping(value = "/usersxml", produces = {"application/xml"})
	public List<User> getUsersXml() {
		return repository.findAll();
	}
```



![캡처](https://user-images.githubusercontent.com/42603919/80183613-1b2c2f00-8644-11ea-8cad-12ca5dbc1a23.PNG)



#### @JacksonXmlProperty

```java
# User.java

package com.dudrnjs.myspringboot.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
public class User{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	@Column 
	@JacksonXmlProperty
	private String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Column(unique = true)
	@JacksonXmlProperty
	private String email;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
```



![캡처](https://user-images.githubusercontent.com/42603919/80183689-39922a80-8644-11ea-8f19-869195e620fb.PNG)



#### Serializable

```java
# User.java

package com.dudrnjs.myspringboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	@Column 
	@JacksonXmlProperty
	private String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Column(unique = true)
	@JacksonXmlProperty
	private String email;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

```



```java
# Users.java

package com.dudrnjs.myspringboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JacksonXmlProperty(localName = "User")
	public List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}

```



```java
# UserRestController.java

package com.dudrnjs.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.entity.Users;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/users", produces = {"application/json"})
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	//전체 조회
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	//상세 조회
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
	
	//수정하기
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		
		User updateUser = repository.save(user);
		return updateUser;
		
		
	}
	
	//삭제하기
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		repository.delete(user);
		return new ResponseEntity<String>(user.getId() + "delete", HttpStatus.OK);
	}
	
//	//xml
//	@GetMapping(value = "/usersxml", produces = {"application/xml"})
//	public List<User> getUsersXml() {
//		return repository.findAll();
//	}
	
	//xml
	@GetMapping(value = "/usersxml", produces = {"application/xml"})
	public Users getUsersXml() {
		Users users = new Users();
		users.setUsers(repository.findAll());
		return users;
	}
}
```



<img src="https://user-images.githubusercontent.com/42603919/80185261-0735fc80-8647-11ea-8fc5-27db7eaa5726.PNG" alt="캡처" style="zoom:80%;" />

#### User Wrapping

```java
# Users.java

package com.dudrnjs.myspringboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JacksonXmlProperty(localName = "User")
	//추가한 부분
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}

```

<img src="https://user-images.githubusercontent.com/42603919/80185386-364c6e00-8647-11ea-9a46-c4762bda7d6d.PNG" alt="캡처" style="zoom:80%;" />



---



####  Spring Boot Web MVC : 정적 리소스 위치



![캡처](https://user-images.githubusercontent.com/42603919/80188870-c17c3280-864c-11ea-9801-8a5635e565a2.PNG)

```html
# hello.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello Mobile Page</h2>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80188820-add0cc00-864c-11ea-9841-3f08a3fd62b1.PNG" alt="캡처" style="zoom:80%;" />



#### -> 오류를 해결해보자

#### Spring Boot Web MVC : 정적 리소스 맵핑 커스터 마이징

- WebMvcConfigurer의 addResourceHandlers 메서드로 커스터마이징 하여 Spring MVC가 제공하는 기본 리소스 설정을 그대로 유지하면서 리소스 맵핑 설정을 추가할 수 있다. 
- addResourceHandlers는 리소스 등록 및 핸들러를 관리하는 객체인 ResourceHandlerRegistry를 통해 리소스 위치와 이 리소스와 매칭될 url을 등록한다. 
- setCachePeriod는 캐시를 얼마나 지속할 지 정하는 메서드이다. 20초로 설정됨.



![캡처](https://user-images.githubusercontent.com/42603919/80189085-14ee8080-864d-11ea-8dca-a93d9e169114.PNG)



```java
# WebConfig.java

package com.dudrnjs.myspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/mobile/**")
				.addResourceLocations("classpath:/mobile/")
				.setCachePeriod(20);
	}
}
```



![캡처](https://user-images.githubusercontent.com/42603919/80189185-3f403e00-864d-11ea-94f9-688287782c4c.PNG)

---



#### Spring Boot Web MVC : Thymeleaf

[Using Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

[Thymeleaf + Spring](https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html)

- Thymeleaf는 스프링 부트가 자동 설정을 지원하는 웹 템플릿 엔진이다. HTML문서에 HTML5 문법으 로 서버쪽 로직을 수행하고 적용시킬 수 있다. 

- HTML 디자인에 전혀 영향을 미치지 않고 웹 템플릿 엔진을 통해 HTML을 생성할 수 있다. 

- Server Side Template Engine, th:xx 형식으로 속성을 html 태그에 추가하여 값을 처리할 수 있다. 

- JSP, Groovy등 다른 템플릿도 스프링 부트에서 사용 가능하지만 thymeleaf가 가장 많이 사용된다. 

- JSP를 권장하지 않는 이유

  - JAR 패키징 할 때는 동작하지 않고, WAR 패키징 해야 함.

  - Undertow(Servlet Engine)는 JSP를 지원하지 않음

- Thymeleaf 템플릿 페이지 위치 : /src/main/resources/templates/



##### Thymeleaf 표현식

- **Variable Expressions - ${ }** : 해당 Context의 포함된 변수들을 사용할 수 있다.
- **Selection Variable Expressions - *{ }** : 가까운 DOM에 th:object로 정의된 변수가 있다면 그 변수에 포함된 값을 나타낼 수 있다.
- **Message Expressions - #{ }** : 미리 정의된 message.properties 파일이 있다면 #표현식으로 나타낼 수 있다.
- **Link URL Expressions - @{ }** : @표현식을 이용하여 다양하게 URL을 표현할 수 있다. 



##### Thymeleaf 의존성 추가

```xml
# pom.xml

<dependency>
 	<groupId>org.springframework.boot</groupId>
 	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```



<img src="https://user-images.githubusercontent.com/42603919/80192718-9563b000-8652-11ea-989a-e5db92d860e6.PNG" alt="캡처" style="zoom:67%;" />

#### [실습1]

```java
# UserController.java

package com.dudrnjs.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@GetMapping("/leaf") 
		public ModelAndView leaf() {
			return new ModelAndView("leaf", "name", "타임리프");
		}
}
```



```html
# index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome 스프링부트!!</h2>
	<a href="leaf">타임리프</a>
</body>
</html>
```



```html
# leaf.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Spring Boot Thymeleaf</title>
</head>
<body>
	<h2 th:text="${name}">Name</h2>
	<h2>Hello, <span th:text="${name}"></span></h2>
	<h2>다른 방법, [[${name}]]</h2>
	<h2>다른 방법, ${name}</h2>
</body>
</html>
```

<img src="https://user-images.githubusercontent.com/42603919/80323854-cfa69a80-8868-11ea-96df-e17f282903ef.PNG" alt="캡처" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80323862-d9300280-8868-11ea-921f-288571b42d86.PNG" alt="캡처" style="zoom:67%;" />



#### [실습2] : User 리스트 Controller와 Page

**static의 index에서 사용자 관리 링크를 클릭하면 UserController에서 userRepository에 있는 데이터를 model에 저장한다. 그 후 UserController에서 model에 저장한 데이터를 templates에 있는 index.html에  출력한다.**

```java
# UserController.java

package com.dudrnjs.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dudrnjs.myspringboot.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
	
	
	@GetMapping("/leaf") 
	public ModelAndView leaf() {
		return new ModelAndView("leaf", "name", "타임리프");
	}
}
```



```html
# index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome 스프링부트!!</h2>
	<a href="leaf">타임리프 페이지 보기</a>
	<h2><a href="index">사용자 관리</a></h2>
</body>
</html>
```



```html
# leaf.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Spring Boot Thymeleaf</title>
</head>
<body>
	<h2 th:text="${name}">Name</h2>
	<h2>Hello, <span th:text="${name}"></span></h2>
	<h2>다른 방법, [[${name}]]</h2>
	<h2>다른 방법, ${name}</h2>
</body>
</html>
```



```html
# index.html(templates)

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사용자 리스트</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<tr th:each="user : ${users}">
			<td th:text="${user.name}"></td>
			<td th:text="${user.email}"></td>
		</tr>
	</table>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80324466-cff46500-886b-11ea-8e79-fa060f105966.PNG" alt="캡처" style="zoom: 67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80324468-d08cfb80-886b-11ea-805f-0eb3b9a3aee1.PNG" alt="캡처1" style="zoom:67%;" />





#### [실습3] User 등록 Controller 와 Page

#### @Value 어노테이션

> @ModelAttribute + Validation check(입력항목 검증)
>
> server에서 입력항목 검증 validation api - javax.validation 사용
>
> @NotBlank

**templates에 있는 index.html에 등록 버튼을 배치한다. 등록 버튼을 누르면 UserController로 이동한다. UserController에서 등록하는 화면을 뿌려준다. 그 페이지(등록하는 화면)는 templates에 있는 add-user.html이다. 그리고 사용자를 등록 처리하면 UserController로 이동한다. UserController에서 등록된 데이터를 templates에 있는 index.html에 출력한다.**

```java
# User.java
# NotBlank 추가
    
package com.dudrnjs.myspringboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	@Column 
	@JacksonXmlProperty
	@NotBlank(message = "Name은 필수 입력항목 입니다.")
	private String name;
	
	@Column(unique = true)
	@JacksonXmlProperty
	@NotBlank(message = "Email은 필수 입력항목 입니다.")
	private String email;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
```



```java
# UserController.java

package com.dudrnjs.myspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "add-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}
	
	@GetMapping("/signup")
	public String showSignupForm(User user) {
		return "add-user";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
	
	
	@GetMapping("/leaf") 
	public ModelAndView leaf() {
		return new ModelAndView("leaf", "name", "타임리프");
	}
}
```



```html
# index.html(templates)

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사용자 리스트</h3>
	<table>
		<tr>
			<th>Name : </th>
			<th>Email : </th>
		</tr>
		<tr th:each="user : ${users}">
			<td th:text="${user.name}"></td>
			<td th:text="${user.email}"></td>
		</tr>		
	</table>
	<hr/>
	
	<a href="/signup">User Insert</a>
</body>
</html>
```



```html
# add-user.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사용자 등록 Form</h3>
	<form action="#" th:action="@{/adduser}" th:object="${user}" method="post">
		<label for="name">Name : </label>
		<input type="text" th:field="*{name}" id="name">
		<span th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></span>
		<br/>
		<label for="name">Email : </label>
		<input type="text" th:field="*{email}" id="email">
		<span th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></span>
		<br/>
		<input type="submit" value="Add-User">
	</form>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80327620-b822de00-8877-11ea-905f-e1be1f2af7a2.PNG" alt="캡처" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80327621-b9540b00-8877-11ea-82ca-118fda041c33.PNG" alt="1" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80327623-ba853800-8877-11ea-861d-6decacb3f332.PNG" alt="2" style="zoom:67%;" />



#### [실습4] User 수정 Controller

**templates에 있는 index.html에 수정 버튼을 배치한다. 수정 버튼을 누르면 UserController로 이동한다. UserController에서 userRepository에 있는 해당 수정할 데이터를 호출한다. Model에 수정할 데이터를 담고 페이지로 이동한다. 그 페이지(수정하는 화면)는 templates에 있는 update-user.html이다. 그리고 사용자를 수정 처리하면 UserController로 이동한다. UserController에서 수정된 데이터를 templates에 있는 index.html에 출력한다.**



```java
# UserController.java

package com.dudrnjs.myspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/edituser/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			user.setId(id);//update-user로 돌아가기 위해서 id를 받아야한다.
			return "update-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView showUpdateForm(@PathVariable long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return new ModelAndView("update-user", "user", user);
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "add-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}

	@GetMapping("/signup")
	public String showSignupForm(User user) {
		return "add-user";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/leaf")
	public ModelAndView leaf() {
		return new ModelAndView("leaf", "name", "타임리프");
	}
}
```



```html
# index.html(templates)

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사용자 리스트</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
		</tr>
		<tr th:each="user : ${users}">
			<td th:text="${user.name}"></td>
			<td th:text="${user.email}"></td>
			<td><a th:href="@{/edit/{id}(id=${user.id})}">Update</a></td>
		</tr>		
	</table>
	<hr/>
	
	<a href="/signup">User Insert</a>
</body>
</html>
```



```html
# update-user.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사용자 수정 Form</h3>
	<form action="#" th:action="@{/edituser/{id}(id=${user.id})}" th:object="${user}" method="post">
		<label for="name">Name : </label>
		<input type="text" th:field="*{name}" id="name">
		<span th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></span>
		<br/>
		<label for="name">Email : </label>
		<input type="text" th:field="*{email}" id="email">
		<span th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></span>
		<br/>
		<input type="submit" value="Update-User">
	</form>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80335106-46a25a00-888e-11ea-8bab-d8a4f101fe85.PNG" alt="캡처" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80335107-47d38700-888e-11ea-94ca-4e5e63951874.PNG" alt="1" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80335108-486c1d80-888e-11ea-9c0d-c86a1a9bf18d.PNG" alt="2" style="zoom:67%;" />



#### [실습5] User 삭제 Controller

**templates에 있는 index.html에 삭제 버튼을 배치한다. 삭제 버튼을 누르면 UserController로 이동한다. 그리고 사용자를 삭제 처리하면 UserController로 이동한다. UserController에서 삭제된 데이터를 templates에 있는 index.html에 출력한다.**



```java
# UserController.java

package com.dudrnjs.myspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.delete(user);
		return "redirect:/index";
	}
	
	
	@PostMapping("/edituser/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			user.setId(id);//update-user로 돌아가기 위해서 id를 받아야한다.
			return "update-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView showUpdateForm(@PathVariable long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return new ModelAndView("update-user", "user", user);
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "add-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}

	@GetMapping("/signup")
	public String showSignupForm(User user) {
		return "add-user";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/leaf")
	public ModelAndView leaf() {
		return new ModelAndView("leaf", "name", "타임리프");
	}
}
```



```java
# index.html(templates)

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사용자 리스트</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<tr th:each="user : ${users}">
			<td th:text="${user.name}"></td>
			<td th:text="${user.email}"></td>
			<td><a th:href="@{/edit/{id}(id=${user.id})}">Update</a></td>
			<td><a th:href="@{/delete/{id}(id=${user.id})}">Delete</a></td>
		</tr>		
	</table>
	<hr/>
	
	<a href="/signup">User Insert</a>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80335981-d6e19e80-8890-11ea-9a60-365ab86269e8.PNG" alt="캡처" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80335985-d812cb80-8890-11ea-9a2f-17049ae5a496.PNG" alt="1" style="zoom:67%;" />



---



#### Spring Boot Web MVC : 예외처리

- 스프링 부트에서는 **ExceptionHandler**를 기본적으로 등록하여 Exception을 처리하고 있다.  
- 기본 예외 처리기는 스프링에서 자동적으로 등록하는 BasicErrorController에서 관리한다. ( 에러 발생 시 JSON 형식으로 리턴 )  
- 커스텀 Exception 핸들러, 커스텀 Exception 클래스를 만들어서 예외를 처리할 수 있다.
- 스프링 @MVC 예외 처리 방법 
  - @ExceptionHandler : 스프링은 컨트롤러 안에 @ExceptionHandler를 선언한 메서드가 존재하면 그 메서드가 컨트롤러 내부의 예외를 처리하도록 해준다. 
  - @ControllerAdvice : @ControllerAdvice 어노테이션을 통해서 이 클래스의 객체가 컨트롤러에서 발생하는 Exception을 전문적으로 처리하는 클래스라는 것을 명시한다.
  - BasicErrorController는 스프링 부트가 제공하는 기본 예외 처리기 역할을 담당한다. 
    - org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController : HTML과 JSON 응답 지원



<img src="https://user-images.githubusercontent.com/42603919/80342680-84f44500-889f-11ea-8276-f3533773f999.PNG" alt="캡처" style="zoom:80%;" />





![캡처](https://user-images.githubusercontent.com/42603919/80343231-76f2f400-88a0-11ea-8c80-2f256d31c99a.PNG)



```java
# UserController.java

@ExceptionHandler(Exception.class)
public ModelAndView handleException(Exception ex) {
	return new ModelAndView("error/generic_error", "errMsg", ex.getMessage());		
}
```



```html
# generic_error.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Error page</h2>
	
	<div>
		<h4 th:text="${errMsg}"></h4>
	</div>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80343539-0ac4c000-88a1-11ea-9fa1-17f82eab61a7.PNG" alt="캡처" style="zoom:80%;" />



<img src="https://user-images.githubusercontent.com/42603919/80344678-ef5ab480-88a2-11ea-9b19-97d801cf5b8a.PNG" alt="캡처" style="zoom:80%;" />

---



![캡처](https://user-images.githubusercontent.com/42603919/80345755-925ffe00-88a4-11ea-8197-5bd1c578b714.PNG)



```java
# UserController.java

@ExceptionHandler(Exception.class)
public ModelAndView handleException(Exception ex) {
	return new ModelAndView("error/generic_error", "errMsg", ex.getMessage());
		
}
	
@ExceptionHandler(CustomException.class)
public ModelAndView handleCustomException(CustomException ex) {
	ModelAndView model = new ModelAndView("error/generic_error");
	model.addObject("errCode", ex.getErrCode());
	model.addObject("errMsg",ex.getErrMsg());
	return model;
}
	
@GetMapping("/delete/{id}")
public String deleteUser(@PathVariable("id") long id) {
//	User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	User user = userRepository.findById(id).orElseThrow(() -> new CustomException("E001", String.format("해당 User ID : %s 가 존재하지 않습니다.", id)));
	userRepository.delete(user);
	return "redirect:/index";
}
```



```html
# generic_error.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Error page</h2>
	
	<div th:if="!${#strings.isEmpty(errCode)}">
		<h5>Logic Error : <span th:text="${errCode}"></span></h5>
	</div>
	<div th:if="${#strings.isEmpty(errCode)}">
		<h5>System Errors : </h5>
	</div>
	<div>
		<span th:text="${errMsg}"></span>
	</div>
</body>
</html>
```



```java
# CustomException.java

package com.dudrnjs.myspringboot.exception;

public class CustomException extends RuntimeException{
	
	private String errCode;
	private String errMsg;
	

	public CustomException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

}
```

<img src="https://user-images.githubusercontent.com/42603919/80347410-3c408a00-88a7-11ea-90a6-344eb65e91fc.PNG" alt="캡처" style="zoom:80%;" />



---



#### 404 Error 웹 페이지

![캡처](https://user-images.githubusercontent.com/42603919/80347922-f637f600-88a7-11ea-9ef9-0170ad52a5f9.PNG)

```html
# 404.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>404 Error</h1>
	<h2>요청하신 웹 페이지가 존재하지 않습니다. 관리자에게 문의하세요!!</h2>
</body>
</html>
```

<img src="https://user-images.githubusercontent.com/42603919/80347795-c557c100-88a7-11ea-96e4-d665dd203f7f.PNG" alt="캡처" style="zoom:80%;" />



---



####  Spring Boot Web MVC : CORS

- 보통 보안 상의 이슈 때문에 동일 출처(Single Origin Policy)를 기본적으로 웹에서는 준수하게 된다.
- SOP(Single Origin Policy) 
  - 같은 Origin에만 요청을 보낼 수 있다.
  - CORS(Cross-Origin Resource Sharing) : Single Origin Policy를 우회하기 위한 기법
  - 서로 다른 Origin 간에 resource를 share 하기 위한 방법
- Origin 이란? 
  - URI 스키마 (http, https) + hostname (localhost) + 포트 (8080, 18080)
- @CrossOrigin 어노테이션
  - @Controller나 @RequestMapping 어노테이션과 같이 사용할 수 있다.
  - @CrossOrigin(origins="http://localhost:18080")



```
# application.properties

server.port=3000
```



```xml
# pom.xml

<dependency>
	<groupId>org.webjars.bower</groupId>
	<artifactId>jquery</artifactId>
	<version>3.3.1</version>
</dependency>
```



```html
# index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JQuery를 사용한 Client</h1>
	<script src="/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
	<script>
		$(function() {
			$.ajax("http://localhost:8085/users")
			.done(function(msg){
				//alert(msg);
				console.log(msg);
			})
			.fail(function(err){
				//alert(err);
				console.log(err);
			});
		});
	</script>
</body>
</html>
```



```java
# UserRestController.java

package com.dudrnjs.myspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.entity.Users;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserRestController {
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/users", produces = {"application/json"})
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	//전체 조회
	@GetMapping("/users")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	//상세 조회
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return user;
	}
	
	//수정하기
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		
		User updateUser = repository.save(user);
		return updateUser;
		
		
	}
	
	//삭제하기
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		repository.delete(user);
		return new ResponseEntity<String>(user.getId() + "delete", HttpStatus.OK);
	}
	
//	//xml
//	@GetMapping(value = "/usersxml", produces = {"application/xml"})
//	public List<User> getUsersXml() {
//		return repository.findAll();
//	}
	
	//xml
	@GetMapping(value = "/usersxml", produces = {"application/xml"})
	public Users getUsersXml() {
		Users users = new Users();
		users.setUsers(repository.findAll());
		return users;
	}
}
```

![캡처](https://user-images.githubusercontent.com/42603919/80436340-e49f2e80-8939-11ea-8ef7-ab148b0b0010.PNG)

**localhost:8085에서 보이던 정보를 localhost:3000에서도 보일 수 있도록 하였다.**



---



#### Spring Boot Actuator

- 애플리케이션의 각종 정보를 확인할 수 있는 Endpoints
  - 다양한 Endpoints 제공.
  - JMX 또는 HTTP를 통해 접근 가능 함.
  - shutdown을 제외한 모든 Endpoint는 기본적으로 활성화 상태



#####  스프링 부트 Actuator 의존성 추가

```xml
# pom.xml

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```



-  HTTP 사용하기

  - http://localhost:포트번호/actuator

  - health와 info를 제외한 대부분의 Endpoint가 기본적으로 비공개 상태이다.

  - 공개 옵션 조정

    - ```
      # application.properties
      
      management.endpoints.web.exposure.include=*
      management.endpoints.web.exposure.exclude=env,beans
      ```

      

#### Spring-Boot Admin

> 스프링 부트 Actuator UI 를 제공한다.

- 새로운 스프링 부트 프로젝트를 생성한다. (SecondBootProject)
- Web Dependency를 추가한다.
- server.port=8090 으로 설정한다.
- **@EnableAdminServer** 어노테이션 선언
- spring-boot-admin-starter-server dependency 추가한다

##### Spring-Boot Admin 의존성 추가

```xml
# pom.xml (SecondBootProject)

<dependency>
  <groupId>de.codecentric</groupId>
  <artifactId>spring-boot-admin-starter-server</artifactId>
  <version>2.1.4</version>
</dependency>
```

##### 포트번호 설정

```
# application.properties (SecondBootProject)

server.port=8090
```



- 기존에 작성했던 프로젝트(myspringboot)에 admin-client dependency를 추가한다. 

  - ```
    # application.properties (myspringboot)
    
    spring.boot.admin.client.url=http://localhost:8090
    ```

![캡처](https://user-images.githubusercontent.com/42603919/80438591-7f4e3c00-893f-11ea-9ca2-e9e9f18b98a7.PNG)

---

#### 참고

##### @GeneratedValue(strategy = GenerationType.IDENTITY)

- Auto(default) : JPA 구현체가 자동으로 생성 전략을 결정한다.
- IDENTITY : 기본키 생성을 DB에 위임한다. 예를 들어 MySql의 경우 AUTO_INCREMENT를 사용해서 기본키를 생성한다.
- SEQUENCE : DB의 특별한 Sequence 오브젝트를 사용해서 기본키를 생성한다.
- TABLE : Key를 생성하는 생성 전용 테이블을 하나 만들고 이를 사용해서 기본키를 생성한다.

---



#### Spring Security

[spring-security-docs-manual 5.3.1.RELEASE API](https://docs.spring.io/spring-security/site/docs/current/api/)

- 웹 시큐리티, 메서드 시큐리티
- 다양한 인증 방법 지원
  - Basic 인증, Form 인증, OAuth, LDAP 

- 스프링 부트 시큐리티 자동 설정
  - SecurityAutoConfiguration
  - UserDetailsServiceAutoConfiguration
  - 모든 요청에 인증이 필요함.
  - 기본 사용자를 자동으로 생성해준다. 
    - Username : user 
    - Password : 애플리케이션을 실행할 때 마다 랜덤 값 생성 (콘솔에 출력됨)



##### Spring boot security 의존성 추가

```xml
# pom.xml

<dependency>
 	<groupId>org.springframework.boot</groupId>
 	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```



**JSESSIONID**의 값이 있는지 없는지에 따라 로그인 처리를 한다. 

**JSESSIONID**이 있으면 계속 로그인을 유지한다.

![캡처](https://user-images.githubusercontent.com/42603919/80552876-f7316a80-8a02-11ea-92f1-42882ea59400.PNG)





####  Spring Security : Basic 인증 구현

- TemplateController 클래스에 메서드 추가

- static/index.html에 링크 추가
- templates/mypage.html 작성



```html
# index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome 스프링부트!!</h2>
	<a href="leaf">타임리프 페이지 보기</a>
	<h4><a href="index">사용자 관리</a></h4>
	<h4><a href="/mypage">MyPage</a></h4>	
</body>
</html>
```



```java
# UserController.java

@GetMapping("/mypage")
public String mypage() {
	return "mypage";
}
```



```html
# mypage.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>마이 페이지</h2>
	<div>
		로그인한 UserName : [[${#httpServletRequest.remoteUser}]] <br/>
		<form th:action="@{/app-logout}" method="post">
			<input type="submit" value="로그아웃"/>
		</form>
	</div>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80553683-b7b84d80-8a05-11ea-85c5-35f09153b970.PNG" alt="캡처" style="zoom:67%;" />



<img src="https://user-images.githubusercontent.com/42603919/80553696-c1da4c00-8a05-11ea-9ab9-4131a2725a2b.PNG" alt="캡처" style="zoom:67%;" />



####  Spring Security : Security 설정 커스터 마이징

/mypage/** 에는 인증을 걸겠다. -> MyPage를 클릭할 때만 로그인 창이 뜬다.

```java
# SecurityConfig.java

package com.dudrnjs.myspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //접근을 제한하겠다.
			.antMatchers("/mypage/**").authenticated() // /mypage/**는 인증을 걸겠다.
			.antMatchers("/**").permitAll() //나머지 페이지는 인증을 걸지 않겠다.
			.and()
			.formLogin()
			.and()
			.httpBasic()
		    .and()
		    .logout()
		    .logoutUrl("/app-logout")
		    .deleteCookies("JSESSIONID")
		    .logoutSuccessUrl("/");
	}

}
```



1. MyPage 클릭

   <img src="https://user-images.githubusercontent.com/42603919/80553683-b7b84d80-8a05-11ea-85c5-35f09153b970.PNG" alt="캡처" style="zoom:67%;" />

2. 로그인 하기

   <img src="https://user-images.githubusercontent.com/42603919/80554544-7e351180-8a08-11ea-9eea-0098974f5dc0.PNG" alt="캡처" style="zoom:67%;" />

3. 로그인 완료

<img src="https://user-images.githubusercontent.com/42603919/80554546-7ecda800-8a08-11ea-8b3c-12ccdca39b83.PNG" alt="1" style="zoom:67%;" />

4. 로그아웃을 하면 쿠키가 사라져 다시 MyPage 클릭할 때 다시 로그인을 해야한다.



#### User를 생성하는 Account 추가

##### AccountService 클래스 작성

![캡처](https://user-images.githubusercontent.com/42603919/80555572-99ede700-8a0b-11ea-83f4-0ff61cd96ba0.PNG)

```java
# AccountService.java

package com.dudrnjs.myspringboot.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		return accountRepository.save(account);
	}
	
	// AccountService 클래스가 Bean으로 생성된 후에 바로 init() 메서드가 호출된다.
	@PostConstruct
	public void init() {
		Optional<Account> findByUsername = accountRepository.findByUsername("test");
		// 해당 user가 없으면
		if(!findByUsername.isPresent()) {
			Account createAccount = this.createAccount("test", "1234");
			System.out.println(createAccount);
		}
	}
}
```



```mysql
MariaDB [(none)]> use spring_db;
Database changed
MariaDB [spring_db]> select * from account;
Empty set (0.000 sec)

MariaDB [spring_db]> select * from account;
+----+-------+----------+----------+
| id | email | password | username |
+----+-------+----------+----------+
|  1 | NULL  | 1234     | test     |
+----+-------+----------+----------+
1 row in set (0.000 sec)
```



#### 아이디 : test, 비밀번호 : 1234 로그인 해보기

```java
# AccountService.java

package com.dudrnjs.myspringboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> findByUsername = accountRepository.findByUsername(username);
		Account account = findByUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		return new User(account.getUsername(), account.getPassword(), authorities());
	}
	
	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		return accountRepository.save(account);
	}
	
	// AccountService 클래스가 Bean으로 생성된 후에 바로 init() 메서드가 호출된다.
	@PostConstruct
	public void init() {
		Optional<Account> findByUsername = accountRepository.findByUsername("test");
		// 해당 user가 없으면
		if(!findByUsername.isPresent()) {
			Account createAccount = this.createAccount("test", "1234");
			System.out.println(createAccount);
		}
	}
}

```

<img src="https://user-images.githubusercontent.com/42603919/80561075-391bda00-8a1e-11ea-82e7-02502b2d3774.PNG" alt="캡처" style="zoom:67%;" />



<img src="https://user-images.githubusercontent.com/42603919/80561076-3a4d0700-8a1e-11ea-96d6-c03d74fcb182.PNG" alt="1" style="zoom:67%;" />

- Account에 등록된 username와 password로 로그인 한다.
- **Password를 인코딩 하지 않아서 IllegalArgumentException 발생함**

- **-->>시스템 에러가 발생한다. 이를 해결해보자!!**



####  SecurityConfig 클래스에 PasswordEncoder를 Bean으로 등록

```java
# SecurityConfig.java

package com.dudrnjs.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //접근을 제한하겠다.
			.antMatchers("/mypage/**").authenticated() // /mypage/**는 인증을 걸겠다.
			.antMatchers("/**").permitAll() //나머지 페이지는 인증을 걸지 않겠다.
			.and()
			.formLogin()
			.and()
			.httpBasic()
		    .and()
		    .logout()
		    .logoutUrl("/app-logout")
		    .deleteCookies("JSESSIONID")
		    .logoutSuccessUrl("/");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
```



```java
# AccountService.java

package com.dudrnjs.myspringboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> findByUsername = accountRepository.findByUsername(username);
		Account account = findByUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		return new User(account.getUsername(), account.getPassword(), authorities());
	}
	
	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		//account.setPassword(password);
		account.setPassword(passwordEncoder.encode(password));
		return accountRepository.save(account);
	}
	
	// AccountService 클래스가 Bean으로 생성된 후에 바로 init() 메서드가 호출된다.
	@PostConstruct
	public void init() {
		Optional<Account> findByUsername = accountRepository.findByUsername("test");
		// 해당 user가 없으면
		if(!findByUsername.isPresent()) {
			Account createAccount = this.createAccount("test", "1234");
			System.out.println(createAccount);
		}
	}
}
```



```mysql
MariaDB [spring_db]> select * from account;
+----+-------+----------+----------+
| id | email | password | username |
+----+-------+----------+----------+
|  1 | NULL  | 1234     | test     |
+----+-------+----------+----------+

MariaDB [spring_db]> delete from account;
Query OK, 1 row affected (0.007 sec)

MariaDB [spring_db]> commit;
Query OK, 0 rows affected (0.000 sec)

MariaDB [spring_db]> select * from account;
Empty set (0.001 sec)
```

![캡처](https://user-images.githubusercontent.com/42603919/80561677-30c49e80-8a20-11ea-8f81-7545ae634c30.PNG)

**비밀번호가 1234였던 것이 바뀌어 저장된다. 패스워드가 노출되면 안되기 때문에**



#### 아이디와 비밀번호를 새로 등록해서 로그인해보기

```html
# index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome 스프링부트!!</h2>
	<a href="leaf">타임리프 페이지 보기</a>
	<h4><a href="index">사용자 관리</a></h4>
	<h4><a href="/mypage">MyPage</a></h4>
	<h4><a href="/accountForm">Account 추가</a></h4>	
</body>
</html>
```



```java
# AccountService.java

package com.dudrnjs.myspringboot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> findByUsername = accountRepository.findByUsername(username);
		Account account = findByUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		return new User(account.getUsername(), account.getPassword(), authorities());
	}
	
	private Collection<? extends GrantedAuthority> authorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public Account createAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		//account.setPassword(password);
		account.setPassword(passwordEncoder.encode(password));
		return accountRepository.save(account);
	}
		
}
```



```java
# UserController.java

package com.dudrnjs.myspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dudrnjs.myspringboot.entity.Account;
import com.dudrnjs.myspringboot.entity.User;
import com.dudrnjs.myspringboot.exception.CustomException;
import com.dudrnjs.myspringboot.exception.ResourceNotFoundException;
import com.dudrnjs.myspringboot.repository.UserRepository;
import com.dudrnjs.myspringboot.service.AccountService;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/accountForm")
	public String accountForm(Account account) {
		return "add-account";
	}
	
	@PostMapping("/addAccount")
	public String addAccount(@ModelAttribute Account account) {
		Account addAccount = accountService.createAccount(account.getUsername(), account.getPassword());
		System.out.println(">>>>>.등록된 Account : " + addAccount);
		return "redirect:/index.html";
	}
	
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView("error/generic_error", "errMsg", ex.getMessage());
		
	}
	
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg",ex.getErrMsg());
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
//		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		User user = userRepository.findById(id).orElseThrow(() -> new CustomException("E001", String.format("해당 User ID : %s 가 존재하지 않습니다.", id)));
		userRepository.delete(user);
		return "redirect:/index";
	}
	
	
	@PostMapping("/edituser/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			user.setId(id);//update-user로 돌아가기 위해서 id를 받아야한다.
			return "update-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView showUpdateForm(@PathVariable long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return new ModelAndView("update-user", "user", user);
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "add-user";
		}
		userRepository.save(user);
		return "redirect:/index";
	}

	@GetMapping("/signup")
	public String showSignupForm(User user) {
		return "add-user";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/leaf")
	public ModelAndView leaf() {
		return new ModelAndView("leaf", "name", "타임리프");
	}
}
```



```html
# add-account.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Account 등록</h2>
	<form th:action="@{/addAccount}" method="post" th:object="${account}">
		<label>UserName : </label>
		<input type="text" th:field="*{username}"> <br/>
		<label>Password : </label>
		<input type="password" th:field="*{password}"> <br/>
		<input type="submit" value="Add Account">
	</form>
</body>
</html>
```



<img src="https://user-images.githubusercontent.com/42603919/80578571-a0985080-8a43-11ea-9b8b-bc441a053c40.PNG" alt="캡처" style="zoom: 67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80578572-a130e700-8a43-11ea-9bfb-9f2366b2c4cf.PNG" alt="1" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80578573-a1c97d80-8a43-11ea-917d-44f77bc2fe02.PNG" alt="2" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/80578578-a1c97d80-8a43-11ea-8088-a47197ee8920.PNG" alt="3" style="zoom:67%;" />