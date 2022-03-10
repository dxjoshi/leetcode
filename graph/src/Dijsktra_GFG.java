import java.util.ArrayList;
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
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        int[] res = new int[V];
        for(int i=0; i<V; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[S] = 0;

        // dist-node
        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> a.dist-b.dist);
        pq.add(new Entry(0, S));

        while(!pq.isEmpty())    {
            Entry entry = pq.peek();
            pq.poll();
            int node = entry.node;
            int dist = entry.dist;
            ArrayList<ArrayList<Integer>> entryList = adj.get(node);

            for(ArrayList<Integer> list : entryList)    {
                int cNode = list.get(0);
                int cDist = list.get(1);
                if  (res[cNode] > cDist+res[node]) {
                    res[cNode] = cDist+res[node];
                    Entry cEntry = new Entry(res[cNode], cNode);
                    pq.offer(cEntry);
                }
            }
        }
        return res;
    }
}

