package com.sfu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimesAop {

    private static Logger log = LoggerFactory.getLogger(TimesAop.class);

    @Pointcut("execution(* com.sfu.service.Impl.*.select*(..))")
    public void point(){}

    @Around("point()")
    public Object  around(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        log.info("查询方法"+methodName+"开始执行");
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        log.info("查询方法"+methodName+"结束，耗时"+(endTime-startTime)+"ms");
        return proceed;
    }
}
