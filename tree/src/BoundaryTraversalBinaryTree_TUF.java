import java.util.ArrayList;

class NodeTwo {
    int data;
    NodeTwo left, right;
    NodeTwo(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


public class BoundaryTraversalBinaryTree_TUF {
    static Boolean isLeaf(NodeTwo root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(NodeTwo root, ArrayList < Integer > res) {
        NodeTwo cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    static void addRightBoundary(NodeTwo root, ArrayList < Integer > res) {
        NodeTwo cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    static void addLeaves(NodeTwo root, ArrayList < Integer > res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
    static ArrayList < Integer > printBoundary(NodeTwo node) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (isLeaf(node) == false) ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }

    public static void main(String args[]) {
        NodeTwo root = new NodeTwo(1);
        root.left = new NodeTwo(2);
        root.left.left = new NodeTwo(3);
        root.left.left.right = new NodeTwo(4);
        root.left.left.right.left = new NodeTwo(5);
        root.left.left.right.right = new NodeTwo(6);
        root.right = new NodeTwo(7);
        root.right.right = new NodeTwo(8);
        root.right.right.left = new NodeTwo(9);
        root.right.right.left.left = new NodeTwo(10);
        root.right.right.left.right = new NodeTwo(11);

        ArrayList< Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
    }
}

