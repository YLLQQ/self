package self.yang.web.env;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.time.Clock;
import java.time.Instant;

/**
 * self.yang.web.env.DefineEnvListener
 *
 * @author eleven
 * @date 2019/03/20
 */
@Slf4j
public class DefineEnvListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        //current application event is class org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent at 2019-03-20T07:44:45.459Z
        //current application event is class org.springframework.boot.context.event.ApplicationContextInitializedEvent at 2019-03-20T07:44:45.585Z
        //current application event is class org.springframework.boot.context.event.ApplicationPreparedEvent at 2019-03-20T07:44:45.643Z
        //current application event is class org.springframework.context.event.ContextRefreshedEvent at 2019-03-20T07:44:49.190Z
        //current application event is class org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent at 2019-03-20T07:44:49.238Z
        //current application event is class org.springframework.boot.context.event.ApplicationStartedEvent at 2019-03-20T07:44:49.244Z
        //current application event is class org.springframework.boot.context.event.ApplicationReadyEvent at 2019-03-20T07:44:49.246Z
        log.error("current application event is {} at {}", applicationEvent.getClass(), Instant.now(Clock.systemDefaultZone()).toString());
    }
}
