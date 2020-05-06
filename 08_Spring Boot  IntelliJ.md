# Spring Boot : IntelliJ

#### Project 생성

**File -> New -> Project**

![캡처](https://user-images.githubusercontent.com/42603919/81131640-c616e400-8f86-11ea-820f-26a73f36a962.PNG)

**Next 클릭 - > 기본적으로 선택할 것을 선택한다. -> Project 생성**



---



#### Profile을 나눠서 사용하기



```yaml
# application.yml

server:
  port: 8888
```



```yaml
# application-local.yml

server:
  port: 9999
spring:
  messages:
    basename: messages
```



![캡처](https://user-images.githubusercontent.com/42603919/81131851-8bfa1200-8f87-11ea-9a63-486956309cac.PNG)

##### Edit Configuration 클릭



![캡처](https://user-images.githubusercontent.com/42603919/81131792-4c332a80-8f87-11ea-80c0-ca3f92ab76f1.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/81131806-5ce3a080-8f87-11ea-8c4b-98f43ca1163a.PNG)



---



#### jar 파일 생성 (package 더블클릭)

![캡처](https://user-images.githubusercontent.com/42603919/81132045-0aef4a80-8f88-11ea-8532-428b6433a493.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/81132083-28bcaf80-8f88-11ea-98dc-b68188397068.PNG)



##### Terminal 창에서 jar 파일 실행해보기

```
C:\Users\HPE\IdeaProjects\demo\target>java -jar demo-0.0.1-SNAPSHOT.jar
```



```
C:\Users\HPE\IdeaProjects\demo\target>java -jar -Dspring.profiles.active=local demo-0.0.1-SNAPSHOT.jar
```



---



#### Git과 연동하기

Project클릭 -> VCS -> Enable Version ~

![캡처](https://user-images.githubusercontent.com/42603919/81132472-7b4a9b80-8f89-11ea-8c3a-4c9ce71d1d1d.PNG)



##### Project 우측버튼 -> Git add -> 업로드할 파일 설정(.ignore는 포함)

##### url 설정

![캡처](https://user-images.githubusercontent.com/42603919/81132592-f4e28980-8f89-11ea-9ef6-25c80f70ad81.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/81132596-fad86a80-8f89-11ea-871d-7a34aa176142.PNG)

---



#### RESTful Service

##### 다국어 제공

> locale은 사용자의 언어, 국가뿐 아니라 사용자 인터페이스에서 사용자가 선호하는 사항을 지정한 매개 변수의 모임이다.



![image](https://user-images.githubusercontent.com/42603919/81141272-1605a300-8fa7-11ea-8562-19bd1cf96a54.png)

```java
# HelloWorldController.java

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return "Good Morning";
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
```



```java
# DemoApplication.java

package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }
}
```



```
각각의 properties에 메세지를 입력한다.

messages.properties : greeting.message=Good afternoon
messages_fr.properties : greeting.message=Bonjour
messages_jp.properties : greeting.message=こんにちは
messages_ko.properties : greeting.message=안녕하세요
```





<img src="https://user-images.githubusercontent.com/42603919/81141162-c030fb00-8fa6-11ea-9f85-111accd27833.png" alt="image" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/81141214-e9518b80-8fa6-11ea-8c3b-682b60447f93.png" alt="image" style="zoom:67%;" />

<img src="https://user-images.githubusercontent.com/42603919/81141233-f7071100-8fa6-11ea-8f25-0b6d13cdfcb4.png" alt="image" style="zoom:67%;" />



---



#### TDD(Test-Driven Development)

>  ***TDD 는 테스트 코드 작성 -> 구현 코드 작성 -> 리팩토링 단계를 짧은 주기로 반복하여 개발하는 ‘테스트 주도 개발 방법론’***

1. TDD 는 소프트웨어 개발 방법론 중의 하나이다.
2. TDD 는 Test-Driven Development, 즉 테스트 주도 개발 방법론이다.
3. 테스트 주도 개발은 테스트 코드를 먼저 작성함으로써 테스트 코드가 개발을 주도한다.
4. 테스트 코드가 개발을 주도하기 위해서는 반드시 실패를 포함하는 테스트코드의 작성이 앞서야 한다.
5. 앞서 작성된 테스트 코드를 통과할 수 있는 ‘최소한의 구현 코드’를 작성한다.
6. 최소한의 구현 코드는 개선될 수 있는 많은 여지를 포함하고 있는 코드다. 단지 테스트만 패스하면 된다.
7. 최소한의 구현 코드를 리팩토링 단계에서 개선한다.
8. 테스트 코드 작성, 최소한의 구현 코드 작성, 구현 코드에 대한 리팩토링 순으로 짧은 주기를 반복하며 점증적으로 개발한다.

##### TDD -> Fail

1. Test code
2. Compile
3. Error 해결
4. Test
5. 반복



---



##### lombok

![캡처](https://user-images.githubusercontent.com/42603919/81144338-c75c0700-8fae-11ea-8566-426a68325fcc.PNG)



- **@Data** : setter와 getter 그리고 toString(), equals()를 해결해준다.
- **@AllArgsConstructor** : Constructor 생성자를 해결
- **@NoArgsConstructor** : default 생성자를 해결



```java
# User.java

package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // setter와 getter를 해결해준다. toString, equals 다 해결
@AllArgsConstructor // Constructor 생성자를 해결
@NoArgsConstructor //default 생성자
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
    private String password;
    private String ssn;
}
```



```java
# UserDaoService.java

package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> list = new ArrayList<>();

    private static int userCount = 3;

    static{

        list.add(new User(1,"Kenneth", new Date(),"test1","701010-1111111"));
        list.add(new User(2,"Alice", new Date(),"test2","801111-2222222"));
        list.add(new User(3,"Elena", new Date(),"test3","901313-1111111"));

//        users.add(new User(1,"Kenneth", new Date(),"test1","701010-1111111"));
//        users.add(new User(2,"Alice", new Date(),"test2","801111-2222222"));
//        users.add(new User(3,"Elena", new Date(),"test3","901313-1111111"));
    }

    public static List<User> getUserList() {
        return list;
    }
}
```



```java
# TestUserDaoService.java

package com.example.demo.dao;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestUserDaoService {

    UserDaoService service = new UserDaoService();

    @Test
    public void test_사용자목록조회() {
        List<User> list = service.getUserList();
//        Assertions.assertTrue(list.size() == 3, "초기 사용자는 3명이어야합니다.");
        Assertions.assertEquals(3, list.size(), "초기 사용자는 3명이어야합니다.");
//        Assertions.assertNotEquals(2, list.size(), "초기 사용자는 3명이어야합니다.");

    }

    @Test
    public void test_사용자정보확인() {
        User user = service.getUserList().get(0);
        Assertions.assertTrue(user.getId() == 1);
    }
}
```



---



#### @JsonIgnore

> 데이터는 저장하되 안보이게 처리

```java
# User.java

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // setter와 getter를 해결해준다. toString, equals 다 해결
@AllArgsConstructor // Constructor 생성자를 해결
@NoArgsConstructor //default 생성자
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
    
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String ssn;
}
```



<img src="https://user-images.githubusercontent.com/42603919/81148346-14dc7200-8fb7-11ea-9538-162d048dc465.PNG" alt="캡처" style="zoom:80%;" />



**-> password와 ssn이 안보이게 처리하였다.**



#### @JsonIgnoreProperties

> @JsonIgnore는 따로 설정했다면, @JsonIgnoreProperties를 선언하여 한번에 처리할 수 있도록 설정

```java
# User.java

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // setter와 getter를 해결해준다. toString, equals 다 해결
@AllArgsConstructor // Constructor 생성자를 해결
@NoArgsConstructor //default 생성자

@JsonIgnoreProperties(value = {"password","ssn"})
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
    private String password;
    private String ssn;
}
```



##### @JsonIgnore에서 처리한 것과 동일한 결과를 얻을 수 있다.

<img src="https://user-images.githubusercontent.com/42603919/81148346-14dc7200-8fb7-11ea-9538-162d048dc465.PNG" alt="캡처" style="zoom:80%;" />



---



#### 사용자 개별 목록 요청

```java
# UserController.java

package com.example.demo.controller;

import com.example.demo.dao.UserDaoService;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> getUserList() {
        List<User> list = service.getUserList();

        //list의 내용 출력
//        for (User user : list) {
//            System.out.println(user);
//            log.info(user.toString());
//        }
        return list;
    }

    // 사용자 개별목록 요청
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = service.getUser(id);
        return user;
    }

    // 관리자 입장에서 개별 목록 요청
//    @GetMapping("/admin/users/{id}")
//    public User getUserByAdmin() {
//
//    }
}
```



```java
# UserDaoService.java

package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> list = new ArrayList<>();

    private static int userCount = 3;

    static{

        list.add(new User(1,"Kenneth", new Date(),"test1","701010-1111111"));
        list.add(new User(2,"Alice", new Date(),"test2","801111-2222222"));
        list.add(new User(3,"Elena", new Date(),"test3","901313-1111111"));

//        users.add(new User(1,"Kenneth", new Date(),"test1","701010-1111111"));
//        users.add(new User(2,"Alice", new Date(),"test2","801111-2222222"));
//        users.add(new User(3,"Elena", new Date(),"test3","901313-1111111"));
    }

    public static List<User> getUserList() {
        return list;
    }

    public User getUser(Integer id) {
        for (User user : list) {
            if(id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }
}
```



```java
# TestUserDaoService.java

package com.example.demo.dao;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*; //Assertions.이라고 선언하지 않고 사용할 수 있다.

public class TestUserDaoService {

    UserDaoService service = new UserDaoService();

    @Test
    //전체 조회
    public void test_사용자목록조회() {
        List<User> list = service.getUserList();
//        Assertions.assertTrue(list.size() == 3, "초기 사용자는 3명이어야합니다.");
        Assertions.assertEquals(3, list.size(), "초기 사용자는 3명이어야합니다.");
//        Assertions.assertNotEquals(2, list.size(), "초기 사용자는 3명이어야합니다.");

    }

    @Test
    public void test_사용자정보확인() {
        User user = service.getUserList().get(0);
        Assertions.assertTrue(user.getId() == 1);
    }

    @Test
    public void test_사용자상세조회() {
        User user = service.getUser(Integer.valueOf(1));
        assertNotNull(user);
        assertEquals(1, user.getId(), "사용자 id가 잘못되었습니다.");
    }
}
```

![캡처](https://user-images.githubusercontent.com/42603919/81150695-36d7f380-8fbb-11ea-8668-198749fd6af9.PNG)



##### exception 처리 -> UserNotFoundException 반환

```java
# UserNotFoundException.java

package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
       super(message);
    }
}
```



```java
# UserController.java

package com.example.demo.controller;

import com.example.demo.dao.UserDaoService;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> getUserList() {
        List<User> list = service.getUserList();
        return list;
    }

    // 사용자 개별목록 요청
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = service.getUser(id);
        //예외처리
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }
}
```



![캡처](https://user-images.githubusercontent.com/42603919/81153403-dbf3cb80-8fbd-11ea-88a6-dcad6610c200.PNG)



##### @ResponseStatus(HttpStatus.NOT_FOUND) : 404 error

```java
# UserNotFoundException.java

package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
       super(message);
    }
}
```

![캡처](https://user-images.githubusercontent.com/42603919/81154253-b2876f80-8fbe-11ea-9426-3e939424d859.PNG)



#### 필터를 제어 (Filter)

> URL에 따라서 원하는 정보를 추출해서 설정

```java
# UserController.java

    // 사용자 개별목록 요청
    @GetMapping("/user/{id}")
    public MappingJacksonValue getUser(@PathVariable Integer id) {
        User user = service.getUser(id);
        //예외처리
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(provider);

        return mapping;
    }

    // 관리자 입장에서 개별 목록 요청
    @GetMapping("/admin/users/{id}")
    public MappingJacksonValue getUserByAdmin(@PathVariable Integer id) {
        User user = service.getUser(id);

        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(provider);

        return mapping;
    }
```



```java
# User.java

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // setter와 getter를 해결해준다. toString, equals 다 해결
@AllArgsConstructor // Constructor 생성자를 해결
@NoArgsConstructor //default 생성자
//@JsonIgnoreProperties(value = {"password","ssn"})

@JsonFilter("UserInfo") //Filter
public class User {
    private Integer id;
    private String name;
    private Date joinDate;

    //@JsonIgnore
    private String password;
    //@JsonIgnore
    private String ssn;
}
```



![image](https://user-images.githubusercontent.com/42603919/81157235-b9fc4800-8fc1-11ea-87dc-892befdddb4c.png)



![image](https://user-images.githubusercontent.com/42603919/81157071-92a57b00-8fc1-11ea-8eb5-400dfb9d3ca7.png)