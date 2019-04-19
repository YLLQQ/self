package annotation;

import java.lang.annotation.*;

/**
 * annotation.ColumnName
 *
 * @author eleven
 * @date 2019/04/19
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnName {
    String value();
}
