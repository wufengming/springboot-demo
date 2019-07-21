package com.example.springboot.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author wfm
 * @title: LogAspect
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/2014:02
 */
@Aspect
@Order(1)
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 层切点,注解方式
     * 1) execution(): 表达式主体
     * 2) 第一个public *号：表示返回类型， *号表示所有的类型。
     * 3) 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.king.controller包、子孙包下所有类的方法。
     * 4) 第二个*号：表示类名，*号表示所有的类。
     * 5) *(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(public * com.example.springboot.controller..*.*(..))")
    public void poincut(){}


    @Before("poincut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求内容");
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("URL:" + request.getRequestURL().toString());
        logger.info("HTTP_METHOD:" + request.getMethod());
        logger.info("CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS:" + Arrays.toString(joinPoint.getArgs()));

        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:{},value:{}", name, request.getParameter(name));
        }

    }

    @AfterReturning(pointcut = "poincut()", returning = "response")
    public void doAfterReturning(Object response){
        // 处理完请求，返回内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("处理完请求，返回内容");
        logger.info("IP:" + request.getRemoteAddr());
        logger.info("SPEND Time:" + (System.currentTimeMillis() - startTime.get())+" ms");
        logger.info("RESPONSE:" + response);
    }
}
