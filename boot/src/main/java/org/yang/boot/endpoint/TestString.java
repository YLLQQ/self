package org.yang.boot.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * org.yang.boot.endpoint.TestString
 *
 * @author eleven
 * @date 2019/09/17
 */
@RestController
public class TestString {

    @GetMapping("/test")
    public String testString() {
        return "成功";
    }
}
