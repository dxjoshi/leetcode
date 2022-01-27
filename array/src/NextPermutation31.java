/*
*
* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
*
* */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i1 = len-2;
        while(i1>=0 && nums[i1] >= nums[i1+1]) i1--;

        if  (i1 >= 0)   {
            int i2 = len-1;
            while(nums[i1] >= nums[i2]) i2--;
            swap(nums,i1,i2);
        }

        reverse(nums, i1+1, len-1);
    }

    public void reverse(int[] nums, int begin, int end) {
        for (int i=begin,j=end; i<j; i++,j--)  {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int first, int second) {
        nums[first] = nums[first] + nums[second];
        nums[second] = nums[first] - nums[second];
        nums[first] = nums[first] - nums[second];
    }

}
