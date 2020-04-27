package lambda;

import java.util.HashSet;
import java.util.Set;

import jdbc.user.vo.MyDate;

public class MyDateHashCodeTest {

	public static void main(String[] args) {
		
		MyDate date1 = new MyDate(2020,4,24);
		System.out.println(date1);
		MyDate date2 = new MyDate(2020,4,24);
		System.out.println(date2);
		
		MyDate date3 = new MyDate(2020,4,25);
		System.out.println(date3);
		
		//주소 비교
		System.out.println(date1 == date2);
		//값 비교
		//object에 있는 equals가 호출되므로 false이다. MyDate에는 equals 선언 안해놨음.
		//하지만 값을 비교하도록 MyDate에는 equals 선언 해놔서 true가 나옴.
		System.out.println(date1.equals(date2)); 
		
		
		//hashSet - 중복을 허용하지 않음
		Set<MyDate> set = new HashSet<>();
		set.add(date1);
		set.add(date2);
		set.add(date3);
		
		//중복되어도 출력이 된다. hash값이 일치하지 않기 때문이다.
		//hash 값을 비교하도록 MyDate에는 hash 선언 해놔서 중복된 값은 출력되지 않는다.
		set.forEach(date -> System.out.println(date));
		
		
	}

}
