import java.util.concurrent.TimeUnit;

public class BubbleSort implements Sort
{

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        System.out.print("Input Array: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();

        int temp;
        for (int i=input.length-1; i>1 ; i--) {
            for (int j = 0; j <i; j++) {
                if(input[j] > input[j+1]) {
                    temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
        }


        System.out.print("Output Array: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        long endTime = System.nanoTime();
        System.out.println("[BubbleSort | " + TimeUnit.NANOSECONDS.toMillis(endTime -startTime) + " ms]");
    }
}
