package com.web.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class CheckNameAop {
	
	@Pointcut("@annotation(com.web.study.aop.annotation.CheckNameAspect)")
	private void annotationPointCut() {}
	
	@Around("annotationPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object logic = joinPoint.proceed();
		
		stopWatch.stop();
		
		log.info("[ name ] >>> {}",
				joinPoint.getSignature().toShortString());
		
		return logic;
	}

}
