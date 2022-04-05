public class SemaphoreCustom {

    int permits;
    public SemaphoreCustom(int permits) {
        this.permits = permits;
    }

    public synchronized void release() {
        permits++;
        if (permits>0) this.notifyAll();
    }

    public synchronized void acquire() throws InterruptedException {
        if (permits < 1) this.wait();
        permits--;
    }
}
