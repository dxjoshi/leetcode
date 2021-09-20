/*
*
* 701. Insert into a Binary Search Tree
*
* You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
* Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
*
* */
public class InsertintoaBinarySearchTree701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        solve(root, null, val);
        return root;
    }

    public void solve(TreeNode root, TreeNode parent, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            if (parent.val > val) {
                parent.left = node;
            }  else {
                parent.right = node;
            }
            return;
        }
        parent = root;
        if (root.val > val) {
            root = root.left;
        } else {
            root = root.right;
        }
        solve(root, parent, val);
    }
}
