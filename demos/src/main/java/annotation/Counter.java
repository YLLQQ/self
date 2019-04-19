package annotation;

import java.lang.annotation.*;

/**
 * 参考连接：https://www.cnblogs.com/throwable/p/9747595.html
 * annotation.Counter
 *
 * @author eleven
 * @date 2019/04/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface Counter {

    int count() default 0;
}
