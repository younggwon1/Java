# Spring

![캡처](https://user-images.githubusercontent.com/42603919/74994140-92044a80-5490-11ea-93b2-4f165abd8bd4.PNG)



> src 폴더 밑에 main과 test package가 존재한다. test에서  해당 오류 코드위에 마우스를 올려놓고 alt + enter -> 오류 해결되고 main 밑에 com.example.testdemo에 적용되어 class가 생성 그리고 내용이 추가된다.
>
> TestCalculator에서 오류를 수정하면 Calculator에 적용



```java
package com.example.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 Application SRS:계산기
 1. 2가지 숫자의 정수 덧셈
 2. 2가지 숫자의 정수 뺄셈
 */

public class TestCalculator {
    // annotation -> 부가 설명, 기능을 코드없이 설정
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(10, 20);
        System.out.println(result);
    }
    @Test
        public void testSub() {
            Calculator calc1 = new Calculator();

        int result1 = calc1.sub(20,10);
            System.out.println(result1);
        }
}
```



```java
package com.example.testdemo;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
}

```



### assertTrue, assertFalse, assertEquals

- assertTrue

  - ```
    import static org.junit.jupiter.api.Assertions.assertTrue; 필요
    ```

- assertFalse

  - ```
    import static org.junit.jupiter.api.Assertions.assertFalse; 필요
    ```

- assertEquals

  - ```
    import static org.junit.jupiter.api.Assertions.assertEquals; 필요
    ```



```java
package com.example.testdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Application SRS:계산기
 1. 2가지 숫자의 정수 덧셈
 2. 2가지 숫자의 정수 뺄셈
 */

public class TestCalculator {
    // annotation -> 부가 설명, 기능을 코드없이 설정
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(10, 20);
        assertTrue(result==30); //import static org.junit.jupiter.api.Assertions.assertTrue; 필요
        //Assertions.assertTrue(result==30); //import static org.junit.jupiter.api.Assertions; 필요
    }

    @Test
        public void testSub() {
        Calculator calc = new Calculator();
        int result = calc.sub(20, 10);
        assertTrue(result == 10);
    }

    @Test
    public void testAddError() {
        Calculator calc = new Calculator();
        int result = calc.add(10, 20);
        assertFalse(result!=30); //import static org.junit.jupiter.api.Assertions.assertFalse; 필요
    }

    @Test
    public void testSubError() {
        Calculator calc = new Calculator();
        int result = calc.sub(20, 10);
        assertEquals(10,result,"결과는 10이어야 합니다."); //import static org.junit.jupiter.api.Assertions.assertEquals; 필요
    }
}
```



```java
package com.example.testdemo;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
}

```





### git에 올리기

1. VCS -> Enable Version Control Integration 클릭 (git init에 해당)

2. 최상위 폴더 우측마우스 클릭 -> GIT -> Add 클릭 (git add에 해당)

3. 최상위 폴더 우측마우스 클릭 -> GIT -> Commit Directory (git commit에 해당)

   

  ![캡처](https://user-images.githubusercontent.com/42603919/74996061-df36eb00-5495-11ea-92cb-d69ad05b20cb.PNG)

### 저 부분만 체크 해제

![캡처](https://user-images.githubusercontent.com/42603919/74996379-b9f6ac80-5496-11ea-81aa-ad64880a9ebf.PNG)

#### 화살표 누르고 commit and push 클릭