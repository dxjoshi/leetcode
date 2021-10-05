/*
*
* 108. Convert Sorted Array to Binary Search Tree
*
* Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
* A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
*
* */
public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high-low) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
