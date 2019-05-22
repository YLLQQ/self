package self.yang.web.strategy;

import java.lang.annotation.*;

/**
 * self.yang.web.strategy.HandlerType
 *
 * @author eleven
 * @date 2019/05/22
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {
    String value();
}
