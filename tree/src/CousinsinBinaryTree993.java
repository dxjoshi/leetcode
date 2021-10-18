/*
*
* 993. Cousins in Binary Tree
*
* Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
* Two nodes of a binary tree are cousins if they have the same depth with different parents.
* Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
*
* */
public class CousinsinBinaryTree993 {
    TreeNode xParent = null, yParent = null;
    int xDepth = -1, yDepth = -2;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null) return;
        if (x == root.val) {
            xParent = parent;
            xDepth = depth;
        } else if (y == root.val) {
            yParent = parent;
            yDepth = depth;
        } else {
            // if we found x node or found y node then we don't need to dfs deeper
            //     because x and y must be the same depth
            dfs(root.left, root, x, y, depth + 1);
            dfs(root.right, root, x, y, depth + 1);
        }
    }
}
