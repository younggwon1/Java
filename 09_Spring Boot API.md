# Spring Boot API



#### LEVEL 0. POX(Plain Old XML)의 늪

REST를 도입하기 전 상태를 말한다.
모든 전송과 응답을 POST로 하며 접근 가능한 엔드 포인트는 하나이며 HTTP의 body에 정보를 넣어 전송하는 기존의 리소스 전송 방식을 사용한다.

#### LEVEL 1. 자원

고유의 URI로 각각의 제공하는 자원을 주고 받는다.
모든 자원을 제공함으로써 클라이언트는 다양한 자원과 포맷(JSON, XML 등)을 제공 받을 수 있다.
리소스를 어떻게 나누고 합칠 것인지를 고려해야 한다.

#### LEVEL 2. HTTP 동사

URL과 HTTP Method, 상태 코드 등을 적극적으로 활동하며 가장 널리 알려진 방법이다.

#### LEVEL 3. 하이퍼미디어 컨트롤(HATEOAS)

하이퍼 미디어의 링크를 이용하여 서비스가 제공하는 자원에 접근하기 위해 아무런 사전 지식도 요구하지 않는 수준의 API를 기술한다.
서버가 클리이언트에게 자원을 보내면서 다음 작업을 할 수 있는 URL을 링크로 같이 보낸다.
클라이언트는 링크를 확인하고 다음 작업을 할 수 있는 URL을 확인한다.
REST API의 URL 변경시 단점을 해결 할 수 있다.
어떻게 전달해야 링크를 보고 리소스를 찾아갈 수 있는 문서가 될 수 있는지를 고려해야 한다.



#### Http Method 종류

| GET        | 요청받은 URI의 정보를 받아올 때 사용                         |
| ---------- | ------------------------------------------------------------ |
| **POST**   | **요청된 자원을 생성(CREATE)한다.**                          |
| **PUT**    | **POST와 비슷하지만 기존에 있는 정보를 UPDATE할 때 주로 사용.** |
| **DELETE** | **특정 리소스를 삭제할 때 사용**                             |



#### RESTful Service를 위한 HATEOAS

- **HATEOAS** –Hypermedia As the Engine Of Application State
  - 현재 리소스와 연관된(호출 가능한) 자원상태 정보를 제공
  - REST에서 Resource의 3가지 요소(Data, Meta Data, HATEOAS)중 하나이다.
  - 서버: 현재 리소스와 연관된 링크 정보를 클라이언트에게 제공한다.
  - 클라이언트: 연관된 링크 정보를 바탕으로 리소스에 접근한다.



##### 전형적인 REST API 응답 데이터

```json
{
  "name": "jun"
}
```



##### HATEOAS 도입

```json
{
  "name": "jun",
  "links": [
    {
      "rel": "self",
      "href": "http://localhost:8080/user"
    },
    {
      "rel": "delete",
      "href": "http://localhost:8080/user/delete"
    },
    {
      "rel": "update",
      "href": "http://localhost:8080/user/update"
    }
  ]
}
```



- HATEOAS를 보면 name이 존재하기 때문에, `삭제(delete)`와 `수정(update)`을 실행할 수 있는 **API 엔드포인트**를 확인이 가능합니다.
- 정리하자면 rel 이름만 알면 해당 기능의 실행 가능 여부를 판단할 수 있게 된다.



```xml
# pom.xml

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```



---



#### [실습]

```
# IUserService.java
```



**개별 데이터 출력(Filter를 적용하면서 HATEOAS 적용해보기)**

```java
# UserController.java

    // Spring-boot 2.2 버전
    @GetMapping("/hateoas/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable Integer id) {
        User user = service.getUser(id);

        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        EntityModel<User> model = new EntityModel<>(user);
        WebMvcLinkBuilder linkTO = linkTo(methodOn(this.getClass()).getUserList());

        model.add(linkTO.withRel("all-users"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(model);
        mapping.setFilters(provider);

        return mapping;

    }
```



