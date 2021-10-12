/*
*
* 152. Maximum Product Subarray
*
* Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
* It is guaranteed that the answer will fit in a 32-bit integer.
* A subarray is a contiguous subsequence of the array.
*
* */
public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int localMin = nums[0], localMax = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (nums[i] < 0) {
                int temp = localMin;
                localMin = localMax;
                localMax = temp;
            }
            localMin = Math.min(nums[i], localMin*nums[i]);
            localMax = Math.max(nums[i], localMax*nums[i]);
            res = Math.max(res, localMax);
        }
        return res;
    }
}
