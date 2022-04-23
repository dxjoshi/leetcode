import java.util.concurrent.Semaphore;

public class PrintEvenOddAlternatively {
    static class OddEven {
        Semaphore odd = new Semaphore(1);
        Semaphore even = new Semaphore(0);
        Thread evenThread, oddThread;
        int num;

        public OddEven(int num) {
            this.evenThread = new Thread(new PrintEven(odd, even, num));
            this.oddThread = new Thread(new PrintOdd(odd, even, num));
            this.num = num;
        }

        public void print() {
            oddThread.start();
            evenThread.start();
        }
    }

    public static void main(String[] args) {
        OddEven oddEven = new OddEven(10);
        oddEven.print();
    }

    static class PrintOdd implements Runnable {
        int num;
        Semaphore odd, even;

        public PrintOdd(Semaphore odd, Semaphore even, int n) {
            num = n;
            this.odd = odd;
            this.even = even;
        }

        @Override
        public void run() {
            for (int i = 1; i <= num ; i+= 2) {
                try {
                    odd.acquire();
                    System.out.println(String.format("%s -> %s", Thread.currentThread().getName(), i));
                    even.release();
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class PrintEven implements Runnable {
        int num;
        Semaphore odd, even;

        public PrintEven(Semaphore odd, Semaphore even, int n) {
            num = n;
            this.odd = odd;
            this.even = even;
        }

        @Override
        public void run() {
            for (int i = 2; i <= num ; i+= 2) {
                try {
                    even.acquire();
                    System.out.println(String.format("%s -> %s", Thread.currentThread().getName(), i));
                    odd.release();
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
