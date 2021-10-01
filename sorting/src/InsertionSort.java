import java.util.concurrent.TimeUnit;

public class InsertionSort implements Sort
{

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        int idx;

        for (int i=0; i<input.length-1; i++) {
            for (int j = i+1; j>=1; j--) {
                if(input[j] < input[j-1]) {
                    Util.swap(input, j, j-1);
                }
            }

        }

        Util.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Insertion Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }

}
