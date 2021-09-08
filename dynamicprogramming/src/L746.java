/*
*
* 746. Min Cost Climbing Stairs
*
* You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
* You can either start from the step with index 0, or the step with index 1.
*
* Return the minimum cost to reach the top of the floor.
*
* */
public class L746 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        for (int i=0; i<cost.length; i++) {
            dp[i] = -1;
        }
        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
    }

    private int solve(int[] cost, int currentFloor, int[] dp) {
        if (currentFloor >= cost.length) {
            return 0;
        }
        if (dp[currentFloor] != -1) {
            return dp[currentFloor];
        }
        dp[currentFloor] = cost[currentFloor] +
                Math.min(solve(cost, currentFloor+1, dp),
                        solve(cost, currentFloor+2, dp));
        return dp[currentFloor];
    }

}
