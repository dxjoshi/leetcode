import java.util.concurrent.TimeUnit;

public class BubbleSort implements Sort
{

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        int temp;
        boolean isSwapped;

        for (int i=input.length-1; i>1 ; i--) {
            isSwapped = false;
            for (int j = 0; j <i; j++) {
                if(input[j] > input[j+1]) {
                    temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }

        PrintUtil.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Bubble Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }
}
