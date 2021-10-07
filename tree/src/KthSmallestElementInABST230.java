import java.util.Comparator;
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
