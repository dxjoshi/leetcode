import java.util.ArrayList;
import java.util.Collections;

/*
Given a list arr of N integers, print sums of all subsets in it.

Note: Return all the element is increasing order.
*/

public class SubsetSum_GFG {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        Collections.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        sol(arr, 0, 0, res);
        Collections.sort(res);
        return res;
    }

    void sol(ArrayList<Integer> arr, int sum, int idx, ArrayList<Integer> res) {
        res.add(sum);
        if (idx == arr.size()) {
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            sol(arr, sum + arr.get(i), i+1, res);
        }
    }
}
