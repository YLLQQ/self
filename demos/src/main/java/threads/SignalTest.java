package threads;

/**
 * 线程间通信
 */
public class SignalTest {

    public static void main(String[] args) {
        MySignal mySignal = new MySignal();

        // 线程持有相同引用
        new Thread(new SignalThread1(mySignal)).start();
        new Thread(new SignalThread1(mySignal)).start();
        new Thread(new SignalThread1(mySignal)).start();
        new Thread(new SignalThread1(mySignal)).start();
        new Thread(new SignalThread2(mySignal)).start();
        new Thread(new SignalThread2(mySignal)).start();

        // 线程持有不同引用
//        new Thread(new SignalThread1(new MySignal())).start();
//        new Thread(new SignalThread2(new MySignal())).start();
    }
}

class SignalThread1 implements Runnable {

    MySignal mySignal;

    public SignalThread1(MySignal mySignal) {
        this.mySignal = mySignal;
    }

    @Override
    public void run() {
        this.mySignal.setHasDataToProcess(true);
    }
}

class SignalThread2 implements Runnable {

    MySignal mySignal;

    public SignalThread2(MySignal mySignal) {
        this.mySignal = mySignal;
    }

    @Override
    public void run() {

        System.out.println(this.mySignal.hasDataToProcess());
    }
}
