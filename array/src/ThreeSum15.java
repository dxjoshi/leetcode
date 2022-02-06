import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
*
* 15. 3Sum
*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
* Notice that the solution set must not contain duplicate triplets.
*
*
* * */
public class ThreeSum15 {

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <3) return res;
        Arrays.sort(nums);
        for (int i=0; i< nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            res.addAll(twoSum(nums, i+1, nums.length-1, nums[i]));
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int begin, int end, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int target = k * -1;
        while (begin < end) {
            int sum = nums[begin] + nums[end];
            if (sum == target) {
                res.add(Arrays.asList(k, nums[begin], nums[end]));
                while (begin<end && nums[begin] == nums[begin+1]) begin++;
                while (begin<end && nums[end] == nums[end-1]) end--;
                begin++;
                end--;

            } else if (sum > target) {
                end--;
            }  else {
                begin++;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    }
                    else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
