/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class MinPathSum62 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i=0; i<m;i++) {
            dp[i][0] = i==0 ? grid[i][0] : grid[i][0] + dp[i-1][0];
        }

        for (int j=0; j<n; j++) {
            dp[0][j] = j==0 ? grid[0][j] : grid[0][j] + dp[0][j-1];
        }

        for (int i=1; i<m;i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

}
