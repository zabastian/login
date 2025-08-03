package com.example.demo.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 이 클래스가 AOP 클래스임을 명시
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("@annotation(com.example.demo.aop.TrackTime)") // AOP 적용 대상 메서드를 지정
    private void trackTimeAnnotation() {
    }

    @Around("trackTimeAnnotation()") // 포인트컷 trackTimeAnnotation()을 대상으로 함
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed(); // 실제 메서드를 실행
            log.info("실제 메서드 {}", result);
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        finally {
            long endTime = System.currentTimeMillis();;
            long duration = endTime - startTime;
            log.info("ExecutionTime is {}ms", duration);
        }

    }
}
