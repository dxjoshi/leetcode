import java.util.ArrayList;
import java.util.List;

/*
*
* 77. Combinations
*
* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
* You may return the answer in any order.
*
* */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        solve(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    public void solve(int n, int k, List<List<Integer>> result,
                      List<Integer> list, int curr) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

/*
        n-k+1 is a nice idea I found on discuss forum
        it reduces the search space and improves the runtime
        If n = 10, k = 5, and you're in the outermost level of recursion, you choose
        only i = 1...6 , because if you pick i=7 and go into backTracking() you only
        have 8,9,10 to pick from, so at most you will get [7,8,9,10].
*/

        for (int i=curr; i <= n-k+1; i++) {
            list.add(i);
            solve(n, k-1, result, list, i+1);
            list.remove(list.size()-1);
        }
    }
}