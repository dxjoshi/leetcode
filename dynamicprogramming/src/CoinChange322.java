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
}
