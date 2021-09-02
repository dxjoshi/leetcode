/*
*
* 47. Permutations II
*
* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, result, list, 0, new int[nums.length]);
        return result;
    }

    public void solve(int[] nums, List<List<Integer>> result,
                      List<Integer> list, int idx, int[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            if (visited[i] == 1 ||
                    i > 0 && nums[i] == nums[i-1] && visited[i-1] != 1 ) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = 1;
            solve(nums, result, list, i+1, visited);
            list.remove(list.size()-1);
            visited[i] = 0;
        }
    }
}
