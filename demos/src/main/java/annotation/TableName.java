package annotation;

import java.lang.annotation.*;

/**
 * annotation.TableName
 *
 * @author eleven
 * @date 2019/04/19
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableName {

    String value();
}
