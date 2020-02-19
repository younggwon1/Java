# JAVA

> 객체 지향 프로그래밍



```java
import java.lang.*;

public class HelloWorld {
    // 파일명과 class명은 동일해야한다.
    // 객체지향언어에서 function은 method로 표현된다.
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```



-> 해당 파일로 가서 **javac 파일이름.java**를 입력한다 -> **컴파일 실행**

```
C:\Users\HPE\work\cloud-computing\java\day01>javac HelloWorld.java
```

-> 아무런 반응이 없는 경우 컴파일 성공 -> 컴파일이 성공한다면 **.class** 파일이 생성된다.

-> 만약 이상한 글이 뜬다면 오류가 발생



-> **파일 실행** : **java 파일이름**

```
C:\Users\HPE\work\cloud-computing\java\day01>java HelloWorld
```



**ctrl + shift + f** => 단어를 찾아줌

**shift + shift** => 파일을 찾아줌



### cmd 창에서 실행하는 방법

1. IntelliJ에서 RUN을 한다.

2. src 상위폴더에서 다음과 같이 실행 (HelloWorld는 com.example안에 위치해 있다.)

   com.example은 package이다.
   
   ```
C:\Users\HPE\IdeaProjects\FirstProject\out\production\FirstProject>java com.example.HelloWorld
   ```
   
   

### class가 가질 수 있는 범위

- Nested class (중첩 클래스)
- Field
- Method

```java
package com.example.day2;

public class Member {
    public static void main(String[] args){
        //nested class(option)
        class vipmember {

        }

        //field
        int age = 10;
        String name = "JAVA";

        //method
        void 메소드이름1() {

        }

        int 메소드이름2() {
            return 1;
        }

        // constructor method(option)

    }
}

```



overloading : 같은 클래스 

overriding : 부모 자식간의



### 실습

```java
package com.example;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int hour = 3;
        int minute = 5;

        System.out.println("지금은" + hour + "시" + minute + "분 입니다.");
        System.out.println(String.format("지금은 %s시 %s분 입니다.", hour, minute));
        System.out.println(1+2+3); // 6
        System.out.println(1 + 2 + "=" + 3); // 3=3
        System.out.println("문제:" + 1 + 2 + 3); // 문제:123

        // 숫자 -> 문자
        System.out.println(String.valueOf(1));
        System.out.println("" + 1);


    }

}

결과
    
Hello World
지금은3시5분 입니다.
지금은 3시 5분 입니다.
6
3=3
문제:123
1
1
```



```java
package com.example;

public class HelloWorld {
    public static void main(String[] args) {

        System.out.println("나는 \"자바\"를 좋아합니다.");
        System.out.println("나는 \n자바를 좋아합니다."); // 줄바꿈
        System.out.println("나는 \t자바를 좋아합니다."); // tab
        System.out.println("나는 \u00A3 자바를 좋아합니다."); //유니코드

    }
}

결과

나는 "자바"를 좋아합니다.
나는 
자바를 좋아합니다.
나는 	자바를 좋아합니다.
나는 £ 자바를 좋아합니다.
```



```java
package com.example;

public class HelloWorld {
    public static void main(String[] args) {
        
        int a = 10;
        float pi = 3.14; //실수형은 double 형태로 된다.
                         //float pi(4byte)=3.14(8byte)따라서 float pi -> double pi로 바꾼다.
        double pi =3.14;
        float pi2 = 3.14f;
        float pi3 = (float)3.14; // 다운 casting은 데이터 손실이 발생할 수 있다.
        
        System.out.println(a * a * pi);
    }
}
```



### 강제 형변환

```java
package com.example;

public class HelloWorld {
    public static void main(String[] args) {

            int intValue = 65;
            char charValue = (char)intValue;
            System.out.println(charValue);
    }
}

결과

A
```



```java
package com.example;

public class HelloWorld {
    public static void main(String[] args) {

            double doubleValue = 3.14;
            int intValue = (int) doubleValue;
            System.out.println(intValue);
    }
}

결과

3
```



---

#### 강제 변환

String -> int (이 형태를 기억)

String str = '30000'

**Integer.parseInt(str)**

```java
package com.example;

public class HelloWorld {
    public static void main(String[] args) {

            String korJumsu = "100";
            int total = 58;
            
            total += Integer.parseInt(korJumsu);

            System.out.println("KOR=" + korJumsu);
            System.out.println("total=" + total);
    }
}
```

---



```java
package com.example;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("국어점수=");
        int kor = s.nextInt(); // 사용자로부터 입력을 받아야 다음 코드가 실행된다.
        System.out.print("영어점수=");
        int eng = s.nextInt(); // 사용자로부터 입력을 받아야 다음 코드가 실행된다.
        System.out.print("수학점수=");
        int mat = s.nextInt(); // 사용자로부터 입력을 받아야 다음 코드가 실행된다.

        System.out.println(kor);
        System.out.println(eng);
        System.out.println(mat);

        int total = kor + eng + mat;
        float avg = total/3.0f;

        String result1 = String.format("총점:%s, 평균:%s", total,avg);
        String result2 = String.format("총점:%s, 평균:%.2f", total,avg); //소수점 2번째 자리까지 출력

        System.out.println(result1);
        System.out.println(result2);

    }
}
```



```java
package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class example2 {
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        int c = a++ + ++b;
        System.out.println(a + "," + a++ + "," + ++b + "," + c);

    }
}

결과

2,2,4,4
```



```java
package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class example2 {
    public static void main(String[] args){

        String name = "younggwon";
        List list1 = new ArrayList();
        Collection list2 = new ArrayList();

        System.out.println(list1 instanceof List);
        System.out.println(list1 instanceof Collection);

        System.out.println(list2 instanceof List);
        System.out.println(list2 instanceof Collection);
    }
}

결과

true
true
true
true
```



### 시간

```java
package com.example;

public class example2 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();

        System.out.println("경과 시간 : " + (endTime - startTime));
    }
}

결과 

0
```



```java
package com.example;

public class example2 {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        System.out.println("경과 시간 : " + (endTime - startTime));
    }
}

결과

200
```



```java
package com.example;

public class example2 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        String str = "A";
        for (int i = 0; i<1_000_000; i++) {
            str += "A";
        }

        long endTime = System.currentTimeMillis();

        System.out.println("경과 시간 : " + (endTime - startTime));
    }
}

결과

99233
```

