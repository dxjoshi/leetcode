/*
*
* 39. Combination Sum
*
* Given an array of distinct integers candidates and a target integer target,
* return a list of all unique combinations of candidates where the chosen numbers sum to target.
* You may return the combinations in any order.
*
* The same number may be chosen from candidates an unlimited number of times.
* Two combinations are unique if the frequency of at least one of the chosen numbers is different.
*
* It is guaranteed that the number of unique combinations that
* sum up to target is less than 150 combinations for the given input.
*
*
* */
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        solve(candidates, target, result, list, new int[candidates.length], 0);
        return result;
    }

    public void solve(int[] candidates, int n, List<List<Integer>> result,
                      List<Integer> list, int[] used, int start) {

        if(n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (n < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            used[i] = 1;
            solve(candidates, n-candidates[i], result, list, used, i);
            list.remove(list.size()-1);
            used[i] = 0;
        }
    }
}
