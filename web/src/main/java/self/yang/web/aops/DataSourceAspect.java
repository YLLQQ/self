package self.yang.web.aops;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import self.yang.web.annos.DataSourceAnnotation;
import self.yang.web.config.DynamicDataSourceConfig;
import self.yang.web.enums.DataSourceEnum;

@Slf4j
@Aspect
@Component
public class DataSourceAspect {

    @Around("dataSourcePointcut()&&@annotation(dataSourceAnnotation)")
    public Object aroundPointcut(
            ProceedingJoinPoint pjp,
            DataSourceAnnotation dataSourceAnnotation
    ) {
        DataSourceEnum dataSourceEnum = dataSourceAnnotation.dataSource();

        if (log.isDebugEnabled()) {
            log.debug("visit {} and data source type is {}", pjp.getSignature().toShortString(), dataSourceEnum);
        }

        DynamicDataSourceConfig.setDataSourceKey(dataSourceEnum);

        Object proceed = null;

        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            log.error("switch data source happen exception, error message is ", throwable);
        } finally {
            DynamicDataSourceConfig.setDataSourceKey(DataSourceEnum.MAIN);
        }

        return proceed;
    }

    @Pointcut("@annotation(self.yang.web.annos.DataSourceAnnotation)")
    public void dataSourcePointcut() {
    }
}
