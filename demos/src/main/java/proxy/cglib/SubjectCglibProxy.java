package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SubjectCglibProxy implements MethodInterceptor {

    public static Subject getProxyFactory(Class cl) {
        SubjectCglibProxy subjectCglibProxy = new SubjectCglibProxy();

        //Enhancer类是cglib中的一个字节码增强器，它可以方便的为你所要处理的类进行扩展
        Enhancer enhancer = new Enhancer();

        //将目标对象所在的类作为Enhancer类的父类
        enhancer.setSuperclass(cl);
        //通过实现MethodInterceptor实现方法回
        enhancer.setCallback(subjectCglibProxy);

        //生成目标对象并返回
        return (Subject) enhancer.create();

    }

    @Override
    public Object intercept(
            Object o,
            Method method,
            Object[] objects,
            MethodProxy methodProxy
    ) throws Throwable {
        Object retValFromSuper = null;

        try {
            if (!Modifier.isAbstract(method.getModifiers())) {
                retValFromSuper = methodProxy.invokeSuper(o, objects);
            }
        } finally {

        }

        return retValFromSuper;
    }
}
