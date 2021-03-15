/*
*
* 46. Permutations
*
* Given an array nums of distinct integers, return all the possible permutations.
* You can return the answer in any order.
*
* */


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, result, list, 0);
        return result;
    }

    public void solve(int[] nums, List<List<Integer>> result, List<Integer> list, int pos) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            solve(nums, result, list, pos+1);
            list.remove(list.size()-1);
        }
    }
}