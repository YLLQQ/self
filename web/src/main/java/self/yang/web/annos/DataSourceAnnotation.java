package self.yang.web.annos;

import self.yang.web.enums.DataSourceEnum;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceAnnotation {

    DataSourceEnum dataSource() default DataSourceEnum.MAIN;
}
