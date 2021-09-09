/*
*
* 704. Binary Search
*
* Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
* You must write an algorithm with O(log n) runtime complexity.
*
* */
public class L704 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int mid = 0;
        while(lo <= hi) {
            mid = (lo + hi)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}

