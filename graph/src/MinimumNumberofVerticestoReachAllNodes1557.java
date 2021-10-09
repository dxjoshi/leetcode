import java.util.ArrayList;
import java.util.List;

/*
*
* 1557. Minimum Number of Vertices to Reach All Nodes
*
* Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
*
* Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
*
* Notice that you can return the vertices in any order.
*
* */
public class MinimumNumberofVerticestoReachAllNodes1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // find all vertices with indegree zero
        boolean[] in = new boolean[n];
        for(List<Integer> edge : edges) {
            in[edge.get(1)] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (in[i] == false) res.add(i);
        }
        return res;
    }

}
