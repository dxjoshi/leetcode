import java.util.concurrent.TimeUnit;

public class SelectionSort implements Sort
{
//    Scan all items and find the smallest. Swap it into position as the first item.
//    Repeat the selection sort on the remaining N-1 items.

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        int idx;

        for (int i=input.length-1; i>=1 ; i--) {
            idx = 0;
            for (int j = 0; j <=i; j++) {
                if(input[j] > input[idx]) {
                    idx = j;
                }
            }
            Util.swap(input, i, idx);
        }

        Util.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Selection Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }
}
