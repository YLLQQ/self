package self.yang.web.aops;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import self.yang.web.annos.DefineAnnotation;

import java.lang.reflect.Method;

/**
 * 参考来源
 * <p>
 * https://blog.csdn.net/Wetsion/article/details/80192202
 */
@Slf4j
@Aspect
@Component
public class DefineAspect {

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(self.yang.web.annos.DefineAnnotation)")
    public void definePointcut() {
    }

    /**
     * 前置增强，在切点方法执行之前执行
     *
     * @param defineAnnotation
     */
    @Before("definePointcut()&&@annotation(defineAnnotation)")
    public void beforePointcut(DefineAnnotation defineAnnotation) {
        if (log.isDebugEnabled()) {
            log.debug("before define annotation is {}", defineAnnotation);
        }
    }

    /**
     * 环绕增强
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around("definePointcut()&&@annotation(defineAnnotation)")
    public Object aroundPointcut(
            ProceedingJoinPoint proceedingJoinPoint,
            DefineAnnotation defineAnnotation
    ) {

        Object proceed = null;

        if (log.isDebugEnabled()) {
            log.debug("around define annotation value is {}", defineAnnotation);
        }

        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("call {} happen exceptions, ", proceedingJoinPoint.getSignature().toShortString(), throwable);
        }

        return proceed;
    }

    /**
     * 后置增强，切点方法正常执行完返回后执行，如果有异常抛出而退出，则不会执行增强方法
     *
     * @param joinPoint
     */
    @AfterReturning("definePointcut()")
    public void afterReturningPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        DefineAnnotation annotation = method.getAnnotation(DefineAnnotation.class);

        if (log.isDebugEnabled()) {
            log.debug("after returning define annotation value is {}", annotation.value());
        }
    }

    /**
     * 后置增强，只有切点方法异常抛出而退出后执行
     *
     * @param joinPoint
     */
    @AfterThrowing("definePointcut()")
    public void afterThrowingPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        DefineAnnotation annotation = method.getAnnotation(DefineAnnotation.class);

        if (log.isDebugEnabled()) {
            log.debug("after throwing define annotation value is {}", annotation.value());
        }
    }

    /**
     * 后置增强，但不管切点方法是正常退出还是异常退出都会执行
     *
     * @param joinPoint
     */
    @After("definePointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        DefineAnnotation annotation = method.getAnnotation(DefineAnnotation.class);

        if (log.isDebugEnabled()) {
            log.debug("after define annotation value is {}", annotation.value());
        }
    }

}
