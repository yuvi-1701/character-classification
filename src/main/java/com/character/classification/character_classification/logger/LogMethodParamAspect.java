package com.character.classification.character_classification.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodParamAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogMethodParamAspect.class);

    @Before("@annotation(LogMethodParam)")
    public void logMethodParams(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        logger.info("Method called: {}", methodName);
        for(Object obj : methodArgs){
            logger.info("Parameter: {}", obj);
        }
    }
}
