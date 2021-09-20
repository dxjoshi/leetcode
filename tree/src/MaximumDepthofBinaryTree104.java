/*
*
* 104. Maximum Depth of Binary Tree
*
* Given the root of a binary tree, return its maximum depth.
* A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*
* */
public class MaximumDepthofBinaryTree104 {
    public int maxDepth(TreeNode root) {
        return solve(root, 0);
    }

    public int solve(TreeNode root, int result) {
        if (root == null) return result;
        result = Math.max(solve(root.left, result+1), solve(root.right, result+1));
        return result;
    }
}
