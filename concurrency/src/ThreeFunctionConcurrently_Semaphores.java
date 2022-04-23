import java.util.concurrent.Semaphore;

public class ThreeFunctionConcurrently_Semaphores implements Runnable{

    Semaphore s1;
    Semaphore s2;

    public ThreeFunctionConcurrently_Semaphores(Semaphore s1, Semaphore s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    private void methodThree() {
        try {
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " in method Two");
    }

    private void methodOne() {
        System.out.println(Thread.currentThread().getName() + " in method One");
        s1.release();
    }

    private void methodTwo() {
        try {
            s1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " in method Three");
        s2.release();
    }

    @Override
    public void run() {
        methodOne();
        methodTwo();
        methodThree();
    }

    public static void main(String[] args) {
        Semaphore lockOne = new Semaphore(0);
        Semaphore lockTwo = new Semaphore(0);

        ThreeFunctionConcurrently_Semaphores object = new ThreeFunctionConcurrently_Semaphores(lockOne, lockTwo);

        new Thread(object).start();
        new Thread(object).start();
        new Thread(object).start();
    }

}
