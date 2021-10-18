import java.util.ArrayList;
import java.util.List;

/*
*
* 257. Binary Tree Paths
*
* Given the root of a binary tree, return all root-to-leaf paths in any order.
* A leaf is a node with no children.
* */
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list, "");
        return list;
    }

    public void dfs(TreeNode root, List<String> list, String path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(path+root.val);
            return;
        }
        path += root.val+"->";
        dfs(root.left, list, path);
        dfs(root.right, list, path);
    }
}
