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
		
		//�ּ� ��
		System.out.println(date1 == date2);
		//�� ��
		//object�� �ִ� equals�� ȣ��ǹǷ� false�̴�. MyDate���� equals ���� ���س���.
		//������ ���� ���ϵ��� MyDate���� equals ���� �س��� true�� ����.
		System.out.println(date1.equals(date2)); 
		
		
		//hashSet - �ߺ��� ������� ����
		Set<MyDate> set = new HashSet<>();
		set.add(date1);
		set.add(date2);
		set.add(date3);
		
		//�ߺ��Ǿ ����� �ȴ�. hash���� ��ġ���� �ʱ� �����̴�.
		//hash ���� ���ϵ��� MyDate���� hash ���� �س��� �ߺ��� ���� ��µ��� �ʴ´�.
		set.forEach(date -> System.out.println(date));
		
		
	}

}
