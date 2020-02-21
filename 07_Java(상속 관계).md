# Java(상속 관계)

### 상속 관계

![캡처](https://user-images.githubusercontent.com/42603919/74999703-b9164880-549f-11ea-9b0d-9fbf81bc9c68.PNG)

> 부모클래스(CommonCar)에서 값을 바꾸면 자식클래스(Car, SportsCar, Bus)는 자연스레 그 값으로 변하게 된다.



```java
package com.example.day4;

public class CarFactory {
    public static void main(String[] args) {
        Car car1 = new Car("쏘나타1",4);
        car1.displayInfo();

        Car car2 = new Car("쏘나타2",4);
        car2.displayInfo();

        SportsCar sports1 = new SportsCar("sp one",2);
        sports1.displayInfo();

        SportsCar sports2 = new SportsCar("제네시스",2);
        sports2.displayInfo();

        Bus bus = new Bus("마을버스",15);
        bus.displayInfo();
    }
}
```



```java
package com.example.day4;

public class CommonCar {
    protected String brandName;
    protected String carName;
    protected Engine engine;

    public CommonCar() {
        System.out.println("parent class");
        this.brandName = "hyundai";
        this.engine = new Engine();
    }
}
```



```java
package com.example.day4;

public class Car extends CommonCar{

    private int doorCount ;

    public Car (String carName, int doorCount) { //생성자 생성
        System.out.println("child class");
        this.carName = carName;
        this.doorCount = doorCount;
    }

    public void displayInfo() {
        System.out.printf("%s, %s(도어수:%s)\n", brandName, carName, doorCount);
    }
}
```



```java
package com.example.day4;

public class Bus extends CommonCar {
    private int capacity;
    public Bus(String carName, int capacity) {
        this.carName = carName;
        this.capacity = capacity;
    }

    public void displayInfo() {
        System.out.printf("%s, %s(승객수:%s)\n", brandName, carName, capacity);
    }
}
```



```java
package com.example.day4;

public class SportsCar extends CommonCar{

    private int doorCount;
    private int MaxSpeed;

    public SportsCar(String carName, int doorCount) { //생성자 생성

        this.carName = carName;
        this.doorCount = doorCount;
        this.MaxSpeed = 300;

    }

    public void displayInfo() {
        System.out.printf("%s, %s(도어수:%s)\n", brandName, carName, doorCount);
    }
}
```



```java
package com.example.day4;

public class Engine {
    public Engine() {
        System.out.println("좋은 엔진입니다.");
    }
}
```





## abstact(추상 메소드)



### 1.

```java
package com.example.day4;

public class CarFactory {
    public static void main(String[] args) {
        Car car1 = new Car("쏘나타1",4);
        car1.displayInfo();

        Car car2 = new Car("쏘나타2",4);
        car2.displayInfo();

        SportsCar sports1 = new SportsCar("sp one",2);
        sports1.displayInfo();

        SportsCar sports2 = new SportsCar("제네시스",2);
        sports2.displayInfo();

        Bus bus = new Bus("마을버스",15);
        bus.displayInfo();
    }
}

```



```java
package com.example.day4;

public abstract class CommonCar {
    protected String brandName;
    protected String carName;
    protected Engine engine;

    public CommonCar() {
        System.out.println("parent class");
        this.brandName = "hyundai";
        this.engine = new Engine();
    }

    public abstract void displayInfo();
}

```



```java
package com.example.day4;

public class Car extends CommonCar{

    private int doorCount ;

    public Car (String carName, int doorCount) { //생성자 생성
        System.out.println("child class");
        this.carName = carName;
        this.doorCount = doorCount;
    }

    @Override
    public void displayInfo() {
        System.out.printf("%s, %s(도어수:%s)\n", brandName, carName, doorCount);
    }
}

```



```java
package com.example.day4;

public class Bus extends CommonCar {
    private int capacity;
    public Bus(String carName, int capacity) {
        this.carName = carName;
        this.capacity = capacity;
    }

    @Override
    public void displayInfo() {
        System.out.printf("%s, %s(승객수:%s)\n", brandName, carName, capacity);
    }
}

```



```java
package com.example.day4;

public class SportsCar extends CommonCar{

    private int doorCount;
    private int MaxSpeed;

    public SportsCar(String carName, int doorCount) { //생성자 생성

        this.carName = carName;
        this.doorCount = doorCount;
        this.MaxSpeed = 300;

    }

    @Override
    public void displayInfo() {
        System.out.printf("%s, %s(도어수:%s)\n", brandName, carName, doorCount);
    }
}

```



```java
package com.example.day4;

public class Engine {
    public Engine() {
        System.out.println("좋은 엔진입니다.");
    }
}

```

---



### 2.

```java
package com.example.day4;

public class MemberApp{
    public static void main(String[] args) {
        //Abstract class는 인스턴스 생성 못함
        GeneralMember mem1 = new GeneralMember("user1", "A");
        mem1.setPoint(100);
        mem1.display();

        VipMember mem2 = new VipMember("user2", "A") ;
        mem2.setPoint(300);
        mem2.display();

        VvipMember mem3 = new VvipMember("Vvip1");
        mem3.setPoint(300);
        mem3.display();
    }
}
```



```java
package com.example.day4;

public abstract class Member {
    protected String id;
    protected String grade;
    protected double point;

    public abstract void setPoint(int point);

    public abstract boolean isAuthorized();

    public abstract void display();
}

```



```java
package com.example.day4;

public class GeneralMember extends Member {
    public GeneralMember(String id, String grade) {
        this.id = id;
        this.grade = grade;
    }
    @Override
    public void setPoint(int point) {
        this.point = point * 0.3;
    }

    @Override
    public boolean isAuthorized() {
        return false;
    }

    @Override
    public void display() {
        System.out.printf("%s %s %s\n", super.id, super.grade, super.point); //super :  부모클래스가 가지고 있는 정보
    }
}

```



```java
package com.example.day4;

public class VipMember extends Member {
    public VipMember(String id, String grade){
        this.id = id;
        this.grade = grade;
    }
    @Override
    public void setPoint(int point) {
        this.point = point * 0.5;
    }

    @Override
    public boolean isAuthorized() {
        return true;
    }

    @Override
    public void display() {
        System.out.println("***************************");
        System.out.printf("%s %s %s\n", super.id, super.grade, super.point); //super :  부모클래스가 가지고 있는 정보
    }
}

```



```java
package com.example.day4;

public class VvipMember extends Member {
    public VvipMember (String id){
        this.id = id;
        this.grade = "v1";
    }

    @Override
    public void setPoint(int point){
        this.point = point * 0.7;
    }

    @Override
    public boolean isAuthorized() {
        return true;
    }

    @Override
    public void display() {
        System.out.println("############################");
        System.out.printf("%s %s %s\n", super.id, super.grade, super.point); //super :  부모클래스가 가지고 있는 정보
        System.out.println("############################");
    }
}

```



## Interface

```java
package com.example.day4;

public class MemberApp{
    public static void main(String[] args) {
        //Abstract class는 인스턴스 생성 못함
        GeneralMember mem1 = new GeneralMember("user1", "A");
        mem1.setPoint(100);
        mem1.display();

        VipMember mem2 = new VipMember("user2", "A") ;
        mem2.setPoint(300);
        mem2.display();

        VvipMember mem3 = new VvipMember("Vvip1");
        mem3.setPoint(300);
        mem3.display();
    }
}
```



```java
package com.example.day4;

import java.util.Date;

public class Member {
    String id;
    String grade;
    double point;
    Date joinDate;
}

```



```java
package com.example.day4;

public interface IMemberFunc { // -> public static final (상수로 만듬)
// interface에 들어가 있는 모든 메소드는 public abstract이다.

    void setPoint(int point);

    boolean isAuthorized();

    void display();
}

```



```java
package com.example.day4;

import java.util.Date;

public class GeneralMember extends Member implements IMemberFunc{
    public GeneralMember(String id, String grade) {
        this.id = id;
        this.grade = grade;
        this.joinDate = new Date();
    }

    @Override
    public void setPoint(int point) {
        this.point = point * 0.3;
    }

    @Override
    public boolean isAuthorized() {
        return false;
    }

    @Override
    public void display() {
        System.out.printf("%s, %s, %s, %s\n", super.id, super.grade, super.point, super.joinDate); //super :  부모클래스가 가지고 있는 정보
    }
}

```



```java
package com.example.day4;

import java.util.Date;

public class VipMember extends Member implements IMemberFunc{
    public VipMember(String id, String grade){
        this.id = id;
        this.grade = grade;
        this.joinDate = new Date();
    }
    @Override
    public void setPoint(int point) {
        this.point = point * 0.5;
    }

    @Override
    public boolean isAuthorized() {
        return true;
    }

    @Override
    public void display() {
        System.out.println("***************************");
        System.out.printf("%s, %s, %s, %s\n", super.id, super.grade, super.point, super.joinDate); //super :  부모클래스가 가지고 있는 정보
    }
}

```



```java
package com.example.day4;

import java.util.Date;

public class VvipMember extends Member implements IMemberFunc{
    public VvipMember (String id){
        this.id = id;
        this.grade = "v1";
        this.joinDate = new Date();
    }

    @Override
    public void setPoint(int point){
        this.point = point * 0.7;
    }

    @Override
    public boolean isAuthorized() {
        return true;
    }

    @Override
    public void display() {
        System.out.println("############################");
        System.out.printf("%s, %s, %s, %s\n", super.id, super.grade, super.point, super.joinDate); //super :  부모클래스가 가지고 있는 정보
        System.out.println("############################");
    }
}

```

