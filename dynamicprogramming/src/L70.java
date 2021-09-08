/*
* 70. Climbing Stairs
*
* You are climbing a staircase. It takes n steps to reach the top.
* Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*
* */
public class L70 {
    public int climbStairs(int n) {
        if (n==0 || n==1) {
            return 1;
        }
        int[] dp = new int[2];
        dp[0] = dp[1] = 1;
        int temp = 0;
        for (int i=2; i<=n; i++) {
            temp = dp[1];
            dp[1] += dp[0];
            dp[0] = temp;
        }

        return dp[1];
    }
}
