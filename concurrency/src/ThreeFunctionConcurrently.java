import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeFunctionConcurrently implements Runnable{

    Lock lockOne;
    Lock lockTwo;

    public ThreeFunctionConcurrently(Lock lockOne, Lock lockTwo) {
        this.lockOne = lockOne;
        this.lockTwo = lockTwo;
    }

    public static void main(String[] args) {
        Lock lockOne = new ReentrantLock();
        Lock lockTwo = new ReentrantLock();

        ThreeFunctionConcurrently object = new ThreeFunctionConcurrently(lockOne, lockTwo);

        new Thread(object).start();
        new Thread(object).start();
        new Thread(object).start();
    }

    private static void methodTwo() {
        System.out.println(Thread.currentThread().getName() + " in method Two");
    }

    private static void methodOne() {
        System.out.println(Thread.currentThread().getName() + " in method One");
    }

    private static void methodThree() {
        System.out.println(Thread.currentThread().getName() + " in method Three");
    }

    @Override
    public void run() {

        if(lockOne.tryLock())
        {
            methodOne();
        }
        else
        {
            if (lockTwo.tryLock())
            {
                methodTwo();
            }
            else
            {
                methodThree();
            }
        }
    }
}
