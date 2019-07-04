package self.yang.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import self.yang.web.services.AsyncService;
import self.yang.web.services.MainService;

/**
 * self.yang.web.controller.MainController
 *
 * @author eleven
 * @date 2019/03/20
 */
@Slf4j
@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @Autowired
    private AsyncService asyncService;

    /**
     * 主接口测试
     *
     * @param temp
     * @return
     */
    @PostMapping("/main/mainApi")
    public boolean mainApi(@RequestBody String temp) {
        return mainService.getTrueOrFalse(temp);
    }

    /**
     * 测试异步调用
     */
    @GetMapping("/async/test")
    public void test() {
        log.debug("main thread thread id is {}", Thread.currentThread().getId());

        asyncService.asyncMethod();

        log.debug("main thread thread id is {}", Thread.currentThread().getId());

        asyncService.syncMethod();

        log.debug("main thread thread id is {}", Thread.currentThread().getId());
    }

}
