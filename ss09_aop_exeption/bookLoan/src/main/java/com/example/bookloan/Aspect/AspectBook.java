package com.example.bookloan.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AspectBook {
    @After("execution(* com.example.controller.BookController.*(..))")
    public void loAfterMethodBookController(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        System.out.println(" Người truy cập phương thức "+nameMethod+" vào lúc "+ LocalDateTime.now());
    }
}
