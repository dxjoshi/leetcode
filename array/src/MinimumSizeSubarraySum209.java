/*
*
* 209. Minimum Size Subarray Sum
*
* Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*
* */

public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (i<=j && sum >= target) {
                min = Math.min(min, j-i+1);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
