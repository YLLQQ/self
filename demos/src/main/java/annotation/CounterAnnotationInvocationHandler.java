package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * annotation.CounterAnnotationInvocationHandler
 *
 * @author eleven
 * @date 2019/04/19
 */
public class CounterAnnotationInvocationHandler implements InvocationHandler {

    private final Map<String, Object> memberValues;
    private final Class<? extends Annotation> clazz;

    public CounterAnnotationInvocationHandler(Map<String, Object> memberValues, Class<? extends Annotation> clazz) {
        this.memberValues = memberValues;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object value;
        switch (methodName) {
            case "toString":
                value = super.toString();
                break;
            case "hashCode":
                value = super.hashCode();
                break;
            case "equals":
                value = super.equals(args[0]);
                break;
            case "annotationType":
                value = clazz;
                break;
            default:
                value = memberValues.get(methodName);
        }
        return value;
    }
}
