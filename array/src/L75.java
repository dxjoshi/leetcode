/*
*
* 75. Sort Colors
*
* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
* We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
* You must solve this problem without using the library's sort function.
*
*
* * */
public class L75 {

    public void sortColors(int[] nums) {
        //dutch flag problem
        // low, mid, high needed and will mark the separation between 0 1s and 2s

        int low = 0;
        int high = nums.length-1;
        for (int mid = 0; mid <= high;) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                ++low;
                ++mid;
            } else if (nums[mid] == 1) {
                ++mid;
            } else {
                swap(nums, mid, high);
                --high;
            }
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
