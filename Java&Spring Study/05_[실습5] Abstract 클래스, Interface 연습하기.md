### [실습5] Abstract 클래스, Interface 연습하기

![캡처](https://user-images.githubusercontent.com/42603919/78757941-45c98700-79b8-11ea-887f-0dba29af7412.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78764543-aad5aa80-79c1-11ea-844a-ef2ba38bb15b.PNG)

**마우스 우측버튼 -> NEW -> Interface**

```java
package workshop.animal.entity;

public interface Pet {
	void setName(String name); //인터페이스에서는 abstract를 명시안해도됨
	String getName();
	void play();
}
```





![캡처](https://user-images.githubusercontent.com/42603919/78760357-ff762700-79bb-11ea-83c1-5faadd825f6b.PNG)

```java
package workshop.animal.entity;

/**
 * 추상클래스
 * 추상클래스는 스스로 캑체를 생설할 수 없다.
 * Animal ani = new Animal(x)
 * Animal cat = new Cat(o)
 * 추상메서드가 없어도 된다.
 */
public abstract class Animal {
	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	public abstract void eat();//추상클래스에서는 abstract를 명시해야함
}
```



![캡처](https://user-images.githubusercontent.com/42603919/78762067-60066380-79be-11ea-92b7-a3a048bc1e83.PNG)

```java
package workshop.animal.entity;

public class Cat extends Animal implements Pet {
	
	private String name;
	
	public Cat(String name) {
		super(4); //다리개수 4개
		this.name = name;
	}
	
	public Cat() {
		this("");
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void play() {
		System.out.println("고양이는 쥐랑 놉니다.");

	}

	@Override
	public void eat() {
		System.out.println("고양이는 물고기를 먹습니다.");

	}

}

```





![캡처](https://user-images.githubusercontent.com/42603919/78762991-942e5400-79bf-11ea-9ed5-6280110b0077.PNG)

```java
package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	
	private String name;
	
	public Fish() {
		super(0);
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void play() {
		System.out.println("어항에서 놉니다.");

	}

	@Override
	public void eat() {
		System.out.println("플랑크톤을 먹습니다.");

	}
	
	@Override
	public void walk() {
		System.out.println("물고기는 걷지않고 헤엄칩니다.");
	}

}
```



![캡처](https://user-images.githubusercontent.com/42603919/78764463-88439180-79c1-11ea-9eb7-2a36585dc5f4.PNG)

```java
package workshop.animal.entity;

public class Spider extends Animal {

	public Spider() {
		super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("거미는 벌레를 먹습니다.");

	}

}
```



![캡처](https://user-images.githubusercontent.com/42603919/78764333-5d593d80-79c1-11ea-9c48-9cf17a8a09c2.PNG)

```java
package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Pet;

public class TestAnimal {
	
	public static void main(String[] args) {
	
	Cat cat1 = new Cat();
	cat1.setName("플러피");
	System.out.println(cat1.getName());
	cat1.play();
	cat1.eat();
	cat1.walk();
	
	Animal cat2 = new Cat("플러피2");
	cat2.eat();
	cat2.walk();
	
	Pet cat3 = new Cat();
	cat3.setName("플러피3");
	System.out.println(cat3.getName());
	cat3.play();
	}
}

```

