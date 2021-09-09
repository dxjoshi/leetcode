/*
*
* 283. Move Zeroes
*
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* Note that you must do this in-place without making a copy of the array.
*
* */
public class L283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <2) {
            return;
        }
        int zeroes = 0;

        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == 0) {
                ++zeroes;
            } else if (zeroes > 0) {
                nums[i-zeroes] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
