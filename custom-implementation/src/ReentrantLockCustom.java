public class ReentrantLockCustom implements LockCustom {
    int lockHoldCount;
    long IdOfThreadCurrentlyHoldingLock;

    ReentrantLockCustom(){
        lockHoldCount=0;
    }

    public synchronized void lock() {
        if(lockHoldCount==0){
            lockHoldCount++;
            IdOfThreadCurrentlyHoldingLock=Thread.currentThread().getId();
        } else if(lockHoldCount>0 && IdOfThreadCurrentlyHoldingLock==Thread.currentThread().getId()){
            lockHoldCount++;
        } else{
            try {
                wait();
                lockHoldCount++;
                IdOfThreadCurrentlyHoldingLock=Thread.currentThread().getId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void unlock() {
        if(lockHoldCount==0) throw new IllegalMonitorStateException();

        lockHoldCount--; //decrement lock hold count by 1
        if(lockHoldCount==0)
            notify();
    }

    public synchronized boolean tryLock(){
        if(lockHoldCount==0){
            lock();
            return true;
        } else
            return false;
    }
}
