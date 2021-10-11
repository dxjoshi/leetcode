import java.util.Arrays;

/*
*
* 1143. Longest Common Subsequence
*
* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
*
* A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
*
* For example, "ace" is a subsequence of "abcde".
* A common subsequence of two strings is a subsequence that is common to both strings.
*
* */
public class LongestCommonSubsequence1143 {
/*
    // Recursive + memiozation
    static int[][] dp = new int[1001][1001];
    public int longestCommonSubsequence(String x, String y) {

        for (int i=0; i< dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(x, y, 0, 0);
    }

    public int solve(String x, String y, int m, int n) {
        //base condition
        if (m >= x.length() || n >= y.length()) return 0;     // LCS(a, b) = 0 if one of the string is empty
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int max = Integer.MIN_VALUE;
        //choice diagram
        if (x.charAt(m) == y.charAt(n)) {
            max = solve(x, y, m+1, n+1) + 1;                 // current char common (+1), now move to next char of both strings
        } else {
            // current char not common, now make 2 choice (move 1 char in one string while staying at same index for other) & find maxof those
            max = Math.max(solve(x, y, m+1, n), solve(x, y, m, n+1));
        }
        dp[m][n] = max;
        return dp[m][n];
    }
*/


    // Top Down
    public static void main(String[] args) {
        longestCommonSubsequence("abcba", "abcbcba");
    }

    public static int longestCommonSubsequence(String x, String y) {
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


/*
    // Top Down with 2 1-D arrays to store curr and prev result
    public int solve(String x, String y) {
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
*/

}
