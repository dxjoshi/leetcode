
public class PredAndSuccOfBST {
//    https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1#

    class  Res {
        Node pre, succ;
    }

    class Node {
        int data;
        Node left, right;
    }
    
    public static void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null) return;
        findPreSuc(root.left, p, s, key);
        if (root.data < key) {
            if (p.pre == null || p.pre.data < root.data) {
                p.pre = root;
            }
        } else if (root.data > key) {
            if (s.succ == null || s.succ.data > root.data) {
                s.succ = root;
            }
        }
        findPreSuc(root.right, p, s, key);


    }
}
