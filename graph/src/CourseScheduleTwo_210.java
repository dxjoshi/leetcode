import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleTwo_210 {
    //    https://leetcode.com/problems/course-schedule-ii/
    // https://leetcode.com/problems/course-schedule-ii/discuss/59317/Two-AC-solution-in-Java-using-BFS-and-DFS-with-explanation
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            indegree[to]++;
            list.get(from).add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(!q.isEmpty()) {
            Integer v = q.poll();
            res.add(v);
            for(Integer e : list.get(v)) {
                indegree[e]--;
                if(indegree[e] == 0) q.add(e);
            }
        }

        if (res.size() != n) {
            return new int[0];
        }
        int[] result = new int[res.size()];
        for(Integer val : res) {
            result[i++] = val;
        }
        return result;

    }
}
