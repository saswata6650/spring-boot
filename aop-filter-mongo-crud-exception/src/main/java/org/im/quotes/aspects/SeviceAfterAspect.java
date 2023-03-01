package org.im.quotes.aspects;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class SeviceAfterAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* org.im.quotes.srevice.*.*(..))")
	public void getNameReturningAdvice(JoinPoint joinPoint){
		 String data = "InPut Arrive at " +new Date().toString()+ " Iputs are Passed=" + Arrays.toString(joinPoint.getArgs()) ;
		 logger.info(data);
		System.out.println("InPut Arrive at " +new Date().toString()+ " Iputs are Passed=" + Arrays.toString(joinPoint.getArgs())  );
    }
	
	@AfterReturning(value ="execution(* org.im.quotes.srevice.*.*(..))",returning = "result")
	 public void afterReturning(JoinPoint joinPoint, Object result){
		String data = "Out Put Generated at " +new Date().toString() + result;
		logger.info(data);
		System.out.println("getNameReturningAdvice executed. Returned String="+result);
	}
}
