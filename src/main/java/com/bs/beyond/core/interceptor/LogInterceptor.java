package com.bs.beyond.core.interceptor;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Log Interceptor
 * 
 */
@Aspect
@Component
public class LogInterceptor {

    private static Logger logger = Logger.getLogger(LogInterceptor.class);

    /**
     * Log Flag
     */
    private String BEFORE = "BEFORE";
    private String AFTER = "AFTER";
    private String AFTER_RETURNING = "AFTER_RETURNING";
    private String AFTER_TRHOWING = "AFTER_TRHOWING";

    /**
     * 
     * @Pointcut("execution(* com.bs.beyond.controller..*.*(..))")
     * @Pointcut("@annotation(com.bs.beyond.core.annotation.BLogger)")
     * 
     */
    @Pointcut("@annotation(com.bs.beyond.core.annotation.BLogger)")
    public void logger(){};

    /**
     * 
     * @param joinPoint
     */
    @Before("logger()")
    public void before(JoinPoint joinPoint)
    {
        String sLog = this.getLog(this.BEFORE, joinPoint);
        logger.info(sLog);
    }

    /**
     * 
     * @param joinPoint
     */
    @After("logger()")
    public void after(JoinPoint joinPoint)
    {
        String sLog = this.getLog(this.AFTER, joinPoint);
        logger.info(sLog);
    }

    /**
     * 
     * @param joinPoint
     */
    @AfterReturning("logger()")
    public void afterReturning(JoinPoint joinPoint)
    {
        String sLog = this.getLog(this.AFTER_RETURNING, joinPoint);
        logger.info(sLog);
    }

    /**
     * 
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut="logger()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex)
    {
        String sLog = this.getLog(this.AFTER_TRHOWING, joinPoint, ex);
        logger.error(sLog);
    }

    /**
     * 
     * @param joinPoint
     * @return Object
     */
    /**
    @Around("logger()")
    public Object authorAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        String sClassName = joinPoint.getThis().toString();
        String sMethodName = joinPoint.getSignature().getName();

        logger.info("Around : " + sClassName + " Method : " + sMethodName);
        Object[] args = joinPoint.getArgs();
        Object obj = null;

        // Condition
        if (true)
        {
            obj = joinPoint.proceed(args);
        }

        logger.info("Around End : " + sClassName + " Method : " + sMethodName);

        return obj;
    }
    */

    /**
     * 
     * @param sLogFlag
     * @param joinPoint
     * @return
     */
    private String getLog(
        String sLogFlag,
        JoinPoint joinPoint)
    {
        return this.getLog(sLogFlag, joinPoint, null);
    }

    /**
     * 
     * @param sLogFlag
     * @param joinPoint
     * @param ex
     * @return
     */
    private String getLog(
        String sLogFlag,
        JoinPoint joinPoint,
        Throwable ex)
    {
        String sClassName = joinPoint.getThis().toString();
        String sMethodName = joinPoint.getSignature().getName();

        StringBuilder sLog = new StringBuilder();
        sLog.append(sLogFlag);
        sLog.append(" : ");
        sLog.append(sClassName);
        sLog.append(" : ");
        sLog.append(sMethodName);

        if (ex != null)
        {
            sLog.append("Exception Message : ");
            sLog.append(ex.getMessage());
        }

        return sLog.toString();
    }
}
