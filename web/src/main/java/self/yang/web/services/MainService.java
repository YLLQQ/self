package self.yang.web.services;

import org.springframework.stereotype.Service;

import static self.yang.web.asserts.DefineAssert.checkNotNull;

/**
 * self.yang.web.services.MainService
 *
 * @author eleven
 * @date 2019/03/20
 */
@Service
public class MainService {

    /**
     * 测试前置条件
     *
     * @param o
     * @return
     */
    public boolean getTrueOrFalse(Object o) {
        checkNotNull(o);

        return true;
    }
}
