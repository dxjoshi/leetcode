/*
*
* 162. Find Peak Element
*
* A peak element is an element that is strictly greater than its neighbors.
* Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
* You may imagine that nums[-1] = nums[n] = -∞.
* You must write an algorithm that runs in O(log n) time.
*
* */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0; // single element

        int n = nums.length;

        // check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        // search in the remaining array
        int start = 1;
        int end = n-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
        }
        return -1;
    }
}
