/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/

public class SameTree100 {
    // https://leetcode.com/problems/same-tree/discuss/32687/Five-line-Java-solution-with-recursion
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if(p == null && q == null)
    //         return true;
    //     if(p == null || q == null)
    //         return false;
    //     if(p.val != q.val)
    //         return false;
    //     return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    // }

}
