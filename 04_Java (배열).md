# Java (배열)

- 배열 생성 : **타입[] 변수명 = {값1,값2,...};**

```
ex)
int[] scores ={1,2,3,4,5,6,7};
```



```java
package com.example.day2;

public class Demo1 {
    public static void main(String[] args) {
        int[] scores ={1,2,3,4,5,6,7};

        System.out.println(scores.length);
        System.out.println(scores[0]);
        System.out.println(scores[5]);
        System.out.println(scores[7]); // 배열이 가지고 있는 인덱스의 범위를 초과한 경우 에러 발생
    }
}

결과
    
7
1
6
error
```



- 배열 선언 방법

```java
package com.example.day2;

public class Demo1 {
    public static void main(String[] args) {
        String[] names = {"A","BB","CCC","DDDD","EEEEE"}; // 배열 선언 첫번째 방법
        System.out.println(names.length);
        System.out.println(names[1]);
        names[4] = "JAVA";
        System.out.println(names[4]);
    }
}

결과

5
BB
JAVA
    
package com.example.day2;

public class Demo1 {
    public static void main(String[] args) {
        String[] names = new String[] {"A","BB","CCC","DDDD","EEEEE"}; //배열 선언 두번째 방법

        int[] scores;
        scores = new int[]{1,2,3,4,5,6,7};

        String[] animals = new String[5]; // 배열 선언 세번째 방법
        System.out.println(animals.length);
        animals[0] = "cat";
        animals[1] = "dog";
        animals[2] = new String("lion");
        animals[3] = new String("rat");
        animals[4] = new String("tiger");

//        for (int i=0; i < animals.length; i++) {
//            System.out.println(animals[i]);
//        }

        for (String a : animals) {
            System.out.println(a);
        }
    }
}

```



---

```java
package com.example.day2;

public class Demo1 {
    public static void main(String[] args) {
        double[] d = new double[5];

        d[0] = 0.0;                 // (8bytes)double = double
        d[1] = 3.14f;               // (8bytes)double = (4bytes)float
        d[2] = 100;                 // (8bytes)double = (4bytes)int
        d[3] = 3_200_000_000L;      // (8bytes)double = (8bytes)long
        d[4] = 'A';                 // (8bytes)double = (2bytes)character

        for (double _d : d) {
            System.out.println(_d);
        }
    }
}
```

---



- String[] args

```java
1. terminal창에서
C:\Users\HPE\IdeaProjects\FirstProject\out\production\FirstProject>java com.example.day2.Demo1 Hello World를 하게되면

package com.example.day2;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0]);

        // args = {Hello, World}
        }
    }

결과
2
Hello
    
2. Edit configuration에서 실행
   동일한 결과를 얻을 수 있다.
```

![캡처](https://user-images.githubusercontent.com/42603919/74795927-90a91580-530a-11ea-959d-06c98d9455db.PNG)

**화살표를 클릭하고 Edit configuration을 선택**



```java
package com.example.day2;

public class Demo1 {
    public static void main(String[] args) {
//        int[][] scores = new int[2][3];
        int[] scores[] = new int[2][3]; // 위의 코드와 동일한 표현 방식
        scores[0] = new int[2]; //1번째 행에 2개 배열을 생성
        scores[1] = new int[4]; //2번째 행에 4개 배열을 생성

        scores[0][0] = 100;
        scores[0][1] = 200;
//        scores[0][2] = 300;
        scores[1][0] = 400;
        scores[1][1] = 500;
        scores[1][2] = 600;
        scores[1][3] = 700;

        System.out.println(scores.length);
        System.out.println(scores[0].length);
        System.out.println(scores[1].length);

//        for (int i=0; i< scores.length; i++) { //for문을 이용
//            for (int j=0; j < scores[i].length; j++) {
//                System.out.print(String.format("[%s][%s]=%s\t",i,j,scores[i][j]));
//            }
//            System.out.println();
//        }

        for (int[] row : scores){ //for each문을 이용
            for(int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        }
    }
```





#### 배열 복사

```java
package com.example.day2;

public class Demo2 {
    public static void main(String[] args){
        String[] strArray = new String[3];
        strArray[0] = "JAVA1.8";
        strArray[1] = "JAVA 1.12";
        strArray[2] = new String("JAVA 1.13");

        String[] newArray = new String[3];
        System.arraycopy(strArray, 0, newArray, 0, strArray.length); // 배열 복사

        for (String str: newArray) {
            System.out.println(str);
        }
    }
}
```











