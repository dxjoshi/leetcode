import java.util.ArrayList;


/*
    class NodeTwo {
        int data;
        NodeTwo left, right;
        NodeTwo(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

public class BoundaryTraversalBinaryTree_Practice {
    static ArrayList <Integer> printBoundary(NodeTwo node) {
        ArrayList <Integer> ans = new ArrayList<>();
        if (isLeaf(node) == false) ans.add(node.data);
        addLeftView(node.left, ans);
        addLeaveNodes(node, ans);
        ArrayList<Integer> list = new ArrayList<>();
        addRightView(node.right, list);
        update(ans, list);
        return ans;
    }

    private static void update(ArrayList<Integer> ans, ArrayList<Integer> list) {
        for (int i = list.size()-1; i>=0 ; i--) {
            ans.add(list.get(i));
        }
    }

    private static boolean isLeaf(NodeTwo node) {
        return (node.left == null && node.right == null);
    }

    private static void addLeaveNodes(NodeTwo root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaveNodes(root.left, res);
        if (root.right != null) addLeaveNodes(root.right, res);
    }

    private static void addRightView(NodeTwo node, ArrayList<Integer> ans) {
        if (node == null) return;
        if (isLeaf(node)) return;
        ans.add(node.data);
        if (node.right != null) addRightView(node.right, ans);
        else addRightView(node.left, ans);
    }

    private static void addLeftView(NodeTwo node, ArrayList<Integer> ans) {
        if (node == null) return;
        if (isLeaf(node)) return;
        ans.add(node.data);
        if (node.left != null) addLeftView(node.left, ans);
        else addLeftView(node.right, ans);
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

