import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

    private BlockingQueue<Runnable> taskQueue;
    private boolean poolShutDownInitiated = false;

    public CustomThreadPool(int nThreads){
        taskQueue = new LinkedBlockingQueue<>(nThreads);

        for(int i=1; i<=nThreads; i++){
            ThreadPoolsThread threadPoolsThread=new ThreadPoolsThread(taskQueue,this);
            threadPoolsThread.setName("Thread-"+i);
            threadPoolsThread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.poolShutDownInitiated)
            throw new Exception("ThreadPool has been shutDown, no further tasks can be added");

        this.taskQueue.put(task);
    }

    public boolean isPoolShutDownInitiated() {
        return poolShutDownInitiated;
    }

    public synchronized void shutdown(){
        this.poolShutDownInitiated = true;
        System.out.println("ThreadPool SHUTDOWN initiated.");
    }
}

class ThreadPoolsThread extends Thread {

    private BlockingQueue<Runnable> taskQueue;
    private CustomThreadPool threadPool;

    public ThreadPoolsThread(BlockingQueue<Runnable> queue, CustomThreadPool threadPool){
        taskQueue = queue;
        this.threadPool=threadPool;
    }

    public void run() {
        try {
            while (true) {
                Runnable runnable = taskQueue.take();
                runnable.run();
                if(this.threadPool.isPoolShutDownInitiated() &&  this.taskQueue.size()==0){
                    this.interrupt();
                    Thread.sleep(1);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
        }
    }
}