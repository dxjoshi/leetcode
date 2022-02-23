import java.util.ArrayList;

/*
Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph..
*/
public class GraphDFS_GFG {
    int[] vis;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new int[V];
        ArrayList<Integer> res = new ArrayList<Integer>();
        solve(adj, 0, res);
        return res;
        // Code here
    }

    public void solve(ArrayList<ArrayList<Integer>> adj, int itr, ArrayList<Integer> res)    {
        if (vis[itr] == 1)  return;
        vis[itr] = 1;
        res.add(itr);
        for(Integer node : adj.get(itr)) {
            solve(adj, node, res);
        }
    }
}
