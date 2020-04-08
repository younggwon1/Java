### [실습3] Encapsulation 개념, 배열 연습하기

![캡처](https://user-images.githubusercontent.com/42603919/78744410-73a0d280-799c-11ea-9b30-53ad3a33343f.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78744278-202e8480-799c-11ea-9e07-eef446f34b24.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78744550-d8f4c380-799c-11ea-8447-2ebdfca74c27.PNG)

```java
package workshop.person.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String ssn;
	private String address;
	private String phone;
	
	//default constructor
	public PersonEntity() {
		
	}

	public PersonEntity(String name, String ssn, String address, String phone) {
		this.name = name;
		//this.ssn = ssn;
		setSsn(ssn);
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		
		//주민번호에 의거해서 남자인지 여자인지 판별하기
		char flag =ssn.charAt(6);
		if(flag == '1' || flag == '3') {
			setGender('남');
		}
		else if(flag == '2' || flag == '4') {
			setGender('여');
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PersonEntity [name=" + name + ", gender=" + gender + ", ssn=" + ssn + ", address=" + address
				+ ", phone=" + phone + "]";
	}

}
```



![캡처](https://user-images.githubusercontent.com/42603919/78744445-8c10ed00-799c-11ea-9f29-b38dbb04e0b9.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78744474-9e8b2680-799c-11ea-82ec-8bc0585c5b33.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78744791-73ed9d80-799d-11ea-856e-1243ebc7ff01.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78744816-823bb980-799d-11ea-8d9c-843546425def.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78744658-18231480-799d-11ea-8735-16820ee6c37f.PNG)

```java
/**
 * 
 */
package workshop.person.control;

import java.util.Scanner;

import workshop.person.entity.PersonEntity;

/**
 * @author user
 *
 */
public class PersonManager {

	/**
	 * java PersonManager 남 
	 */
	public static void main(String[] args) {
//		if(args.length < 1) {
//			System.out.println("성별 값을 입력하세요");
//			System.exit(0);
//		}
				
		PersonManager manager = new PersonManager();
		PersonEntity[] persons = new PersonEntity[10];
		manager.fillPersons(persons);
		manager.showPersons(persons);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("성별을 입력하세요");
		char gender = scan.next().charAt(0);
		System.out.println("입력된 성별 값은 " + gender);

		System.out.println("성별 " + gender + "는(은) " + 
		manager.findByGender(persons,gender) + " 명 입니다.");
		
		System.out.println("이름을 입력하세요");
		String name = scan.next();
		System.out.println("이름 "  + name + " 으로 찾기 결과입니다.");
		manager.showPerons(persons, name);
		
		scan.close();
	}

	public void showPerons(PersonEntity[] persons, String name) {
		for (PersonEntity person : persons) {
			if(name.equals(person.getName())) {
				System.out.println("[ 이름 ]"  + person.getName());
				System.out.println("[ 성별 ]"  + person.getGender());
				System.out.println("[ 전화번호]"  + person.getPhone());
				break;
			}
		}
		
	}

	public int findByGender(PersonEntity[] persons, char gender) {
		int cnt=0;
		for (PersonEntity person : persons) {
			if(person.getGender() == gender) {
				cnt++;
			}
		}
		return cnt;
		
	}

	public void showPersons(PersonEntity[] persons) {
		//foreach : ctrl + spacebar 
		for (PersonEntity person : persons) {
			System.out.println("[이름] " + person.getName() + 
					"\t [성별] "+ person.getGender() + "\t [전화번호] " + person.getPhone());
		}
	}
	

	public void fillPersons(PersonEntity[] persons) {
		persons[0]=new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
		persons[1]=new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
		persons[2]=new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542");
		persons[3]=new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223");
		persons[4]=new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333");
		persons[5]=new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934");
		persons[6]=new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932");
		persons[7]=new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939");
		persons[8]=new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202");
		persons[9]=new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832");	
	}
}
```

---

#### **Collection**

- **List**는 순서가 있다. 중복을 허용한다. 대표적으로 Array List(thread-safe하게 구현x), Vector(thread-safe하게 구현o)

- **Set**은 순서가 없다. 중복을 허용하지 않는다. 대표적으로 hashset이 있다

**Map** 대표적으로 hashmap(thread-safe하게 구현x), hashtable(thread-safe하게 구현o)



따라서 방금 만들어 봤던 예제를 Collection으로 바꿔서 만들어보자.

```java
/**
 * 
 */
package workshop.person.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workshop.person.entity.PersonEntity;

/**
 * @author user
 *
 */
public class PersonManagerCollection {

	/**
	 * java PersonManager 남 
	 */
	public static void main(String[] args) {
//		if(args.length < 1) {
//			System.out.println("성별 값을 입력하세요");
//			System.exit(0);
//		}
		
		PersonManagerCollection manager = new PersonManagerCollection();
		List<PersonEntity> persons = new ArrayList<>();
		
		//PersonEntity[] persons = new PersonEntity[10];
		manager.fillPersons(persons);
		manager.showPersons(persons);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("성별을 입력하세요");
		char gender = scan.next().charAt(0);
		System.out.println("입력된 성별 값은 " + gender);

		System.out.println("성별 " + gender + "는(은) " + 
		manager.findByGender(persons,gender) + " 명 입니다.");
		
		System.out.println("이름을 입력하세요");
		String name = scan.next();
		System.out.println("이름 "  + name + " 으로 찾기 결과입니다.");
		manager.showPerons(persons, name);
		
		scan.close();
	}

	public void showPerons(List<PersonEntity> persons, String name) {
		for (PersonEntity person : persons) {
			if(name.equals(person.getName())) {
				System.out.println("[ 이름 ]"  + person.getName());
				System.out.println("[ 성별 ]"  + person.getGender());
				System.out.println("[ 전화번호]"  + person.getPhone());
				break;
			}
		}
		
	}

	public int findByGender(List<PersonEntity> persons, char gender) {
		int cnt=0;
		for (PersonEntity person : persons) {
			if(person.getGender() == gender) {
				cnt++;
			}
		}
		return cnt;
		
	}

	public void showPersons(List<PersonEntity> persons) {
		//foreach : ctrl + spacebar 
		for (PersonEntity person : persons) {
			System.out.println("[이름] " + person.getName() + 
					"\t [성별] "+ person.getGender() + "\t [전화번호] " + person.getPhone());
		}
	}
	

	public void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932"));
		persons.add(new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932"));
		persons.add(new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542"));
		persons.add(new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223"));
		persons.add(new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333"));
		persons.add(new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934"));
		persons.add(new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932"));
		persons.add(new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939"));
		persons.add(new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202"));
		persons.add(new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832"));	
	}	
}
```

