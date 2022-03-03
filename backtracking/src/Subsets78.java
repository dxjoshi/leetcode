/*
* 78. Subsets
*
* Given an integer array nums of unique elements, return all possible subsets (the power set).
* The solution set must not contain duplicate subsets. Return the solution in any order.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        // find all permutations of size 0 to nums.length
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<=nums.length; i++) {
            solve(nums, result, list, i);
        }
        return result;
    }

    public void solve(int[] nums, List<List<Integer>> result, List<Integer> list, int size) {
        if (list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            if (list.size()>0 && list.get(list.size()-1) >= nums[i]) {
                continue;
            }
            list.add(nums[i]);
            solve(nums, result, list, size);
            list.remove(list.size()-1);
        }
    }

    // BIT Manipulation: https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/
    static ArrayList<String> AllPossibleStrings(String s) {
        int n = s.length();
        ArrayList<String>ans=new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}