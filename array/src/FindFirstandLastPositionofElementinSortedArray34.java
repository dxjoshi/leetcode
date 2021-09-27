/*
*
* 34. Find First and Last Position of Element in Sorted Array
*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
* If target is not found in the array, return [-1, -1].
* You must write an algorithm with O(log n) runtime complexity.
*
* */
public class FindFirstandLastPositionofElementinSortedArray34 {
    public int[] searchRange(int[] a, int target) {
        int[] result = {-1, -1};

        if (a == null || a.length == 0)
            return result;

        result[0] = findStartPosition(a, target);
        result[1] = findEndPosition(a, target);

        return result;

    }

    public int findStartPosition(int[] nums, int target) {
        int res = -1;
        int begin = 0, end = nums.length-1, mid = 0;
        while (begin <= end) {
            mid = begin + (end - begin)/2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            }
            if (nums[mid] == target) {
                res = mid;
            }
        }
        return res;
    }

    public int findEndPosition(int[] nums, int target) {
        int res = -1;
        int begin = 0, end = nums.length-1, mid = 0;
        while (begin <= end) {
            mid = begin + (end - begin)/2;
            if (nums[mid] > target) {
                end = mid -1;
            } else if (nums[mid] <= target) {
                begin = mid + 1;
            }
            if (nums[mid] == target) {
                res = mid;
            }
        }
        return res;
    }
}
