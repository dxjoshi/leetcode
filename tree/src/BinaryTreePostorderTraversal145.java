import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
* 145. Binary Tree Postorder Traversal
*
* Given the root of a binary tree, return the postorder traversal of its nodes' values.
*
* */
public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solve(root, result);
        return result;
    }

    public void solve(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) solve(root.left, result);
        if (root.right != null) solve(root.right, result);
        result.add(root.val);

    }
}
