/*
*
* 105. Construct Binary Tree from Preorder and Inorder Traversal
*
* Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
*
*
* */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode head = helper(preorder, inorder, 0, inorder.length - 1, 0);
        return head;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int low, int high, int pIdx) {
        if (low > high || pIdx >=preorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pIdx]);

        int inorderMid = 0;
        for (int i= low; i<=high; i++) {
            if (node.val == inorder[i]) {
                inorderMid = i;

            }
        }
        node.left = helper(preorder, inorder, low, inorderMid - 1, pIdx+1);
        node.right = helper(preorder, inorder, inorderMid + 1, high, pIdx + inorderMid - low + 1);
        return node;
    }
}
