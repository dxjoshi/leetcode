import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_Prims_GFG {
//    https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
    static class Node {
        int dist, node;
        Node(int d, int n) {
            dist = d;
            node = n;
        }
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {

        int[] key = new int[V];
        boolean[] vis = new boolean[V];
        int[] par = new int[V];

        for(int i=0; i<V; i++)  {
            key[i] = i == 0 ? 0 : Integer.MAX_VALUE;
            par[i] = -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Node(0,0));
        vis[0] = true;

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            ArrayList<ArrayList<Integer>> edges = adj.get(curr.node);
            vis[curr.node] = true;

            for(ArrayList<Integer> edge : edges)    {
                int toNode = edge.get(0);
                int dist = edge.get(1);
                if (vis[toNode] == true) continue;
                if (dist < key[toNode])    {
                    key[toNode] = dist;
                    par[toNode] = curr.node;
                    pq.offer(new Node(key[toNode], toNode));
                }
            }
        }

        int res = 0;
        for(int i=0; i<V; i++)  {
            res += key[i];
        }

        return res;

    }

}
