/**
 *
 * Leetcode #938
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with a value in the range [low, high].
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RangeSumBst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        //write base conditions
        // check each node for range, if within range add it to the result
        int result = 0;
        if  (root == null) {
            return result;
        }

        if  (root.val >= low && root.val <= high) {
            result = root.val;
        }
        int left = 0, right = 0;
        if  (root.val >= low && root.left != null) {
            left = rangeSumBST(root.left, low, high);
        }
        if  (root.val <= high && root.right != null) {
            right = rangeSumBST(root.right, low, high);
        }
        result += left + right;
        return result;
    }
}