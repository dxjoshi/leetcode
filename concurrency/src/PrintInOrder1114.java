/*
Suppose we have a class:

public class Foo {
public void first() { print("first"); }
public void second() { print("second"); }
public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
*/
public class PrintInOrder1114 {

        // https://leetcode.com/problems/print-in-order/discuss/893827/Java-SynchronizedLockSemaphoreCondition-Variable

// https://leetcode.com/problems/print-in-order/discuss/332890/Java-Basic-semaphore-solution-8ms-36MB
//     Semaphore run2, run3;
//     public Foo() {
//         run2 = new Semaphore(0);
//         run3 = new Semaphore(0);
//     }

//     public void first(Runnable printFirst) throws InterruptedException {

//         // printFirst.run() outputs "first". Do not change or remove this line.
//         printFirst.run();
//         run2.release();
//     }

//     public void second(Runnable printSecond) throws InterruptedException {

//         // printSecond.run() outputs "second". Do not change or remove this line.
//         run2.acquire();
//         printSecond.run();
//         run3.release();
//     }

//     public void third(Runnable printThird) throws InterruptedException {

//         // printThird.run() outputs "third". Do not change or remove this line.
//         run3.acquire();
//         printThird.run();
//     }

        Object lock;
        boolean one, two;

        public PrintInOrder1114() {
            lock  = new Object();
            one = false;
            two = false;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized(lock) {

                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                one = true;
                lock.notifyAll();

            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized(lock) {
                while(!one) {
                    lock.wait();
                }
                printSecond.run();
                two = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            synchronized(lock) {
                while(!two) {
                    lock.wait();
                }
                printThird.run();
            }
        }
    }