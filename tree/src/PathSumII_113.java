import java.util.ArrayList;
import java.util.List;

/*
*
* 113. Path Sum II
*
* Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
* A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
*
* */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        solve(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    public void solve(TreeNode root, int target, List<Integer> list, List<List<Integer>> res) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right==null) {
            if (target == root.val) res.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null) {
            solve(root.left, target - root.val, list, res);
            list.remove(list.size()-1);
        }

        if (root.right != null) {
            solve(root.right, target - root.val, list, res);
            list.remove(list.size()-1);
        }
    }
}
