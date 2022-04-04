import java.util.LinkedList;
import java.util.List;

class Producer2 implements Runnable {
    private List<Integer> sharedQueue;
    private int maxSize=2;

    public Producer2(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {  //produce 10 products.
            try {
                produce(i);
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (sharedQueue) {
            while (sharedQueue.size() == maxSize) {
                sharedQueue.wait();
            }
        }

        synchronized (sharedQueue) {
            sharedQueue.add(i);
            Thread.sleep((long)(Math.random() * 1000));
            sharedQueue.notify();
        }
    }
}

class Consumer2 implements Runnable {
    private List<Integer> sharedQueue;
    public Consumer2(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
                Thread.sleep(100);
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (sharedQueue) {
            while (sharedQueue.size() == 0) {
                sharedQueue.wait();
            }
        }

        synchronized (sharedQueue) {
            Thread.sleep((long)(Math.random() * 2000));
            System.out.println("CONSUMED : "+ sharedQueue.remove(0));
            sharedQueue.notify();
        }
    }
}

public class ProducerConsumerWaitNotify {

    public static void main(String args[]) {
        List<Integer> sharedQueue = new LinkedList<>();

        Producer2 producer= new Producer2(sharedQueue);
        Consumer2 consumer= new Consumer2(sharedQueue);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();
    }
}