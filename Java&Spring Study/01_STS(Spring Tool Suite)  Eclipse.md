# **STS(Spring Tool Suite)** : ***Eclipse***

**JDK10** download 다운로드 후 **STS(Spring Tool Suite)**  download

[JDK10 download](https://www.oracle.com/java/technologies/java-archive-javase10-downloads.html)

[STS download](http://dist.springsource.com/release/STS/index.html)

![캡처](https://user-images.githubusercontent.com/42603919/78733190-b43e2300-797f-11ea-9326-ffa10ba19e62.PNG)

1. java 폴더를 생성 

2. spring-tool-suite-3.9.8.RELEASE-e4.11.0-win32-x86_64.zip 파일을 java 폴더 아래에 unzip 할때     디렉토리가 생성되지 않도록 압축을 풀어야 한다. (**압축 풀기, 여기에 풀기**)    

   압축 파일명에 특수 문자가 있어서 디렉토리가 생성되도록 압축을 푸시면 에러가 날 수도 있다.

   

3. 압축을 풀면 **sts-bundle** 이라는 폴더가 보인다.
4. sts-3.9.8.Release 폴더에 있는 **sts.exe** 파일을 실행한다.
5. sts.exe 를 실행하고 workspace는 **c:\java\workspace** 로 한다. 

![캡처](https://user-images.githubusercontent.com/42603919/78733409-50682a00-7980-11ea-844b-8767957d918c.PNG)



6. **실행**된 모습

   ![캡처](https://user-images.githubusercontent.com/42603919/78733426-5fe77300-7980-11ea-8f89-b2982a77eea0.PNG)



#### 이클립스와 관련된 설정

**Window -> Preferences**

Java -> Installed JREs -> Add누른 후 -> jdk가 있는 파일 폴더를 선택

jdk를 설정하고 하는게 개발하는데 편리하다.

![캡처](https://user-images.githubusercontent.com/42603919/78733975-f9635480-7981-11ea-992b-f2e1515844cb.PNG)

#### project 생성

**마우스 우측버튼 클릭 -> New -> Java Project**

![캡처](https://user-images.githubusercontent.com/42603919/78734342-f9178900-7982-11ea-9f2c-d6ee574a396b.PNG)



**project layout** : sources와 class files를 분리해서 만든다.(같은 폴더이면 배포할 때 문제가 발생)

**Finish -> Dont's create -> No**순으로 진행한다.

![캡처](https://user-images.githubusercontent.com/42603919/78734793-20bb2100-7984-11ea-9c2b-24df72405ee0.PNG)

**생성 완료!!**