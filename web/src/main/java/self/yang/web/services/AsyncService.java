package self.yang.web.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * self.yang.web.services.AsyncService
 *
 * @author eleven
 * @date 2019/07/04
 */
@Service
@Slf4j
public class AsyncService {

    @Async
    public void asyncMethod() {
        log.debug("call async method thread id is {}", Thread.currentThread().getId());
    }

    public void syncMethod() {
        log.debug("call sync method thread id is {}", Thread.currentThread().getId());
    }
}
