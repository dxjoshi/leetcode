/*
*
* 116. Populating Next Right Pointers in Each Node
*
* You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
*
* struct Node {
*   int val;
*   Node *left;
*   Node *right;
*   Node *next;
* }
* Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
*
*
 * */
public class PopulatingNextRightPointersinEachNode116 {
    public Node connect(Node root) {
        Node res = root;
        while(root != null && root.left != null) {
            Node cur = root;
            while(cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
        return res;
    }
}
