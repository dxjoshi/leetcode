/*
*
* 1137. N-th Tribonacci Number
*
* The Tribonacci sequence Tn is defined as follows:
* T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
* Given n, return the value of Tn.
*
* */
public class L1137 {
    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        int temp = 0;
        int temp1 = 0;
        for (int i = 3; i<n; i++) {
            temp = dp[2];
            temp1 = dp[1];
            dp[2] += dp[0] + dp[1];
            dp[1] = temp;
            dp[0] = temp1;
        }
        return dp[0] + dp[1] + dp[2];
    }
}
