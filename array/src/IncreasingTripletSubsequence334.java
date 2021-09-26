/*
*
* 334. Increasing Triplet Subsequence
*
* Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
*
* */
public class IncreasingTripletSubsequence334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int i = 0, j = 1, k = 2;
        while ( k < nums.length ) {
            if (nums[i] < nums[j] && nums[j] < nums[k]) {
                return true;
            }
            if (nums[i] >= nums[j]) {
                ++j; ++k;
            } else if (nums[j] >= nums[k]) {
                ++k;
            }
        }
        return false;

    }
}
