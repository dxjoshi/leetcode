import java.util.ArrayList;

public class BellmanFord_GFG {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        // Write your code here
        int[] res = new int[V];
        for(int i=0; i<V; i++) {
            res[i] = i==S ? 0 : 100000000;
        }

        for(int i=0; i<V;i++) {
            for (ArrayList<Integer> entry : adj )    {
                int u = entry.get(0);
                int v = entry.get(1);
                int w = entry.get(2);
                res[v] = Math.min(res[v], res[u]+w);

            }
        }

        for (ArrayList<Integer> entry : adj )    {
            int u = entry.get(0);
            int v = entry.get(1);
            int w = entry.get(2);
            if  (res[v] > res[u]+w) {
                System.out.println("Negative Cycle detected!!");
                break;
            }
        }
        return res;
    }

}
