import java.util.concurrent.Semaphore;

public class PrintZeroEvenOdd {
    static class OddEven {
        Semaphore zero = new Semaphore(1);
        Semaphore odd = new Semaphore(0);
        Semaphore even = new Semaphore(0);
        Thread zeroThread, evenThread, oddThread;
        int num;

        public OddEven(int num) {
            this.zeroThread = new Thread(new PrintZero(zero, odd, even, num));
            this.evenThread = new Thread(new PrintEven(zero, odd, even, num));
            this.oddThread = new Thread(new PrintOdd(zero, odd, even, num));
            this.num = num;
        }

        public void print() {
            zeroThread.start();
            oddThread.start();
            evenThread.start();
        }
    }

    static class PrintZero implements Runnable {
        int num;
        Semaphore zero, odd, even;

        public PrintZero(Semaphore zero, Semaphore odd, Semaphore even, int n) {
            num = n;
            this.zero = zero;
            this.odd = odd;
            this.even = even;
        }

        @Override
        public void run() {
            for (int i = 1; i <= num ; i++) {
                try {
                    zero.acquire();
                    System.out.println(String.format("%s -> %s", Thread.currentThread().getName(), 0));
                    if (i%2 == 0) {
                        even.release();
                    } else {
                        odd.release();
                    }
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class PrintOdd implements Runnable {
        int num;
        Semaphore zero, odd, even;

        public PrintOdd(Semaphore zero, Semaphore odd, Semaphore even, int n) {
            num = n;
            this.zero = zero;
            this.odd = odd;
            this.even = even;
        }

        @Override
        public void run() {
            for (int i = 1; i <= num ; i+= 2) {
                try {
                    odd.acquire();
                    System.out.println(String.format("%s -> %s", Thread.currentThread().getName(), i));
                    zero.release();
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class PrintEven implements Runnable {
        int num;
        Semaphore zero, odd, even;

        public PrintEven(Semaphore zero, Semaphore odd, Semaphore even, int n) {
            num = n;
            this.zero = zero;
            this.odd = odd;
            this.even = even;
        }

        @Override
        public void run() {
            for (int i = 2; i <= num ; i+= 2) {
                try {
                    even.acquire();
                    System.out.println(String.format("%s -> %s", Thread.currentThread().getName(), i));
                    zero.release();
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEven oddEven = new OddEven(10);
        oddEven.print();
    }

}
