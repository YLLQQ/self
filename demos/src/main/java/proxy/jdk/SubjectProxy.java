package proxy.jdk;

import java.lang.reflect.Proxy;

public class SubjectProxy {

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    public Object getProxyInstance() {
        Class<? extends Subject> subjectClass = subject.getClass();


        Object object = Proxy.newProxyInstance(subjectClass.getClassLoader(), subjectClass.getInterfaces(), (proxy, method, args) -> {
            System.out.println("SubjectProxy is running");

            method.invoke(subject, args);

            return proxy;
        });

        return object;
    }
}
