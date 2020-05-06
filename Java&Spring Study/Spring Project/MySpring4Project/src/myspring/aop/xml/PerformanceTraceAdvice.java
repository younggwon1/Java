package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;

//�����̽� Ÿ�� : Around Advice
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�� �޼����� signature ����
		String targetMethodName = joinPoint.getSignature().getName();		
		System.out.println(targetMethodName + " ����");
		
		//Ÿ�� �޼����� Argument ����
		for(Object arg : joinPoint.getArgs()) {
			System.out.println(targetMethodName + "�� �ƱԸ�Ʈ : " + arg);
		}
		
		//Ÿ���� �޼��尡 ȣ��Ǳ� ���� �ð� 
		long start = System.currentTimeMillis();
		
		try {
			//new Object[] {new String("dooly")}
			//intercepted�� Ÿ���� �޼��带 ȣ���� �־���Ѵ�.
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//Ÿ���� �޼��尡 ȣ��� ���� �ð�
			long finish = System.currentTimeMillis();
			System.out.println(targetMethodName + " ����");
			System.out.println(targetMethodName + " ���� �ð� : " + 
			   (finish - start) + " ms");
		}
	}
}
