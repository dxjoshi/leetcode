import java.util.*;

class Node2 {
    Node node;
    int hd;

    Node2(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfBinaryTree_GFG {
    static ArrayList<Integer> topView(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node2> q = new LinkedList<>();
        if (root != null) {
            q.add(new Node2(root, 0));
        }
        while(!q.isEmpty()) {
            Node2 node2 = q.remove();
            Node curr = node2.node;
            int hd = node2.hd;
            if (!map.containsKey(hd))   {
                map.put(hd, curr.val);
            }

            if (curr.left != null) {
                q.add(new Node2(curr.left, hd-1));
            }
            if (curr.right != null) {
                q.add(new Node2(curr.right, hd+1));
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(Integer val : map.values()) {
            res.add(val);
        }
        return res;
    }
}
