/*
*
* 98. Validate Binary Search Tree
*
* Given the root of a binary tree, determine if it is a valid binary search tree (BST).
* A valid BST is defined as follows:
* The left subtree of a node contains only nodes with keys less than the node's key.
* The right subtree of a node contains only nodes with keys greater than the node's key.
* Both the left and right subtrees must also be binary search trees.
*
* */
public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if  (root == null) {
            return true;
        }

        return (!(lower != null &&  lower >= root.val))
                && (!(upper != null && upper <= root.val))
                && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);

    }
}
