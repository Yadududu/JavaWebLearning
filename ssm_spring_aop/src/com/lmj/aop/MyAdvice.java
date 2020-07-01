package com.lmj.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 自定义通知类
 */
public class MyAdvice {

	//before 前置通知 在目标方法前调用
	public void before() {
		System.out.println("before");
	}
	
	//after 最终通知（后置通知）在目标方法后调用，无论是否出现异常都会执行 finally
	public void after() {
		System.out.println("after");
	}
	
	//afterReturning 成功通知（后置通知）在目标方法执行后，并且执行成功，如果方法出现异常则不调用
	public void afterReturning() {
		System.out.println("afterReturning");
	}
	
	//afterThrowing 异常通知（后置通知）在目标方法执行出现异常的时候才会调用
	public void afterThrowing() {
		System.out.println("afterThrowing");
	}
	
	//around 环绕通知 需要我们手动调用目标方法，并且可以设置通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before");
		Object proceed = pjp.proceed();
		System.out.println("around after");
		return proceed;
	}
}
