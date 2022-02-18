/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
*/
public class DiameterOfBinaryTree543 {
    // https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return  max;
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        max = Math.max(max, left+ right);
        return Math.max(left, right) + 1;
    }

}
