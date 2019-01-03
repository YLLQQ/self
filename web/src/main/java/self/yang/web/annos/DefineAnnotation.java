package self.yang.web.annos;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DefineAnnotation {

    String value() default "default";
}
