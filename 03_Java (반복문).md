# Java (반복문)

### 실습

#### 1. 약수 구하기(입력 값)

```java
package com.example;
import java.util.Scanner;

public class example2 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        System.out.print("값을 입력하세요=");
        int num = s.nextInt();
        int a=0, i;

        for (i=0; i<num; i++) {
            a++;
            if (num%a==0) {
                System.out.println(a);
            }
        }
    }
}
```



#### 2. 소수 구하기

```java
package com.example;
import java.util.Scanner;

public class example2 {
    public static void main(String[] args){
        int lineNumber = 1;
        int count = 0; //각 라인에 출력되는 숫자의 개수

        boolean isNotPrime;
        for (int num=2; num<=107; num++){
            isNotPrime = false;
            for (int i=2; i<num; i++){
                if(num%i==0){
                    isNotPrime = true;
                    break;
                }
            }
            if (!isNotPrime) {
                System.out.println(num + "\t");
                count++;
            }

            if(lineNumber==count) {
                System.out.println();
                lineNumber++;
                count=0;
            }
        }

    }
}
```



#### 3. 피보나치 수열

```java
package com.example;

public class example2 {
    public static void main(String[] args){
        int previosNumber =1;
        int nextNumber = 1;
        int currentNumber = 0;
        int count = 0;

        System.out.println(previosNumber);
        System.out.println(nextNumber);

        while(currentNumber < 1000) {
            currentNumber = previosNumber + nextNumber;
            System.out.println(currentNumber);
            previosNumber=nextNumber;
            nextNumber=currentNumber;
            count++;
        }
        System.out.println("1000번을 넘은 횟수는" + count);
    }
}


```

