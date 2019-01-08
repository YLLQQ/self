package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 12; i++) {
            executorService.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getId());

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }));
        }

        executorService.shutdown();
    }
}
