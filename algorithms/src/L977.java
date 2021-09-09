/*
*
* 977. Squares of a Sorted Array
*
* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*
* */
public class L977 {
    public int[] sortedSquares(int[] nums) {
        int[] squared = new int[nums.length];
        int i = 0;
        int j = nums.length-1;

        for(int k = nums.length-1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                squared[k] = nums[i]*nums[i];
                i++;
            } else {
                squared[k] = nums[j]*nums[j];
                j--;
            }

        }
        return squared;

    }
}
