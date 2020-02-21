# Java

### 생성자(constructor)

```java
package com.example.day2;

public class Sungjuk {
    public static void main(String[] args) {
        Student stu1 = new Student("aaa",100,98,60);
        Student stu2 = new Student("bbb",80,78,30);
        Student stu3 = new Student("ccc",50,48,50);
        stu1.calSum();
        stu1.display();
        stu2.calSum();
        stu2.display();
        stu3.calSum();
        stu3.display();
    }
}
```



```java
package com.example.day2;

public class Student {
    String name;
    int kor;
    int eng;
    int mat;
    int sum;
    float avg;

    Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    void calSum() {
        this.sum = this.kor + this.eng + this.mat;
        this.avg = this.sum / 3.0f;
    }

    void display() {
        System.out.println(String.format("%s의 총점:%s, 평균: %.2f", this.name, this.sum, this.avg));
    }
}

```

---



```java
package com.example.day2;

public class Demo3 {
    public static void main(String[] args){
        Member mem1 = new Member("java",10); //인스턴스 화
        Member mem2 = new Member("C++",20);
        Member mem3 = new Member("Python");
        Member mem4 = new Member(30);

        mem1.displayInfo();
        mem2.displayInfo();
        mem3.displayInfo();
        mem4.displayInfo();
    }
}

```



```java
package com.example.day2;

public class Member { //클래스 블럭

        String name;
        int age;

        // Overloading -> 같은 클래스에서 메소드이름은 같고, 파라미터의 타입이나 개수가 다름

        Member(String name) {  // 생성자 함수
            this.name = name; //클래스 블럭에 선언되어 있는 name(this.name)에 값을 대입
        }

        Member(int age) {  // 생성자 함수
            this.age = age; //클래스 블럭에 선언되어 있는 age(this.age)에 값을 대입
        }

        Member(String name, int age) {  // 생성자 함수
           this.name = name; //클래스 블럭에 선언되어 있는 name(this.name)에 값을 대입
           this.age = age; //클래스 블럭에 선언되어 있는 age(this.age)에 값을 대입
        }

        void displayInfo() {
            System.out.println(name + ":" + age);
        }

    }



```

---



### 메소드(method)

>  void -> return 값이 없다. 나머지는 return값을 명시해야한다.

```java
package com.example.day3;

public class Demo1 {
    public static void main(String[] args){
        Calculator calc = new Calculator();
        int result = calc.add(10,50);
        System.out.println(result);
        double result1 = calc.add(10.1,20.2);
        System.out.println(result1);

//        int x = 20;
//        int y = 40;
//
//        int result3 = calc.add(x,y);
//        System.out.printf("%s, %s, %s", x, y, result3);
    }
}

```



```java
package com.example.day3;

public class Calculator {
    int add(int x, int y){
        return x + y;
    }
    double add(double x, double y){
        return x + y;
    }
    int sub(int x, int y){
        return x - y;
    }
    int mul(int x, int y){
        return x * y;
    }
    int div(int x, int y){
        return x / y;
    }
}

```



**배열 데이터 처리**

```java
package com.example.day3;

public class Demo1 {
    public static void main(String[] args){
        Calculator calc = new Calculator();


        int[] sum = {100,200,300,400}; //가변데이터(int[])를 많이 활용해볼 것
        int result = calc.add(sum);
        System.out.println(result);
    }
}

```



```java
package com.example.day3;

public class Calculator {


    int add (int[] values) { //values = sum = {100,200,300,400} -> int add (int...values)와 동일
        int result = 0;
        for (int value : values)
            result += value;
        return result;
    }

}

```



### 접근권한 modifier

#### 1. import시키기, Student -> public으로 바꾸기

```java
package com.example.day3;

import com.example.day2.Student; //외부에 해당하는 파일을 가져와 사용하고 싶을 때 사용

public class SungjukAppV2 {
    public static void main(String[] args) {
        Student stu1 = new Student("aaa", 100, 98, 60);
    }
}
```



```java
package com.example.day2;

public class Student {
    String name;
    int kor;
    int eng;
    int mat;
    int sum;
    float avg;

    // 접근권한 modifier -> default, private, protected, public
    // private : 같은 class에서만 사용가능
    // default : 같은 class, package에서 사용가능
    // protected : 같은 class,package , 다른 package(단, 상속 관계)에서 사용가능
    // public : 같은 class,package , 다른 package에서 사용가능
    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    void calSum() {
        this.sum = this.kor + this.eng + this.mat;
        this.avg = this.sum / 3.0f;
    }

    void display() {
        System.out.println(String.format("%s의 총점:%s, 평균: %.2f", this.name, this.sum, this.avg));
    }
}

```



#### 2. calSum, display -> public으로 바꾸기

