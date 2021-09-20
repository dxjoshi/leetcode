/*
*
* 226. Invert Binary Tree
*
* Given the root of a binary tree, invert the tree, and return its root.
*
* */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }
}
