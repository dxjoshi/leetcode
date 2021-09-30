import java.util.ArrayList;
import java.util.List;

/*
*
* 797. All Paths From Source to Target
*
* Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
* The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
*
* */
public class AllPathsFromSourcetoTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> walk = new ArrayList<Integer>();
        walk.add(0);
        solve(graph, 0, walk, res);
        return res;
    }

    public void solve(int[][] graph, int row, List<Integer> walk, List<List<Integer>> res) {
        if (row == graph.length-1) {
            res.add(new ArrayList<>(walk));
            return;
        }

        for(int i=0; i<graph[row].length; i++) {
            walk.add(graph[row][i]);
            solve(graph, graph[row][i], walk, res);
            walk.remove(walk.size()-1);
        }
    }
}
