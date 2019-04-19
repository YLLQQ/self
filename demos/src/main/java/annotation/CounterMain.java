package annotation;

/**
 * 参考连接：https://www.cnblogs.com/throwable/p/9747595.html
 * annotation.CounterMain
 *
 * @author eleven
 * @date 2019/04/19
 */
@Counter
public class CounterMain {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Counter counter = CounterMain.class.getAnnotation(Counter.class);
        System.out.println(counter.count());
    }
}
