import java.util.Stack;

/*
*
* 173. Binary Search Tree Iterator
*
* Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
*
* BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
* boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
* int next() Moves the pointer to the right, then returns the number at the pointer.
* Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
*
* You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
*
* */
public class BinarySearchTreeIterator173 {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator173(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

    }
}
