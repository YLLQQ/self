package self.yang.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import self.yang.web.services.MainService;

/**
 * self.yang.web.controller.MainController
 *
 * @author eleven
 * @date 2019/03/20
 */
@RestController
public class MainController {

    @Autowired
    private MainService mainService;

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
}
