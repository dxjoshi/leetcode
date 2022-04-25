import java.util.concurrent.Semaphore;

public class IterativeMultipleArraysConcurrently {
//    arr1 = [1, 4, 7, 10]
//    arr2 = [2, 5, 8, 11]
//    arr3 = [3, 6, 9, 12]
//    3 threads operate on these 3 arrays. Print sequential output : 1,2,3,4, 5 , 6 , 7.....
    Thread t1,t2,t3;

    public IterativeMultipleArraysConcurrently(Thread t1, Thread t2, Thread t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public void print() {
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);

        int[] arr = new int[]{1,4,7,10};
        R1 r1 = new R1(arr, 0, s1, s2);
        Thread t1 = new Thread(r1);

        int[] arr2 = new int[]{2, 5, 8, 11};
        R1 r2 = new R1(arr2, 0, s2, s3);
        Thread t2 = new Thread(r2);

        int[] arr3 = new int[]{3, 6, 9, 12};
        R1 r3 = new R1(arr3, 0, s3, s1);
        Thread t3 = new Thread(r3);

        IterativeMultipleArraysConcurrently driver = new IterativeMultipleArraysConcurrently(t1, t2, t3);
        driver.print();;
    }

    static class R1 implements Runnable {

        int[] arr;
        int itr;
        Semaphore s1,s2,s3;

        public R1(int[] arr, int itr, Semaphore s1, Semaphore s2) {
            this.arr = arr;
            this.itr = itr;
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public void run() {
            while(itr < arr.length) {
                try {
                    s1.acquire();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + "is interupted");
                }
                System.out.println(Thread.currentThread().getName() +" - " + arr[itr++]);
                s2.release();
            }
        }
    }

}
