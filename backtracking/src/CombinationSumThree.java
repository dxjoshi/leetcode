/*
*
* 216. Combination Sum III
*
* Find all valid combinations of k numbers that sum up to n
* such that the following conditions are true:
*
* Only numbers 1 through 9 are used.
* Each number is used at most once.
*
* Return a list of all possible valid combinations.
* The list must not contain the same combination twice,
* and the combinations may be returned in any order.
*
* */
import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        solve(k, n, result, list, new int[10]);
        return result;
    }

    public void solve(int k, int n, List<List<Integer>> result,
                      List<Integer> list, int[] used) {

        if(n == 0 && k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 1; i <= 9; i++) {
            if (list.size()==0 ||
                    !list.contains(i) &&
                            (list.size()>0 && i > list.get(list.size()-1))) {
                list.add(i);
                used[i] = 1;
                solve(k-1, n-i, result, list, used);
                list.remove(list.size()-1);
                used[i] = 0;
            }
        }
    }
}

