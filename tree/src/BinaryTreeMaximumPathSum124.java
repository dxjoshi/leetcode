/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
*/
public class BinaryTreeMaximumPathSum124 {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        solve(root, res);
        return res[0];
    }

    // helper returns the max branch
    // plus current node's value
    public int solve(TreeNode node, int[] res) {
        if (node == null) return 0;

        int left = Math.max(0, solve(node.left, res));
        int right = Math.max(0, solve(node.right, res));

        res[0] = Math.max(res[0], left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}
