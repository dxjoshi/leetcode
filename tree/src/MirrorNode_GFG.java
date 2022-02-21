//Given a Binary Tree, convert it into its mirror.
public class MirrorNode_GFG {
    void mirror(Node node) {
        if (node == null) return;
        mirror(node.left);
        mirror(node.right);
        Node left = node.left;
        node.left = node.right;
        node.right = left;
    }
}
