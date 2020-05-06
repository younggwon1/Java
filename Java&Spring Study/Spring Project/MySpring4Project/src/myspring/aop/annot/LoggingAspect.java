package myspring.aop.annot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	protected static final Logger logger = LogManager.getLogger();
	
	//Before Advice ��ó�� �����̽�
    @Before("execution(public * myspring..*(..))")
	public void before(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();	
		if( logger.isDebugEnabled() ) {
			logger.debug(">>>> @Before [ " + signatureString + " ] �޼��� ���� ��ó�� ����");
		}
		for (Object arg : joinPoint.getArgs()) {
			logger.debug("@Before [ " + signatureString + " ] �ƱԸ�Ʈ " + arg);			
		}		
	}
    //��ó�� �����̽� : target�� �޼��尡 �������� �Ǿ������� �����
    @AfterReturning(pointcut="execution(public * myspring.user.service.*.*(..))", returning="ret")
	public void afterReturning(JoinPoint joinPoint, Object ret) {
		String signatureString = joinPoint.getSignature().getName();		
		logger.debug("@AfterReturing [ " + signatureString + " ] �޼��� ���� ��ó�� ����");
		logger.debug("@AfterReturing [ " + signatureString + " ] ���ϰ�=" + ret);

	}
    //��ó�� �����̽� : target�� �޼��尡 ������ �߻��Ǿ��� ���� �����
    @AfterThrowing(pointcut="execution(* *..UserService*.*(..))", 
    		throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();	
		logger.debug("@AfterThrowing [ " + signatureString + " ] �޼��� ���� �� ���� �߻�");
		logger.debug("@AfterThrowing [ " + signatureString + " ] ����=" + ex.getMessage());
	}
    //��ó�� �����̽� : target�� �޼����� ����/������ ������� ������ �����
    @After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		logger.debug("@After [ " + signatureString + " ] �޼��� ���� �Ϸ�");
	}
}
