import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
//    https://takeuforward.org/data-structure/topological-sort-using-dfs/
    static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                findTopoSort(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    static int[] topoSort1(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>();
        int vis[] = new int[N];

        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                findTopoSort(i, vis, adj, st);
            }
        }

        int topo[] = new int[N];
        int ind = 0;
        while(!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        // for(int i = 0;i<N;i++) System.out.println(topo[i] + " ");
        return topo;
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> res = new Stack<Integer>();
        for(int i = 0; i< V; i++) {
            dfs(adj, vis, res, i);
        }

        int[] topo = new int[V];
        for(int i=0; i<res.size(); i++) {
            if  (vis[i] == 0)
                topo[i] = res.pop();
        }
        return topo;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> res, int node) {
        if (vis[node] != 0) return;
        vis[node] = 1;
        for(int i : adj.get(node))   {
            dfs(adj, vis, res, i);
        }
        res.push(node);
    }


}
