class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CustomThreadPoolTest {
    public static void main(String[] args) throws Exception {
        CustomThreadPool threadPool = new CustomThreadPool(2); //create 2 threads in ThreadPool
        Runnable task = new Task();
        threadPool.execute(task);
        threadPool.execute(task);

        threadPool.shutdown();
    }
}
