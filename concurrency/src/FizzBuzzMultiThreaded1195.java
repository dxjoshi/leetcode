import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

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
public class FizzBuzzMultiThreaded1195 {
    // https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/400082/Java-implementation-using-Semaphore-as-token-4ms

    // https://leetcode.com/problems/fizz-buzz-multithreaded/discuss/385395/Java-using-synchronized-with-short-explanation.

    private int n;
    Semaphore f,b,fb,si;

    public FizzBuzzMultiThreaded1195(int n) {
        this.n = n;
        f = new Semaphore(0);
        b = new Semaphore(0);
        fb = new Semaphore(0);
        si = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            if  (div3(i) && !div5(i)) {
                f.acquire();
                printFizz.run();
                release(i);

            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            if  (!div3(i) && div5(i)) {
                b.acquire();
                printBuzz.run();
                release(i);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            if  (div3(i) && div5(i)) {
                fb.acquire();
                printFizzBuzz.run();
                release(i);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            if  (!div3(i) && !div5(i)) {
                si.acquire();
                printNumber.accept(i);
                release(i);
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

}