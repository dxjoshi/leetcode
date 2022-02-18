import java.util.ArrayList;
import java.util.List;

/*
Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.
*/

public class PathToGivenNode_IBit {
    public int[] solve(TreeNode A, int B) {
        List<Integer> list = new ArrayList<>();
        solve(A, B, list);
        int[] res = new int[list.size()];
        int i = 0;
        for(Integer val : list) {
            res[i++] = val;
        }
        return res;
    }

    public boolean solve(TreeNode A, int B, List<Integer> list) {
        if (A == null) return false;
        list.add(A.val);
        if (A.val == B) return true;

        if (solve(A.left, B, list) || solve(A.right, B, list)) {
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}