```java
package com.example.day3;

import com.example.day2.Student; //외부에 해당하는 파일을 가져와 사용하고 싶을 때 사용

public class SungjukAppV2 {
    public static void main(String[] args) {
        Student stu1 = new Student("aaa", 100, 98, 60);
        stu1.calSum();
        stu1.display();
    }
}

결과

aaa의 총점:258, 평균: 86.00
```



```java
package com.example.day2;

public class Student {
    String name;
    int kor;
    int eng;
    int mat;
    int sum;
    float avg;

    // 접근권한 modifier -> default, private, protected, public
    // private : 같은 class에서만 사용가능
    // default : 같은 class, package에서 사용가능
    // protected : 같은 class,package , 다른 package(단, 상속 관계)에서 사용가능
    // public : 같은 class,package , 다른 package에서 사용가능
    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public void calSum() {
        this.sum = this.kor + this.eng + this.mat;
        this.avg = this.sum / 3.0f;
    }

    public void display() {
        System.out.println(String.format("%s의 총점:%s, 평균: %.2f", this.name, this.sum, this.avg));
    }
}

```



#### 3. 배열로 접근

```java
package com.example.day3;

import com.example.day2.Student; //외부에 해당하는 파일을 가져와 사용하고 싶을 때 사용

public class SungjukAppV2 {
    public static void main(String[] args) {


        Student[] students = new Student[] {
                new Student("aaa",100,98,60),
                new Student("bbb",89,78,37),
                new Student("ccc",50,48,50)
        };

        // 각 학생의 총점, 평균 구하기
        for (Student stu : students) {
            stu.calSum();
        }

        // 각 학생 데이터 출력
        for (Student stu : students) {
            String msg = stu.display();
            System.out.println(msg);
        }
    }
}

결과

aaa의 총점:258, 평균: 86.00
bbb의 총점:204, 평균: 68.00
ccc의 총점:148, 평균: 49.33
```



```java
package com.example.day2;

public class Student {
    String name;
    int kor;
    int eng;
    int mat;
    int sum;
    float avg;

    // 접근권한 modifier -> default, private, protected, public
    // private : 같은 class에서만 사용가능
    // default : 같은 class, package에서 사용가능
    // protected : 같은 class,package , 다른 package(단, 상속 관계)에서 사용가능
    // public : 같은 class,package , 다른 package에서 사용가능
    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public void calSum() {
        this.sum = this.kor + this.eng + this.mat;
        this.avg = this.sum / 3.0f;
    }

public String display() {
        return String.format("%s의 총점:%s, 평균: %.2f", this.name, this.sum, this.avg);
        }
}

```



### 재정의

```java
package com.example.day3;

import com.example.day2.Student; //외부에 해당하는 파일을 가져와 사용하고 싶을 때 사용

public class SungjukAppV2 {
    public static void main(String[] args) {


        Student[] students = new Student[] {
                new Student("aaa",100,98,60),
                new Student("bbb",100,98,60),
                new Student("ccc",50,48,50)
        };

        // 각 학생의 총점, 평균 구하기
        for (Student stu : students) {
            stu.calSum();
        }

        // 각 학생 데이터 출력
        for (Student stu : students) {
//            String msg = stu.toString();
            System.out.println(stu); // println(stu.toString())
        }

        System.out.println(students[0].equals(students[1]));
        System.out.println(students[0] == students[1]);
    }
}

결과
 
aaa의 총점:258, 평균: 86.00
bbb의 총점:258, 평균: 86.00
ccc의 총점:148, 평균: 49.33
true
false
```



```java
package com.example.day2;

public class Student {
    String name;
    int kor;
    int eng;
    int mat;
    int sum;
    float avg;

    // 접근권한 modifier -> default, private, protected, public
    // private : 같은 class에서만 사용가능
    // default : 같은 class, package에서 사용가능
    // protected : 같은 class,package , 다른 package(단, 상속 관계)에서 사용가능
    // public : 같은 class,package , 다른 package에서 사용가능
    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public void calSum() {
        this.sum = this.kor + this.eng + this.mat;
        this.avg = this.sum / 3.0f;
    }

    @Override
    public String toString() {
        return String.format("%s의 총점:%s, 평균: %.2f", this.name, this.sum, this.avg);
    }



    @Override
    public boolean equals(Object obj) {
        Student temp = (Student)obj;
        return (this.kor == temp.kor && this.eng == temp.eng && this.mat == temp.mat); //국, 영, 수 점수가 다 같으면 true
    }
}

```





**Comparable** : 객체 간의 **일반적인 정렬**이 필요할 때, Comparable 인터페이스를 확장해서 정렬의 기준을 정의하는 compareTo() 메서드를 구현한다. 이 인터페이스를 구현한 객체 스스로에게 부여하는 한 가지 기본 정렬 규칙을 설정하는 목적으로 사용한다.

