import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://takeuforward.org/data-structure/dijkstras-algorithm-shortest-distance/
public class Dijsktra_GFG {
    static class Entry {
        int dist , node;
        Entry(int d, int n) {
            dist = d;
            node = n;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[S] = 0;

        // dist-node
        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Entry(0, S));

        while(!pq.isEmpty())    {
            Entry entry = pq.poll();
            int node = entry.node;
            for(ArrayList<Integer> list : adj.get(node))    {
                int cNode = list.get(0);
                int cDist = list.get(1);
                if  (res[cNode] > cDist+res[node]) {
                    res[cNode] = cDist+res[node];
                    pq.offer(new Entry(res[cNode], cNode));
                }
            }
        }
        return res;
    }
}

