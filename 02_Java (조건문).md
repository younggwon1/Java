

# Java (조건문)

### if문

```java
package com.example;

public class example2 {
    public static void main(String[] args){
        int Jumsu = 60;

        if (Jumsu == 100) {
            String message = "축하합니다 ";
            System.out.println(message + "만점입니다.");
        }
        else if (Jumsu >= 60){
            String message = "축하합니다 ";
            System.out.println(message + "합격입니다.");
        }
        else {
            String message = "죄송합니다 ";
            System.out.println(message + "불합격입니다.");
        }

    }
}
```



### switch문

```java
package com.example;

public class example2 {
    public static void main(String[] args){
        int a = 10;
        switch (a) {
            case 10:
                System.out.println("10을 선택하셨습니다.");
                break;
            case 9:
                System.out.println("9를 선택하셨습니다.");
                break;
            case 8:
                System.out.println("8을 선택하셨습니다.");
                break;
            default:
                System.out.println("다른값을 선택하셨습니다.");
                break;
        }
    }
}
```

```java
package com.example;
import java.util.Scanner;

public class example2 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        System.out.print("국어점수=");
        int kor = s.nextInt();
        System.out.print("영어점수=");
        int eng = s.nextInt();
        System.out.print("수학점수=");
        int mat = s.nextInt();

        int total = kor + eng + mat;
        float avg = total/3.0f;

        int a = (int)avg/10;

        switch(a) {
            case 10:
            case 9:
                System.out.println("A학점");
                break;
            case 8:
            case 7:
                System.out.println("B학점");
                break;
            case 6:
            case 5:
                System.out.println("C학점");
                break;
            default:
                System.out.println("D학점");
                break;
        }
    }
}

```

