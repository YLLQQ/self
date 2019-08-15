package org.yang.undertow.web.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * org.yang.undertow.web.endpoint.IndexController
 *
 * @author eleven
 * @date 2019/08/15
 */
@RestController
public class IndexController {

    @GetMapping("index")
    public String index() {
        return "success";
    }
}
