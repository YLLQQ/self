package org.yang.boot.annotation;

import java.lang.annotation.*;

/**
 * org.yang.boot.annotation.MyBean
 *
 * @author eleven
 * @date 2019/09/06
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyBean {
}
