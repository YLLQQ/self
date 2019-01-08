package self.yang.web.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 项目启动生命周期
 */
@Slf4j
public class SelfApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (log.isDebugEnabled()) {
            log.debug("current event is {}", applicationEvent.getClass());
        }
    }
}
