import java.util.concurrent.TimeUnit;

public class QuickSort implements Sort
{
    /*
    Divide and conquer technique
    1. Pick a pivot elements(1st/last/median/random)
    2. Implement partition(input, pivot) - put pivot at its correct location in the sorted array (smaller elements before pivot, greater elements after pivot)
    3. sort the 2 subarrays on either sides of pivot recursively
    */

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        sort(input, 0, input.length-1);

        Util.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Quick Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }

    private void sort(int[] input, int start, int end) {
        if (start<end) {
           int idx = partition(input, start, end);
           sort(input, start, idx-1);
           sort(input, idx+1, end);
        }
    }

    private int partition(int[] input, int start, int end) {
        int pIdx = end;
        int pivot = input[pIdx];
        int j = start-1;
        for(int i=start; i<pIdx; i++) {
            if (input[i] <= pivot) {
                ++j;
                Util.swap(input, i, j);
            }
        }
        Util.swap(input, j+1, pIdx);
        return j+1;
    }

}