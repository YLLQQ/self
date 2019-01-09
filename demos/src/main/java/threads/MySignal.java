package threads;

public class MySignal {

    protected boolean hasDataToProcess = false;

    public synchronized boolean hasDataToProcess() {
        return hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        if (this.hasDataToProcess) {
            System.out.println("hasDataToProcess is true");

            return;
        }

        this.hasDataToProcess = hasDataToProcess;
    }
}
