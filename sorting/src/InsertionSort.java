import java.util.concurrent.TimeUnit;

public class InsertionSort implements Sort {

//    Start with a sorted list of 1 element on the left, and N-1 unsorted items on the right.
//    Take the first unsorted item (element #2) and insert it into the sorted list, moving elements as necessary.
//    We now have a sorted list of size 2, and N -2 unsorted elements. Repeat for all elements.
    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        for (int i=0; i<input.length-1; i++) {
            for (int j = i+1; j>0; j--) {
                if(input[j] < input[j-1]) {
                    Util.swap(input, j, j-1);
                } else {
                    break;
                }
            }
        }

        Util.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Insertion Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }

}