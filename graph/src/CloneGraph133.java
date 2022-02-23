import java.util.*;

/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
public int val;
public List<Node> neighbors;
}


Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
*/
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph133 {

    public HashMap<Integer, Node> map = new HashMap<>();

    // public Node cloneGraph(Node node) {
    //     return clone(node);
    // }

    public Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        return newNode;
    }

    // BFS approach: https://leetcode.com/problems/clone-graph/discuss/42319/Simple-Java-iterative-BFS-solution-with-HashMap-and-queue
//     public Node cloneGraph(Node node) {
//         if (node == null) return null;

//         // **new node to return
//         // MUST BE DEFINED OUTSIDE SO THAT IT CAN BE RETURNED
//         Node newNode = new Node(node.val, new ArrayList<>());
//         // store visited nodes
//         // key is the ORIGINAL node, value is the NEW node
//         HashMap<Node, Node> map = new HashMap();
//         // add starting node to HashMap
//         map.put(node, newNode);

//         // store ORIGINAL nodes to be visited in a queue
//         Queue<Node> queue = new LinkedList();
//         // add the start node to the queue
//         queue.add(node);
//         //if more nodes need to be visited
//         while (!queue.isEmpty()) {
//             //search neighbors of top node in the queue
//             Node polledOrigNode = queue.poll();

//             // if node 1 has neighbors 2 and 3
//             for (Node origNeighbor : polledOrigNode.neighbors) {
//                 // if the map does not contain the neighbor that means
//                 // the node needs to be cloned and added to map
//                 // check if map contains 2 then 3
//                 if (!map.containsKey(origNeighbor)) {
//                     // if map does not contain 2 or 3 create a clone 2c, 3c
//                     Node newNeighborNode = new Node(origNeighbor.val, new ArrayList<>());
//                     // add 2,2c to map and 3,3c
//                     map.put(origNeighbor, newNeighborNode);
//                     // add 2,3 to queue
//                     queue.add(origNeighbor);
//                 }
//                 // get the cloned node of the original node
//                 // add the new neighbor to the cloned nodes neighbor list
//                 // get 1c from map to its neighbors, add 2c and 3c
//                 map.get(polledOrigNode).neighbors.add(map.get(origNeighbor));
//             }
//         }

//         return newNode;
//     }


    // https://leetcode.com/problems/clone-graph/discuss/42482/Java-BFS-solution
    // O(n^2) time where n is the number of nodes. This is because for each node we iterate through all its neighbours and in the worst case all nodes are connected to each other.
    // O(n) space because we have exactly one map entry for each node and each node gets added and removed from the queue exactly once.
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();      // Maps a node from original graph to the corresponding node in the cloned graph.
        Deque<Node> queue = new ArrayDeque<>();     // Do a BFS to create a copy of all nodes and create a copy of all edges.
        map.put(node, new Node(node.val));
        queue.addLast(node);
        while (queue.size() > 0) {
            Node currNode = queue.removeFirst();
            // Create edges for currNode in the cloned graph.
            for (Node currNeighbor : currNode.neighbors) {
                if (!map.containsKey(currNeighbor)) {
                    map.put(currNeighbor, new Node(currNeighbor.val));         // Create a copy of currNeighbor.
                    queue.addLast(currNeighbor);                               // Add currNeighbor to the queue so that its edges will be added to the cloned graph.
                }
                map.get(currNode).neighbors.add(map.get(currNeighbor));       // Create the edge between currNode and the currNeighbor in the cloned graph.
            }
        }
        return map.get(node);
    }
}
