import java.util.*;

/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.
*/

class Pos {
    TreeNode node;
    int x,y;

    Pos(TreeNode node, int x, int y) {
        this.node = node;
        this.x= x;
        this.y = y;
    }
}
public class VerticalOrderTraversalBinaryTree987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pos> q = new LinkedList<>();
        if (root != null) {
            q.add(new Pos(root, 0, 0));
        }

        while (!q.isEmpty())    {
            Pos curr = q.remove();
            TreeNode node = curr.node;
            int x = curr.x;
            int y = curr.y;

            if (!map.containsKey(y)) {
                map.put(y, new TreeMap<>());
            }
            if (!map.get(y).containsKey(x)) {
                map.get(y).put(x, new ArrayList<>());
            }
            map.get(y).get(x).add(node.val);

            if (node.left != null) {
                q.add(new Pos(node.left, x+1, y-1));
            }

            if (node.right != null) {
                q.add(new Pos(node.right, x+1, y+1));
            }

        }
        List<List<Integer>> res = new ArrayList<>();

        for(Map<Integer, List<Integer>> row : map.values())  {
            List<Integer> rows = new ArrayList<>();
            for(List<Integer> list : row.values())  {
                Collections.sort(list);
                rows.addAll(list);
            }
            res.add(rows);
        }
        return res;


    }
}
