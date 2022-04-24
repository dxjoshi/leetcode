interface ReadWriteLock {
    ReentrantReadWriteLock.WriteLock writeLock();
    ReentrantReadWriteLock.ReadLock  readLock();
}

public class ReentrantReadWriteLock implements ReadWriteLock {
    private int readLockCount;
    private int writeLockCount;
    private final ReentrantReadWriteLock.ReadLock readerLock;
    private final ReentrantReadWriteLock.WriteLock writerLock;

    public ReentrantReadWriteLock.WriteLock writeLock() {
        return writerLock;
    }
    public ReentrantReadWriteLock.ReadLock  readLock()  {
        return readerLock;
    }

    public ReentrantReadWriteLock() {
        readerLock = new ReadLock();
        writerLock = new WriteLock();
    }

    public class ReadLock{
        public synchronized void lock() {
            if(writeLockCount==0){
                readLockCount++;
            } else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void unlock() {
            readLockCount--; //decrement readLockCount.
            if(readLockCount==0)
                notify();
        }
    }

    public class WriteLock{
        public synchronized void lock() {
            if(writeLockCount==0 && readLockCount==0){
                writeLockCount++;
            } else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void unlock() {
            writeLockCount--; //decrement writeLockCount.
            notify(); //notify all waiting threads.
        }
    }
}