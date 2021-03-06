package proxy.jdk;

import java.lang.reflect.Proxy;

public class Test {

    /**
     * JDK动态代理机制只能代理实现接口的类，一般没有实现接口的类不能进行代理。cglib就是针对类来实现代理的，它
     * 的原理是对指定目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进
     * 行代理。使用cglib实现动态代理，完全不受代理类必须实现接口的限制，而且cglib底层采用ASM字节码生成框架，使用字节码
     * 技术生成代理类，比使用java反射效率要高。需要引入两个jar包：cglib.jar，asm.jar
     * 定义了一个拦截器，在调用目标方法之前，cglib回调MethodInterceptor接口方法拦截，来实现自己的业务逻辑，类似
     * 于JDK中的InvocationHandler接口。
     *
     * @param args
     */
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

        subjectProxy = new SubjectInvocationHandler(subject).getInstance();

        subjectProxy.start();
        subjectProxy.end();

        subjectProxy = (Subject) new SubjectProxy(subject).getProxyInstance();

        subjectProxy.start();
        subjectProxy.end();
    }
}
