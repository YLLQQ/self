package threads;

public class ThreadTest {

    public static void main(String[] args) {

        Model model = new Model();

        for (int i = 0; i < 200; i++) {
            new Thread(new RunnableThread(model)).start();
        }


    }

}

class RunnableThread implements Runnable {

    private Model model;

    public RunnableThread(Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String value = this.model.getValue();

            System.out.println(String.format("%d get %s", Thread.currentThread().getId(), value.length()));
        }
    }
}


class Model {

    StringBuilder stringBuilder = new StringBuilder();

    public String getValue() {
        return this.stringBuilder.append("1").toString();
    }
}
