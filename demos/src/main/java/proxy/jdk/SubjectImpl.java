package proxy.jdk;

public class SubjectImpl implements Subject {
    @Override
    public void start() {
        System.out.println("this method is start");
    }

    @Override
    public void end() {
        System.out.println("this method is end");
    }
}
