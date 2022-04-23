import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintInOrder {
// https://leetcode.com/problems/print-in-order/discuss/893827/Java-SynchronizedLockSemaphoreCondition-Variable
// https://leetcode.com/problems/print-in-order/discuss/332890/Java-Basic-semaphore-solution-8ms-36MB

    Semaphore one, two;
    Thread t1, t2, t3;

    public PrintInOrder(Semaphore one, Semaphore two) {
        this.one = one;
        this.two = two;
        t1 = new Thread(new PrintOne(one, two));
        t2 = new Thread(new PrintTwo(one, two));
        t3 = new Thread(new PrintThree(one, two));
    }

    public void print() {
        t2.start();
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        t3.start();
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        t1.start();
    }

    class PrintOne implements Runnable {
        Semaphore one, two;

        public PrintOne(Semaphore one, Semaphore two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " One");
            one.release();
        }
    }

    class PrintTwo implements Runnable {
        Semaphore one, two;

        public PrintTwo(Semaphore one, Semaphore two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public void run() {
            try { one.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " Two");
            two.release();
        }
    }

    class PrintThree implements Runnable {
        Semaphore one, two;

        public PrintThree(Semaphore one, Semaphore two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public void run() {
            try { two.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " Three");

        }
    }

    public static void main(String[] args) {
        Semaphore one = new Semaphore(0);
        Semaphore two = new Semaphore(0);

        PrintInOrder driver = new PrintInOrder(one, two);
        driver.print();
    }
}