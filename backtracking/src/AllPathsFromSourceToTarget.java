/*
*
* 797. All Paths From Source to Target
*
* Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
* The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
* 
* */
import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if  (graph == null || graph.length == 0) return result;

        path.add(0);
        solve(graph, result, path, 0);
        return result;
    }

    public void solve(int[][] graph, List<List<Integer>> result, List<Integer> path, int currentNode) {
        if  (currentNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i< graph[currentNode].length; i++) {
            int node = graph[currentNode][i];
            path.add(node);
            solve(graph, result, path, node);
            path.remove(Integer.valueOf(node));

        }

    }
}