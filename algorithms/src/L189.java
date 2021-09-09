/*
*
* 189. Rotate Array
* 
* Given an array, rotate the array to the right by k steps, where k is non-negative.
*
* */
public class L189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <2) {
            return;
        }
        k %= nums.length;

        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public void reverse(int[] nums, int begin, int end) {
        int temp = 0;
        while (begin<end) {
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            ++begin;
            --end;
        }
    }
}
