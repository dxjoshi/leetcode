import java.util.Arrays;

/*
*
* 322. Coin Change
*
* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
*
* Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
*
* You may assume that you have an infinite number of each kind of coin.
*
* */
public class CoinChange322 {
    static int[][] dp  = new int[12+1][10000+1];
    public int coinChange(int[] coins, int amount) {
        for(int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        int result = solve(coins, amount, 0);
        return result == Integer.MAX_VALUE-1 ? -1 : result;
    }

    public int solve(int[] coins, int amount, int i) {
        if (amount == 0) return 0;
        if (i==coins.length) return  amount == 0 ? 0 : Integer.MAX_VALUE-1;
        if (dp[i+1][amount] != -1) return dp[i+1][amount];

        if (coins[i] <= amount) {
            return dp[i+1][amount] = Math.min(1+solve(coins, amount-coins[i], i), solve(coins, amount, i+1));
        } else {
            return dp[i+1][amount] = solve(coins, amount, i+1);
        }
    }

    // https://leetcode.com/problems/coin-change/discuss/1274300/Java-DP-Explained-with-comments-Super-Simple
    // https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations

    public int coinChangeTwo(int[] coins, int amount) {
        int[][] dp  = new int[coins.length+1][amount+1];
        for (int i = 0; i<=coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j<=amount; j++) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }

        for (int i = 1; i<=coins.length; i++) {
            for (int j = 1; j<=amount; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j- coins[i-1]] + 1) ;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount] != Integer.MAX_VALUE-1 ? dp[coins.length][amount]: -1 ;

    }

}
