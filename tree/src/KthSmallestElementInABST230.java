import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
*
* 230. Kth Smallest Element in a BST
*
* Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
*
* */
public class KthSmallestElementInABST230 {
/*
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        solve(root, maxHeap, k);
        return maxHeap.poll();

    }

    public void solve(TreeNode root, PriorityQueue<Integer> maxHeap, int k) {
        if (root == null) return;
        maxHeap.add(root.val);
        if (maxHeap.size()>k) {
            maxHeap.poll();
        }
        solve(root.left, maxHeap, k);
        solve(root.right, maxHeap, k);

    }
*/

/*
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63783/Two-Easiest-In-Order-Traverse-(Java)
    // [Better Explaination] https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/642294/Java-Using-Stack-as-Iterator-Picture-explain-Clean-code-O(H-%2B-k)
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        solve(root, res, k);
        return res.get(k-1);
    }

    public void solve(TreeNode root, List<Integer> res, int k)  {
        if (root == null || res.size() == k) return;

        solve(root.left, res, k);
        res.add(root.val);
        solve(root.right, res, k);
    }
*/

    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count ++;
        if(count == k) result = root.val;
        traverse(root.right, k);
    }


}
