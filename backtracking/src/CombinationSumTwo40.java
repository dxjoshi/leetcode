/*
*
* 40. Combination Sum II
*
* Given a collection of candidate numbers (candidates) and a target number (target),
* find all unique combinations in candidates where the candidate numbers sum to target.
* Each number in candidates may only be used once in the combination.
*
* Note: The solution set must not contain duplicate combinations.
*
* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        solve(candidates, target, result, list, 0);
        return result;
    }

    public void solve(int[] candidates, int n, List<List<Integer>> result,
                      List<Integer> list, int start) {

        if(n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (n < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            solve(candidates, n-candidates[i], result, list, i+1);
            list.remove(list.size()-1);
        }
    }
}
