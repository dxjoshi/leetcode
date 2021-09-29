/*
*
* 117. Populating Next Right Pointers in Each Node II
*
* Given a binary tree
* struct Node {
*   int val;
*   Node *left;
*   Node *right;
*   Node *next;
* }
* Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
* Initially, all next pointers are set to NULL.
*
* */
public class PopulatingNextRightPointersinEachNodeII_117 {
    public Node connect(Node root) {
        Node first = root;
        Node dummy = new Node(0);
        Node pre = dummy;
        while(first!=null){
            while(first!=null){
                if(first.left!=null) {pre.next = first.left; pre = pre.next;}
                if(first.right!=null) {pre.next = first.right; pre = pre.next;}
                first = first.next;
            }
            first = dummy.next;
            dummy.next = null;
            pre = dummy;
        }
        return root;
    }

}
