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