![image](https://user-images.githubusercontent.com/42603919/81244300-fc1e9b80-904c-11ea-926a-4534636b3dbf.png)



##### 전체 데이터 출력(필터와 HATEOAS가 적용)

```java
# UserController.java

  @GetMapping("/users")
    public MappingJacksonValue getUserList() {
        List<User> list = service.getUserList();

        List<EntityModel<User>> result = new ArrayList<>();

        // foreach를 사용했을 경우
//        list.forEach(user -> {
//            EntityModel<User> model = new EntityModel<>(user);
//            WebMvcLinkBuilder linkTO = linkTo(methodOn(this.getClass()).getUser(user.getId()));
//            model.add(linkTO.withRel("user-datail"));
//
//            result.add(model);
//        });

        for(User user : list) {
            EntityModel<User> model = new EntityModel<>(user);
            WebMvcLinkBuilder linkTO = linkTo(methodOn(this.getClass()).getUser(user.getId()));
            model.add(linkTO.withRel("user-datail"));

            result.add(model);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(result);
        mapping.setFilters(provider);

        return mapping;
    }
```

<img src="https://user-images.githubusercontent.com/42603919/81245945-473aad80-9051-11ea-805c-f96fe2431391.png" alt="image" style="zoom:80%;" />



---

##### 참고

```
implement (class -> interface)

extends (class -> class)

extends (interface -> interface)
```

---



##### 사용자 데이터 생성

```java
# UserController.java  
  
  @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createUser = service.createUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(createUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
```



```java
# UserDaoService.java

    //사용자 생성
    @Override
    public User createUser(User newUser) {
        if(newUser.getId() == null) {
            newUser.setId(users.get(users.size() -1).getId()+1); //id 증가하는 코드 -> db를 사용한다면 자동으로 증가할 것
        }

        users.add(newUser);

        return newUser;
    }
```



##### 사용자 데이터 수정

```java
# UserController.java 

    @PutMapping("/users/{id}")
    public MappingJacksonValue modifyUser(@PathVariable Integer id, @RequestBody User modifyuser) {

        modifyuser.setId(id);
        User modifyUser = service.modifyUser(modifyuser);

        if(modifyUser == null) {
            throw new UserNotFoundException("id-" + id);
        }

        EntityModel<User> model = new EntityModel<>(modifyuser);
        WebMvcLinkBuilder linkTO = linkTo(methodOn(this.getClass()).getUserList());

        model.add(linkTO.withRel("all-users"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(model);
        mapping.setFilters(provider);

        return mapping;

    }
```



```java
# UserDaoService.java

    //사용자 수정
    @Override
    public User modifyUser(User modifyUser) {
        Iterator<User> itUsers = users.iterator();

        while (itUsers.hasNext()) {
            User user = itUsers.next();

            if(user.getId() == modifyUser.getId()) {
                user.setName(modifyUser.getName());
                user.setJoinDate(modifyUser.getJoinDate());
                user.setPassword(modifyUser.getPassword());
                user.setSsn(modifyUser.getSsn());

                return user;
            }
        }
        return null;
    }
```





##### 사용자 데이터 삭제

```java
# UserController.java 

    @DeleteMapping("/users/{id}")
    public MappingJacksonValue removeUser(@PathVariable Integer id) {
        User user = service.removeUser(id);

        EntityModel<User> model = new EntityModel<>(user);
        WebMvcLinkBuilder linkTO = linkTo(methodOn(this.getClass()).getUserList());

        model.add(linkTO.withRel("all-users"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider provider = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(model);
        mapping.setFilters(provider);

        return mapping;

    }
```



```java
# UserDaoService.java

    //사용자 삭제
    @Override
    public User removeUser(int id) {
        Iterator<User> itUser = users.iterator();

        //순차적으로 데이터를 관리하지 않기 위해서 list 대신 키 값으로 진행하는 map()을 사용하자!
        //list -> 순차적인 데이터 지원O
        //map(key,value) -> 순차적인 데이터 지원X, 중복O
        //set -> 순차적인 데이터 지원X, 중복 허용X
        while (itUser.hasNext()) {
            User user = itUser.next();

            if(user.getId() == id) {
                itUser.remove();
                return user;
            }
        }
        return null;
    }
```





---



#### Swagger

```xml
# pom.xml

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
```



```java
# SwaggerConfig.java

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private static final Contact DEFAULT_CONTACT = new Contact("Kenneth Lee",
            "http://www.joneculsting.co.kr", "edowon@joneconsluting.co.kr");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title",
            "Awesome API Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES
            = new HashSet<>(Arrays.asList("application/json", "application/xml"));


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(DEFAULT_API_INFO)
                    .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                    .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

    // Swagger와 HATEOAS를 동시에 사용할 수 있도록 해주는 코드(둘은 사용할 수 있는 버전이 다르기 때문에 맞춰주는 작업이 필요)
    @Bean
    public LinkDiscoverers discoverer() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }

}

```



<img src="https://user-images.githubusercontent.com/42603919/81247891-16a94280-9056-11ea-855a-a1b5ffcb474c.png" alt="image" style="zoom: 67%;" />



---



