import java.util.ArrayList;
import java.util.List;

/*
*
* 94. Binary Tree Inorder Traversal
*
* Given the root of a binary tree, return the inorder traversal of its nodes' values.
*
* */
public class BinaryInorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solve(root, result);
        return result;
    }

    public void solve(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) solve(root.left, result);
        result.add(root.val);
        if (root.right != null) solve(root.right, result);
    }
}
