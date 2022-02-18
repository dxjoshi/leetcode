import java.util.ArrayList;

public class LeftViewOfBinaryTreeGFG {
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        solve(root, res, 0);
        return res;
    }

    void solve(Node root, ArrayList<Integer> list, int depth) {
        if (root == null) return;
        if (depth == list.size()) list.add(root.val);
        solve(root.left, list, depth+1);
        solve(root.right, list, depth+1);
    }
}