**Comparator** : 객체 간의 **특정한 정렬**이 필요할 때, Comparator 인터페이스를 확장해서 특정 기준을 정의하는 compare() 메서드를 구현한다. 이 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미하며, 기본 정렬 규칙과 다르게 원하는대로 정렬순서를 지정하고 싶을 때 사용한다.



#### Comparator

```java
package com.example.day3;

import com.example.day2.Student; //외부에 해당하는 파일을 가져와 사용하고 싶을 때 사용

import java.util.Arrays;

public class SungjukAppV2 {
    public static void main(String[] args) {


        Student[] students = new Student[] {
                new Student("aaa",100,98,60),
                new Student("zzz",100,100,100),
                new Student("bbb",100,98,60),
                new Student("ccc",50,48,50),
                new Student("eee",10,20,10)
        };

        // 각 학생의 총점, 평균 구하기
        for (Student stu : students) {
            stu.calSum();
        }

        // 각 학생 데이터 출력
        System.out.println("----------- befor sorting");
        for (Student stu : students) {
//            String msg = stu.toString();
            System.out.println(stu); // println(stu.toString())
        }
        // Comparator, Comparable
        Arrays.sort(students, new Mycomparator());

        System.out.println("----------- after sorting");
        for (Student stu : students) {
//            String msg = stu.toString();
            System.out.println(stu); // println(stu.toString())
        }
    }
}
```



```java
package com.example.day3;

import com.example.day2.Student;

import java.util.Comparator;

public class Mycomparator implements Comparator<Student> {

    @Override
    public int compare (Student s1, Student s2) {
        if (s1.getSum() > s2.getSum())
        {
            return -1;
        }
        else if (s1.getSum() < s2.getSum()) {
            return 1;
        }
        else {
            return s1.getName().compareTo(s2.getName());
        }

    }
}

```



```java
package com.example.day2;

public class Student {
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int sum;
    private float avg;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    // 접근권한 modifier -> default, private, protected, public
    // private : 같은 class에서만 사용가능
    // default : 같은 class, package에서 사용가능
    // protected : 같은 class,package , 다른 package(단, 상속 관계)에서 사용가능
    // public : 같은 class,package , 다른 package에서 사용가능
    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public void calSum() {
        this.sum = this.kor + this.eng + this.mat;
        this.avg = this.sum / 3.0f;
    }

    @Override
    public String toString() {
        return String.format("%s의 총점:%s, 평균: %.2f", this.name, this.sum, this.avg);
    }


    @Override
    public boolean equals(Object obj) {
        Student temp = (Student)obj;
        return (this.kor == temp.kor && this.eng == temp.eng && this.mat == temp.mat); //국, 영, 수 점수가 다 같으면 true
    }
}

```



#### Comparable

```java
package com.example.day3;

import com.example.day2.Student; //외부에 해당하는 파일을 가져와 사용하고 싶을 때 사용

import java.util.Arrays;

public class SungjukAppV2 {
    public static void main(String[] args) {


        Student[] students = new Student[] {
                new Student("aaa",100,98,60),
                new Student("zzz",100,100,100),
                new Student("bbb",100,98,60),
                new Student("ccc",50,48,50),
                new Student("eee",10,20,10)
        };

        // 각 학생의 총점, 평균 구하기
        for (Student stu : students) {
            stu.calSum();
        }

        // 각 학생 데이터 출력
        System.out.println("----------- befor sorting");
        for (Student stu : students) {
//            String msg = stu.toString();
            System.out.println(stu); // println(stu.toString())
        }
        // Comparator, Comparable
//        Arrays.sort(students, new Mycomparator()); //Comparator
        Arrays.sort(students); //Comparable


        System.out.println("----------- after sorting");
        for (Student stu : students) {
//            String msg = stu.toString();
            System.out.println(stu); // println(stu.toString())
        }
    }
}

```



```java
package com.example.day2;

public class Student implements Comparable<Student> {
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int sum;
    private float avg;

    @Override
    public int compareTo(Student s2) {
        if (this.getSum() > s2.getSum())
        {
            return -1;
        }
        else if (this.getSum() < s2.getSum()) {
            return 1;
        }
        else {
            return this.getName().compareTo(s2.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    // 접근권한 modifier -> default, private, protected, public
    // private : 같은 class에서만 사용가능
    // default : 같은 class, package에서 사용가능
    // protected : 같은 class,package , 다른 package(단, 상속 관계)에서 사용가능
    // public : 같은 class,package , 다른 package에서 사용가능
    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public void calSum() {
        this.sum = this.kor + this.eng + this.mat;
        this.avg = this.sum / 3.0f;
    }

    @Override
    public String toString() {
        return String.format("%s의 총점:%s, 평균: %.2f", this.name, this.sum, this.avg);
    }


    @Override
    public boolean equals(Object obj) {
        Student temp = (Student)obj;
        return (this.kor == temp.kor && this.eng == temp.eng && this.mat == temp.mat); //국, 영, 수 점수가 다 같으면 true
    }
}

```





### static

