package threads;

import lombok.Data;
import lombok.Getter;

public class SafeThread {

    public static void main(String[] args) {
        NotThreadSafe notThreadSafe = new SafeThread().new NotThreadSafe();

        new Thread(new SafeThread().new TestRunnable(notThreadSafe)).start();
        new Thread(new SafeThread().new TestRunnable(notThreadSafe)).start();

        new Thread(new SafeThread().new TestRunnable(new SafeThread().new NotThreadSafe())).start();
        new Thread(new SafeThread().new TestRunnable(new SafeThread().new NotThreadSafe())).start();

    }

    public void method1() {
        LocalObject localObject = new LocalObject();

        method2(localObject);
    }

    public void method2(LocalObject localObject) {
        localObject.setValue("method2");
    }

    public void doSomething() {
        long threadSafeLong = 0L;

        threadSafeLong++;
    }

    @Getter
    class ImmutableValue {
        private int value;

        public ImmutableValue(int value) {
            this.value = value;
        }

        public ImmutableValue add(int valueToAdd) {
            return new ImmutableValue(this.value + valueToAdd);
        }

    }

    class TestRunnable implements Runnable {
        NotThreadSafe notThreadSafe;

        public TestRunnable(NotThreadSafe notThreadSafe) {
            this.notThreadSafe = notThreadSafe;
        }

        @Override
        public void run() {
            this.notThreadSafe.append("test");
        }
    }

    class NotThreadSafe {
        StringBuilder stringBuilder = new StringBuilder();

        public void append(String string) {
            this.stringBuilder.append(string);

            System.out.println(this.stringBuilder.toString());
        }
    }

    @Data
    class LocalObject {
        private String value;
    }

}
