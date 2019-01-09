package threads;

public class MySignal {

    protected boolean hasDataToProcess = false;

    public synchronized boolean hasDataToProcess() {
        return hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
