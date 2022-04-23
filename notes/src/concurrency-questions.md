## Popular Java concurrency questions solution
       
### Useful Links     
- [Different ways to achieve concurrency in Java Solution](https://leetcode.com/problems/print-in-order/discuss/893827/Java-SynchronizedLockSemaphoreCondition-Variable)            
       
- [Print FooBar/EvenOdd alternatively](https://github.com/dxjoshi/leetcode/blob/0cf6eb8a7b2b9a970e2b7d29f8699230395ec958/concurrency/src/PrintEvenOddAlternatively.java)
        
        
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

- [Building H20](https://github.com/dxjoshi/leetcode/blob/76373b6eb272d752f5badf749c140449baa5b5b6/concurrency/src/BuildingH2O.java)            


        import java.util.concurrent.Semaphore;

        public class BuildingH2O {
            // https://leetcode.com/problems/building-h2o/discuss/334135/Very-simple-Java-solution-using-2-semaphores
        
            Semaphore h,o;
            Thread hydrogen, oxygen;
            public BuildingH2O() {
                h = new Semaphore(2, true);
                o = new Semaphore(0, true);
                hydrogen = new Thread(new Hydro(h,o));
                oxygen = new Thread(new Oxy(h,o));
            }
        
            public void print() throws InterruptedException {
                hydrogen.start();
                oxygen.start();
            }
        
            public static void main(String[] args) throws InterruptedException {
                BuildingH2O driver = new BuildingH2O();
                driver.print();
            }
        
            class Oxy implements Runnable {
                Semaphore h,o;
                public Oxy(Semaphore h, Semaphore o) {
                    this.h = h;
                    this.o = o;
                }
        
                @Override
                public void run() {
                    try {
                        o.acquire(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("O");
                    h.release(2);
                }
            }
        
            class Hydro implements Runnable {
        
                Semaphore h,o;
                public Hydro(Semaphore h, Semaphore o) {
                    this.h = h;
                    this.o = o;
                }
        
                @Override
                public void run() {
                    for (int i = 1; i <=2 ; i++) {
                        try {
                            h.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("H");
                        o.release();
                    }
                }
            }
        }

- [Fizz, Buzz, FizzBuzz](https://github.com/dxjoshi/leetcode/blob/76373b6eb272d752f5badf749c140449baa5b5b6/concurrency/src/FizzBuzzMultiThreaded.java)                    


    import java.util.concurrent.Semaphore;
    
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
    
    
- [Print In Order](https://github.com/dxjoshi/leetcode/blob/76373b6eb272d752f5badf749c140449baa5b5b6/concurrency/src/PrintInOrder.java)                         


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
    
- [Print Zero Even Odd](https://github.com/dxjoshi/leetcode/blob/76373b6eb272d752f5badf749c140449baa5b5b6/concurrency/src/PrintZeroEvenOdd.java)                   


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

    