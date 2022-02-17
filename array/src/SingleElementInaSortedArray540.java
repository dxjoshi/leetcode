/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.
*/
public class SingleElementInaSortedArray540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int lo = 0, hi = nums.length-1;
        int mid = lo + (hi-lo)/2;

        while (lo < hi) {
            mid = lo + (hi-lo)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) ) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        return nums[lo];

    }
}
