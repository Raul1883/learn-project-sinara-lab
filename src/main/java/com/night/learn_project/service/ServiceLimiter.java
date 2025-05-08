package com.night.learn_project.service;

import com.night.learn_project.exceptions.TooManyRequestsException;
import io.github.bucket4j.Bucket;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Aspect
@Component
public class ServiceLimiter {
    @Value("${controller.max-calls}")
    private int callsLimiter;

    @Value("${controller.refill-calls}")
    private int callsLimiterRefill;


    private Bucket bucket;

    @PostConstruct
    public void initLimit() {
        bucket = Bucket
                .builder()
                .addLimit(limit -> limit
                        .capacity(callsLimiter)
                        .refillGreedy(callsLimiterRefill, Duration.ofMinutes(1)))
                .build();
    }


    @Pointcut("execution(* com.night.learn_project.service.MyService.*(..))")
    public void allServiceMethods() {
    }

    @Before("allServiceMethods()")
    public void handleCall(JoinPoint jp) {
        if (!bucket.tryConsume(1)) {
            throw new TooManyRequestsException();
        }
    }
}
