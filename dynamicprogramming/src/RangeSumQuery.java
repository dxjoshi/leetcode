/*
*
* 303. Range Sum Query - Immutable
*
* Given an integer array nums,
* find the sum of the elements between indices left and right inclusive,
* where (left <= right).
* Implement the NumArray class:
* NumArray(int[] nums) initializes the object with the integer array nums.
* int sumRange(int left, int right) returns the sum of the elements of the nums
* array in the range [left, right] inclusive
* (i.e., sum(nums[left], nums[left + 1], ... , nums[right])).
* */
public class RangeSumQuery {
    int[] range;
    public RangeSumQuery(int[] nums) {
        range = new int[nums.length];
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            range[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return left==0 ? range[right] : range[right] - range[left-1];
    }
}
