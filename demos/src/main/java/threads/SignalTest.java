package threads;

/**
 * 线程间通信
 */
public class SignalTest {

    public static void main(String[] args) {
        MySignal mySignal = new MySignal();

        new Thread(new SignalThread1(mySignal)).start();

        new Thread(new SignalThread3(mySignal)).start();

    }
}

class SignalThread3 implements Runnable {

    MySignal mySignal;

    public SignalThread3(MySignal mySignal) {
        this.mySignal = mySignal;
    }

    @Override
    public void run() {

        while (this.mySignal.hasDataToProcess) {
            System.out.println(String.format("%s cannot get signal", Thread.currentThread().getId()));
        }

        System.out.println(String.format("%s get signal", Thread.currentThread().getId()));
    }
}

class SignalThread1 implements Runnable {

    MySignal mySignal;

    public SignalThread1(MySignal mySignal) {
        this.mySignal = mySignal;
    }

    @Override
    public void run() {
        this.mySignal.setHasDataToProcess(!this.mySignal.hasDataToProcess);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.mySignal.setHasDataToProcess(!this.mySignal.hasDataToProcess);
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


