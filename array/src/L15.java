/*
*
* 53. Maximum Subarray
*
* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
* A subarray is a contiguous part of an array.
* */
public class L53 {

    public int maxSubArray(int[] nums) {
        // kadanes' algorithm
        int maxSoFar = nums[0];
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;

    }
}
