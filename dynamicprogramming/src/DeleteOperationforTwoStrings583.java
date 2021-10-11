/*
*
* 583. Delete Operation for Two Strings
*
* Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
* In one step, you can delete exactly one character in either string.
*
* */
public class DeleteOperationforTwoStrings583 {
    public int minDistance(String word1, String word2) {
        int lcs = lcsOptimizedTopDown(word1, word2);
        return word1.length() + word2.length() - 2*lcs;
    }

    public int lcsOptimizedTopDown(String x, String y) {
        //topdown optimization
        // at any computation only previous result row in needed, Now taking only 2 rows - 1 for curr state and 1 for previous
        // so at any point prev[i] = dp[i-1]
        int m = x.length(), n = y.length();
        int[] dp = new int[n+1];
        int[] prev = new int[n+1];

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                // check current char of both strings, at (i-1) and (j-1)
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[j] = prev[j-1] + 1;                 // current char common (+1), to previous result state of dp[i-1][j-1]
                } else {
                    dp[j] = Math.max(prev[j], dp[j-1]);
                }
            }
            int[] tmp = prev;
            prev = dp;
            dp = tmp;
        }

        return prev[n];
    }

    public int longestCommonSubsequence(String x, String y) {
        //topdown
        int m = x.length(), n = y.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<= m; i++) {
            for (int j=0; j<= n; j++) {
                // LCS(a, b) = 0 if one of the string is empty, therefore initialize 1st row and col of the DP array as such
                if (i==0 || j==0) dp[i][j] = 0;
            }
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                // check current char of both strings, at (i-1) and (j-1)
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;                 // current char common (+1), to previous result state of dp[i-1][j-1]
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
