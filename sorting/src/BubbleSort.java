import java.util.concurrent.TimeUnit;

public class BubbleSort implements Sort
{

    @Override
    public void sort(int[] input) {
/*
        Starting on the left, compare adjacent items and keep “bubbling” the larger one to the right (it’s in its final place).
        Bubble sort the remaining N -1 items.
*/
        long startTime = System.nanoTime();
        boolean isSwapped;

        for (int i=input.length-1; i>=1 ; i--) {
            isSwapped = false;
            for (int j = 0; j <i; j++) {
                if(input[j] > input[j+1]) {
                    Util.swap(input, j, j+1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }

        Util.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Bubble Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }
}
