/*
*
* 1567. Maximum Length of Subarray With Positive Product
*
* Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
* A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
* Return the maximum length of a subarray with positive product.
*
* */
public class MaximumLengthofSubarrayWithPositiveProduct1567 {
    public int getMaxLen(int[] nums) {
        int positive = 0, negative = 0;    // length of positive and negative results
        int ans = 0;
        for(int x : nums) {
            if(x == 0)  {
                positive = 0;
                negative = 0;
            }
            else if(x > 0) {
                positive++;
                negative = negative == 0 ? 0  : negative+1;
            }
            else {
                int temp = positive;
                positive = negative == 0 ? 0  : negative+1;
                negative = temp+1;
            }
            ans = Math.max(ans, positive);
        }
        return ans;
    }
}
