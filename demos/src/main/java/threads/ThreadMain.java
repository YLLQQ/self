package threads;

import java.util.concurrent.*;

public class ThreadMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 线程无响应值

        Thread1 thread1 = new ThreadMain().new Thread1();

        thread1.start();

        Thread thread2 = new Thread(new ThreadMain().new Thread2());

        thread2.start();

        new Thread(() ->
                System.out.println("runnable thread with lambda")
        ).start();

        // 线程有响应值

        Callable thread3 = new ThreadMain().new Thread3();

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future threadFuture = executorService.submit(thread3);

        System.out.println(threadFuture.get().toString());

        String threadResult = Executors.newCachedThreadPool().submit(() -> "callable thread return value").get();

        System.out.println(threadResult);
    }

    /**
     * 继承Thread类
     */
    class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("thread1 runs");
        }
    }

    /**
     * 实现Runnable接口
     */
    class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("thread2 runs");
        }
    }

    /**
     * 实现Callable接口
     */
    class Thread3 implements Callable {

        @Override
        public Object call() {
            return "thread3 has return value";
        }
    }
}
