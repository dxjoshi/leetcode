import java.util.concurrent.TimeUnit;

public class MergeSort implements Sort {
//    Divide and conquer technique
//    1. Find mid index
//    2. sort the 2 halves, recursively
//    3. Merge the subarrays

    @Override
    public void sort(int[] input) {
        long startTime = System.nanoTime();
        sort(input, 0, input.length-1);

        Util.print("Output Array: ", input);
        long endTime = System.nanoTime();
        System.out.println("[Merge Sort | " + TimeUnit.NANOSECONDS.toMicros(endTime -startTime) + " micros]");
    }

    private void sort(int[] input, int start, int end) {
        if (start<end) {
           int mid = start + (end - start)/2;
           sort(input, start, mid);
           sort(input, mid+1, end);
           merge(input, start, mid, end);
        }
    }

    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}