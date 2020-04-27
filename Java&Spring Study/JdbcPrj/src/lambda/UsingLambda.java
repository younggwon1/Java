package lambda;

public class UsingLambda {
	public static void main(String[] args) {
		//1. Thread 생성 
		Thread t1 = new Thread(new MyRunnable());
		t1.setName("둘리");
		t1.start();
		
		//2. Anonymous Inner Class 익명 클래스 형태로
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		t2.setName("길동");
		t2.start();
		
		
		//3. Lambda 식 형태로
		//추상메서드가 1개이어야한다. 그 이유는 메서드를 표시하지 않는데 1개 이상이면 어떤걸 오버라이딩하는지 모르기 때문이다.
		Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		t3.setName("자바");
		t3.start();
	}
}

//1.
class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
