package proxy.jdk;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();

        Subject subjectProxy = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                new SubjectInvocationHandler(subject));

        subjectProxy.start();
        subjectProxy.end();
    }
}
