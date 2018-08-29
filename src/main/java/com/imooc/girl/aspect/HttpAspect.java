package com.imooc.girl.aspect;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//    @Before("execution(public * com.imooc.girl.controller.GirlController.girlList(..))")
    @Before("execution(public * com.imooc.girl.controller.GirlController.*(..))") //所有的方法
    public void log(){
        System.out.println("23232323232");
    }

//    @After

    @Pointcut("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void poCut(){
        System.out.println("这是定义了一个可重用的切点标注方法");
    }

    @Before("poCut()") //使用PointCut标注的方法
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}", request.getRequestURL());

        logger.info("method={}", request.getMethod());

        logger.info("ip={}", request.getRemoteAddr());

        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        logger.info("param={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "object", pointcut = "poCut()")
    public void aoAfterReturning(Object object){
        logger.info("response={}", object);
    }
}
