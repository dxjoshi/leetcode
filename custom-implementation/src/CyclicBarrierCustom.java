public class CyclicBarrierCustom{
    int initialParties; //total parties
    int partiesAwait; //parties yet to arrive
    Runnable cyclicBarrrierEvent;

    public CyclicBarrierCustom(int parties, Runnable cyclicBarrrierEvent) {
        initialParties=parties;
        partiesAwait=parties;
        this.cyclicBarrrierEvent=cyclicBarrrierEvent;
    }

    public synchronized void await() throws InterruptedException {
        partiesAwait--;
        if(partiesAwait>0){
            this.wait();
        } else{
            partiesAwait=initialParties;
            notifyAll(); //notify all waiting threads
            cyclicBarrrierEvent.run(); //launch event
        }
    }
}