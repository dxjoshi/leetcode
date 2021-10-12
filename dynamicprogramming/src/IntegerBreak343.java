import java.util.Arrays;

/*
*
* 343. Integer Break
*
* Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
* Return the maximum product you can get.
*
*
* */
public class IntegerBreak343 {
    // Recursion --> Recursion + Memo --> Top Down
    static int[][] dp = new int[59][59];
    int integerBreak(int n)
    {
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return recursion(n, n - 1);
    }

    int recursion(int n, int cur)
    {
        // base
        if (n == 0 || cur == 0) {
            return 1;
        }
        if (dp[n][cur] != -1) return dp[n][cur];

        // recurisve
        if (cur > n) {
            return dp[n][cur] = recursion(n - 0, cur - 1);
        }
        else {
            return dp[n][cur] = Math.max(recursion(n - 0, cur - 1), cur * recursion(n - cur, cur));
        }
    }

}
