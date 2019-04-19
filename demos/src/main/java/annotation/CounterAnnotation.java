package annotation;

import java.lang.annotation.Annotation;

/**
 * annotation.CounterAnnotation
 *
 * @author eleven
 * @date 2019/04/19
 */
public interface CounterAnnotation extends Annotation {
    int count();
}
