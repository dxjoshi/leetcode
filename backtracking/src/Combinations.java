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

        for (int i=curr; i <= n; i++) {
            list.add(i);
            solve(n, k-1, result, list, i+1);
            list.remove(list.size()-1);
        }
    }
}