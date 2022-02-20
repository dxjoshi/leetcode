import java.util.ArrayList;
import java.util.List;

/*
Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.
*/

public class KthLargestInBST_GFG {
    public int kthLargest(Node root,int K)
    {
        List<Integer> res = new ArrayList<>();
        solve(root, res, K);
        return res.get(res.size()-K);
    }

    public void solve(Node root, List<Integer> res, int k)  {
        if (root == null) return;

        solve(root.left, res, k);
        res.add(root.val);
        solve(root.right, res, k);
    }

}
