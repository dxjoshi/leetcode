/*
*
* 101. Symmetric Tree
*
* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
*
* */
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) &&
                isSymmetricHelp(left.right, right.left);
    }

}
