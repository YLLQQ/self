package proxy.jdk;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        /**
         * 把生成的代理类Class文件保存在本地磁盘上
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = new SubjectImpl();

        /**
         * newProxyInstance方法执行了以下几种操作。
         *
         * 1.生成一个实现了参数interfaces里所有接口且继承了Proxy的代理类的字节码，然后用参数里的classLoader加载这个代理类。
         *
         * 2.使用代理类父类的构造函数 Proxy(InvocationHandler h)来创造一个代理类的实例，将我们自定义的InvocationHandler的子类传入。
         *
         * 3.返回这个代理类实例。
         *
         */
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                new SubjectInvocationHandler(subject));

        subjectProxy.start();
        subjectProxy.end();

        subjectProxy = (Subject) new SubjectProxy(subject).getProxyInstance();

        subjectProxy.start();
        subjectProxy.end();
    }
}
