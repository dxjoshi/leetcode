import java.util.HashMap;
import java.util.Map;

/*
*
* Largest subarray with 0 sum
* https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1#
*
* Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
*
* */
public class LargestSubarrayWithZeroSum {
    int maxLen(int arr[], int n)
    {
        if (arr == null || arr.length == 0) return 0;
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> set = new HashMap<>();
        for (int i=0; i<arr.length; i++)   {
            sum += arr[i];
            if (sum == 0) {
                max = i+1;
            } else {
                if (set.containsKey(sum)) {
                    max = Math.max(max, i - set.get(sum));
                } else {
                    set.put(sum, i);
                }
            }
        }

        return max;

    }
}
