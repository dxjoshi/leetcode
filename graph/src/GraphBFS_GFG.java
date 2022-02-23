import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.
*/
public class GraphBFS_GFG {
    int[] vis;
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new int[V];
        ArrayList<Integer> res = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while (q.size() > 0)    {
            Integer node = q.poll();
            if (vis[node] == 1) continue;
            vis[node] = 1;
            res.add(node);
            for(Integer nbor : adj.get(node))  {
                q.add(nbor);
            }
        }
        return res;
    }
}
