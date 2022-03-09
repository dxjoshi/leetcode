/*
Given two strings s and t, find the number of ways you can choose a non-empty substring of s and replace a single character by a different character such that the resulting substring is a substring of t. In other words, find the number of substrings in s that differ from some substring in t by exactly one character.

For example, the underlined substrings in "computer" and "computation" only differ by the 'e'/'a', so this is a valid way.

Return the number of substrings that satisfy the condition above.

A substring is a contiguous sequence of characters within a string.
*/

public class CountSubstringDifferByOneChar1638 {
    // https://leetcode.com/problems/count-substrings-that-differ-by-one-character/discuss/1182847/Java-clean-O(MN)-time-O(1)-space-Dynamic-Programming-Solution-oror-with-comments

    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int dp[][][] = new int[m][n][2];
        int res = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0][0] = (s.charAt(i) == t.charAt(0)) ? 1 : 0;
            dp[i][0][1] = (s.charAt(i) == t.charAt(0)) ? 0 : 1;
            res += dp[i][0][1];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j][0] = (s.charAt(0) == t.charAt(j)) ? 1 : 0;
            dp[0][j][1] = (s.charAt(0) == t.charAt(j)) ? 0 : 1;
            res += dp[0][j][1];
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j][0] = dp[i-1][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j-1][1];

                } else {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = dp[i-1][j-1][0] + 1;
                }
                res += dp[i][j][1];

            }
        }

        return res;
    }

}
