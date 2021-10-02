import java.util.concurrent.TimeUnit;

public class CyclicSort implements Sort
{

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        for (int i=0; i<=input.length-1;) {
            if (input[i]-1 != i) {
                Util.swap(input, i, input[i]-1);
            } else {
                i++;
            }
        }

        Util.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Selection Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }
}
