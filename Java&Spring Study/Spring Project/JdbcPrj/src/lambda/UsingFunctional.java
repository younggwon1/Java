package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class UsingFunctional {
	public static void main(String[] args) {
//		List<String> list = new ArrayList<>();
//		list.add("java");
//		list.add("scalar");
//		list.add("python");
//		
//		for (String value : list) {
//			System.out.println(value);
//		}
//		
//		//Anonymous Inner Class
//		list.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String value) {
//				System.out.println(value);
//				
//			}
//		});
//		
//		//람다식으로 표현해보자
//		list.forEach(value -> System.out.println(value));
//		
//		//Method Reference
//		list.forEach(System.out::println);
//		
//		
//		List<Student> stuList = List.of(new Student(100,"홍길동"), new Student(200,"둘리"), new Student(300,"펭수")); 
//		
//		//Anonymous Inner Class
//		stuList.forEach(new Consumer<Student>() {
//			@Override
//			public void accept(Student stu) {
//				System.out.println(stu);
//				
//			}
//		});
//		
//		//람다식으로 표현해보자
//		stuList.forEach(stu -> System.out.println(stu));
//		
//		//Method Reference
//		stuList.forEach(System.out::println);
		
		List<Student> stuList2 = List.of(new Student(10,"자바"), new Student(20,"코틀린"), new Student(30,"스칼라"));
		
		//List -> Stream 변환
		//학생번호가 20보다 큰 학생이름을 List<String>으로 출력하세요.
		Stream<Student> stream = stuList2.stream();
		stuList2.stream()
			.filter(stu -> stu.getId() >= 20)
			.map(stu -> stu.getName())
			.forEach(stu -> System.out.println(stu));

	}
}


class Student{
	private int id;
	private String name;
	
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}