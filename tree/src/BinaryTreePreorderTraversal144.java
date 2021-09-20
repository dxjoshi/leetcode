import java.util.ArrayList;
import java.util.List;

/*
*
* 144. Binary Tree Preorder Traversal
*
* Given the root of a binary tree, return the preorder traversal of its nodes' values.
*
* */
public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // Preorder -- Root -> Left -> Right
        List<Integer> result = new ArrayList<Integer>();
        solve(root, result);
        return result;
    }

    public void solve(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        if (root.left != null) solve(root.left, result);
        if (root.right != null) solve(root.right, result);
    }
}
