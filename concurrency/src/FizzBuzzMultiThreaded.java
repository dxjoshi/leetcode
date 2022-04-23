import java.util.concurrent.Semaphore;

/*
You have the four functions:

printFizz that prints the word "Fizz" to the console,
printBuzz that prints the word "Buzz" to the console,
printFizzBuzz that prints the word "FizzBuzz" to the console, and
printNumber that prints a given integer to the console.
You are given an instance of the class FizzBuzz that has four functions: fizz, buzz, fizzbuzz and number. The same instance of FizzBuzz will be passed to four different threads:

Thread A: calls fizz() that should output the word "Fizz".
Thread B: calls buzz() that should output the word "Buzz".
Thread C: calls fizzbuzz() that should output the word "FizzBuzz".
Thread D: calls number() that should only output the integers.
Modify the given class to output the series [1, 2, "Fizz", 4, "Buzz", ...] where the ith token (1-indexed) of the series is:

"FizzBuzz" if i is divisible by 3 and 5,
"Fizz" if i is divisible by 3 and not 5,
"Buzz" if i is divisible by 5 and not 3, or
i if i is not divisible by 3 or 5.
Implement the FizzBuzz class:

FizzBuzz(int n) Initializes the object with the number n that represents the length of the sequence that should be printed.
void fizz(printFizz) Calls printFizz to output "Fizz".
void buzz(printBuzz) Calls printBuzz to output "Buzz".
void fizzbuzz(printFizzBuzz) Calls printFizzBuzz to output "FizzBuzz".
void number(printNumber) Calls printnumber to output the numbers.
*/
public class FizzBuzzMultiThreaded {
    // https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/400082/Java-implementation-using-Semaphore-as-token-4ms
    // https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/385395/Java-using-synchronized-with-short-explanation.

    private int n;
    Semaphore f,b,fb,si;
    Thread fThread,bThread,fbThread,siThread;

    public FizzBuzzMultiThreaded(int n) {
        this.n = n;
        f = new Semaphore(0);
        b = new Semaphore(0);
        fb = new Semaphore(0);
        si = new Semaphore(1);
        fThread = new Thread(new Fizz(n,f,b,fb,si));
        bThread = new Thread(new Buzz(n,f,b,fb,si));
        fbThread = new Thread(new FizzBuzz(n,f,b,fb,si));
        siThread = new Thread(new PrintInt(n,f,b,fb,si));
    }

    public void print(){
        fThread.start();
        bThread.start();
        fbThread.start();
        siThread.start();
    }

    class Fizz implements Runnable {
        private int n;
        Semaphore f,b,fb,si;

        public Fizz(int n, Semaphore f, Semaphore b, Semaphore fb, Semaphore si) {
            this.n = n;this.f = f;this.b = b;this.fb = fb;this.si = si;
        }

        @Override
        public void run() {
            for (int i=1; i<=n; i++) {
                if  (div3(i) && !div5(i)) {
                    try { f.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println("Fizz");;
                    release(i);
                }
            }
        }
    }

    class Buzz implements Runnable {
        private int n;
        Semaphore f,b,fb,si;

        public Buzz(int n, Semaphore f, Semaphore b, Semaphore fb, Semaphore si) {
            this.n = n;this.f = f;this.b = b;this.fb = fb;this.si = si;
        }

        @Override
        public void run() {
            for (int i=1; i<=n; i++) {
                if  (!div3(i) && div5(i)) {
                    try { b.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println("Buzz");;
                    release(i);
                }
            }
        }
    }

    class FizzBuzz implements Runnable {
        private int n;
        Semaphore f,b,fb,si;

        public FizzBuzz(int n, Semaphore f, Semaphore b, Semaphore fb, Semaphore si) {
            this.n = n;this.f = f;this.b = b;this.fb = fb;this.si = si;
        }

        @Override
        public void run() {
            for (int i=1; i<=n; i++) {
                if  (div3(i) && div5(i)) {
                    try { fb.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println("FizzBuzz");;
                    release(i);
                }
            }
        }
    }

    class PrintInt implements Runnable {
        private int n;
        Semaphore f,b,fb,si;

        public PrintInt(int n, Semaphore f, Semaphore b, Semaphore fb, Semaphore si) {
            this.n = n;this.f = f;this.b = b;this.fb = fb;this.si = si;
        }

        @Override
        public void run() {
            for (int i=1; i<=n; i++) {
                if  (!div3(i) && !div5(i)) {
                    try { si.acquire(); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(i);;
                    release(i);
                }
            }
        }
    }

    public void release(int val) {
        int i = val+1;
        if (div3(i) && div5(i))   {
            fb.release();
        } else if (div3(i) && !div5(i))   {
            f.release();
        } else if (!div3(i) && div5(i))   {
            b.release();
        } else if (!div3(i) && !div5(i))   {
            si.release();
        }
    }

    public boolean div3(int i){
        return i%3==0;
    }

    public boolean div5(int i){
        return i%5==0;
    }

    public static void main(String[] args) {
        FizzBuzzMultiThreaded driver = new FizzBuzzMultiThreaded(15);
        driver.print();
    }
}