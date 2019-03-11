package proxy.cglib;

public class Test {

    public static void main(String[] args) {
        Subject subjectProxy = SubjectCglibProxy.getProxyFactory(Subject.class);

        subjectProxy.start();
    }
}
