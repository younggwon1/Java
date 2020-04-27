package lambda;

public class UsingLambda {
	public static void main(String[] args) {
		//1. Thread ���� 
		Thread t1 = new Thread(new MyRunnable());
		t1.setName("�Ѹ�");
		t1.start();
		
		//2. Anonymous Inner Class �͸� Ŭ���� ���·�
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		t2.setName("�浿");
		t2.start();
		
		
		//3. Lambda �� ���·�
		//�߻�޼��尡 1���̾���Ѵ�. �� ������ �޼��带 ǥ������ �ʴµ� 1�� �̻��̸� ��� �������̵��ϴ��� �𸣱� �����̴�.
		Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		t3.setName("�ڹ�");
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
