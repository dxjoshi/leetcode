import java.util.concurrent.TimeUnit;

public class SelectionSort implements Sort
{

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        int temp, idx;

        for (int i=input.length-1; i>1 ; i--) {
            idx = 0;
            for (int j = 0; j <=i; j++) {
                if(input[j] > input[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                temp = input[idx];
                input[idx] = input[i];
                input[i] = temp;
            }

        }

        PrintUtil.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Selection Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }
}
