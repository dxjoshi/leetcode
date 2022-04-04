/*
DS and Algo discussion with Deepak Joshi
        —------------------------------------------------------

        You are given a set of tasks to be executed and their dependencies. Suppose tasks 2 and 3 can only be started after task 1, then, 2 and 3 are in the list of 1.

        In addition to this data, you are given the execution time of tasks. Execution time of a task is >= 0. A task once started will not be interrupted. Once it is started, it will finish after the specified time.

        Example:
        1: 2, 3
        2: 4, 5
        3: 4
        4: 6
        7: 3

        Execution time:
        task  time
        1	2
        2	3
        3	2
        4	4
        5	9
        6	5
        7	4

        Problem:  Find the minimum amount of time required to complete all tasks.
        Answer (output): Minimum time required: 15 units.
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demandbase_Graph_R1 {

/*
create an indegree arr
Maintain a queue of vertices that can be processed, based on indegree == 0
for each element in queue check for adjacent vertices, update their indegree values,
if indegree == 0 add them to the queue
maintain the time taken at each point, max of each incoming node, use an array of    vertices for it
repeat until queue if empty;
maintain a max for returning result;
*/

    public int max(List<Integer> times) {
        Integer max = 0;
        for (Integer val : times) {
            max = Math.max(max, val);
        }
        return max;
    }

    public int minTime(List<List<Integer>> adj, List<Integer> times) {
        int n = times.size();
        int[] indegree = new int[n + 1];
        int[] cost = new int[n + 1];

        for (int i = 0; i < times.size(); i++) {
            cost[i + 1] = times.get(i);
        }

        int maxCost = 0;
        if (adj.size() == 0) {
            return max(times);
        }

        for (List<Integer> list : adj) {
            for (Integer v : list) {
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int max = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            Integer timeTaken = cost[node]; // to execute task node  4
            for (Integer v : adj.get(node)) {
                cost[v] = Math.max(cost[v], timeTaken + times.get(v - 1));
                max = Math.max(cost[v], max);
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }
        return max;
    }
}


