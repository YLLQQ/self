package annotation;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * annotation.CounterAnnotationMain
 *
 * @author eleven
 * @date 2019/04/19
 */
public class CounterAnnotationMain {
    public static void main(String[] args) throws Exception {
        //这里模拟了注解成员属性从常量池解析的过程
        Map<String, Object> values = new HashMap<>(8);
        values.put("count", 1);
        //生成代理类
        CounterAnnotation proxy = (CounterAnnotation) Proxy.newProxyInstance(CounterAnnotationMain.class.getClassLoader(),
                new Class[]{CounterAnnotation.class},
                new CounterAnnotationInvocationHandler(values, CounterAnnotation.class));
        System.out.println(proxy.count());
    }
}
