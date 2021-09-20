import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
* 102. Binary Tree Level Order Traversal
*
* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
*
* */
public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) q.add(root);

        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i< size; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            result.add(level);
        }

        return result;

    }
}
