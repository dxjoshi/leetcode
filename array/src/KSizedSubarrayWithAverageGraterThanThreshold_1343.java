public class KSizedSubarrayWithAverageGraterThanThreshold_1343 {
//    Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;

        int i = 0, j = 0, sum = 0;
        for (; j< arr.length; j++) {
            sum += arr[j];
            if  (j-i+1 == k) {
                int avg = sum/k;
                if  (avg >= threshold) result++;
                sum -= arr[i];
                i++;
            }
        }

        return result;

    }
}
