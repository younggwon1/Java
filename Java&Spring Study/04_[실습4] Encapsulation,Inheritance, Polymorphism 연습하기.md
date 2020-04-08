### [실습4] Encapsulation,Inheritance, Polymorphism 연습하기

![캡처](https://user-images.githubusercontent.com/42603919/78754333-42cb9800-79b2-11ea-963a-6271c6a7141c.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78755847-d1411900-79b4-11ea-96a4-3faaca10460b.PNG)



![캡처](https://user-images.githubusercontent.com/42603919/78754406-62fb5700-79b2-11ea-96e7-d17e3a694c17.PNG)

```java
package workshop.book.entity;

public class Publication {
	private String title;
	private String publishingDate;
	private int page;
	private int price;
	
	public Publication() {
		
	}

	public Publication(String title, String publishingDate, int page, int price) {
		super();
		this.title = title;
		this.publishingDate = publishingDate;
		this.page = page;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.title;
	}
}
```





![캡처](https://user-images.githubusercontent.com/42603919/78754614-c1c0d080-79b2-11ea-972d-27baf7062788.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78752674-778a2000-79af-11ea-9379-af8ef1ebacdb.PNG)

```java
package workshop.book.entity;

public class ReferenceBook extends Publication {
	private String field;

	public ReferenceBook() {
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(String title, String publishingDate, int page, int price, String field) {
		super(title, publishingDate, page, price);
		// TODO Auto-generated constructor stub
		this.field = field;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
}
```





![캡처](https://user-images.githubusercontent.com/42603919/78754452-76a6bd80-79b2-11ea-84fd-abda042d67e1.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78754479-80302580-79b2-11ea-9a9a-bed9f3776708.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78754031-c5a02300-79b1-11ea-90c4-2832047df72e.PNG)

```java
package workshop.book.entity;

public class Magazine extends Publication {

	private String publishingPeriod;
	
	public Magazine() {
		// TODO Auto-generated constructor stub
	}

	public Magazine(String title, String publishingDate, int page, int price, String publishingPeriod) {
		super(title, publishingDate, page, price);
		// TODO Auto-generated constructor stub
	}

	public String getPublishingPeriod() {
		return publishingPeriod;
	}

	public void setPublishingPeriod(String publishingPeriod) {
		this.publishingPeriod = publishingPeriod;
	}
}
```





![캡처](https://user-images.githubusercontent.com/42603919/78754423-6abafb80-79b2-11ea-93dd-fac308df4f9f.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78754050-cc2e9a80-79b1-11ea-8252-3bc91c464524.PNG)

```java
package workshop.book.entity;

public class Novel extends Publication {

	private String author;
	private String genre;
	
	public Novel() {
		// TODO Auto-generated constructor stub
	}

	public Novel(String title, String publishingDate, int page, int price, String author, String genre) {
		super(title, publishingDate, page, price);
		// TODO Auto-generated constructor stub
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
```



![캡처](https://user-images.githubusercontent.com/42603919/78756797-57aa2a80-79b6-11ea-9be4-b0ed5c3baf95.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78755915-e8800680-79b4-11ea-9508-52ba73a39393.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78754717-ee74e800-79b2-11ea-835c-22e36d58edff.PNG)

```java
package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManageBook manager = new ManageBook();
		
		Publication[] pubs = new Publication[5];
		
		pubs[0] = new Magazine("마이크로소프트","2007-10-01",328,9900,"매월");
		pubs[1] = new Magazine("경영과컴퓨터","2007-10-03",316,9000,"매월");
		pubs[2] = new Novel("빠삐용","2007-07-01",396,9800,"베르나르베르베르","현대소설");
		pubs[3] = new Novel("남한산성","2007-04-14",383,11000,"김훈","대하소설");
		pubs[4] = new ReferenceBook("실용주의프로그래머","2007-01-14",496,25000,"소프트웨어공학");
		
		for (Publication publication : pubs) {
			System.out.println(publication);
		}
		
		System.out.println("--------가격 변경 전--------");
		System.out.println(pubs[2].getTitle() + " : " + pubs[2].getPrice());
		
		manager.modifyPrice(pubs[2]);
		
		System.out.println("--------가격 변경 후--------");
		System.out.println(pubs[2].getTitle() + " : " + pubs[2].getPrice());
	}
	
	//다형적 아규먼트(polymorphic Argument)
	public void modifyPrice(Publication pub) {
		int price = pub.getPrice();
		double rate = 0.0; //할인율
		
		if(pub instanceof Magazine) {
			rate = 0.4;
		}
		
		if(pub instanceof Novel) {
			rate = 0.2;
		}
		
		if(pub instanceof ReferenceBook) {
			rate = 0.1;
		}
		
		pub.setPrice(price - (int)(price * rate));
		
	}

}

결과

마이크로소프트
경영과컴퓨터
빠삐용
남한산성
실용주의프로그래머
--------가격 변경 전--------
빠삐용 : 9800
--------가격 변경 후--------
빠삐용 : 7840

```

