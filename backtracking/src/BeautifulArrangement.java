/*
*
* 526. Beautiful Arrangement
*
* Suppose you have n integers labeled 1 through n.
* A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement
* if for every i (1 <= i <= n), either of the following is true:
* 1. perm[i] is divisible by i.
* 2. i is divisible by perm[i].
* Given an integer n, return the number of the beautiful arrangements that you can construct.
*
* */
import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {

    public static void main(String[] args) {
        BeautifulArrangement obj = new BeautifulArrangement();
        System.out.println(obj.countArrangement(3));
    }

    public int countArrangement(int n) {
        if (n == 1) {
            return n;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(n, result, list, 1);
        System.out.println(result);
        return result.size();
    }

    public void solve(int n, List<List<Integer>> result, List<Integer> list, int curr) {
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (list.size() > 0 &&
                !(list.get(list.size()-1)%curr==0) &&
                !(curr%list.get(list.size()-1)==0)) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            solve(n, result, list, curr+1);
            list.remove(Integer.valueOf(i));
        }

    }
}
