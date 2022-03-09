/*
*
* 72. Edit Distance
*
*
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
* You have the following three operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
*
* */

public class EditDistance72 {
/*
*
* Initialization!
* D(i,0) = i
* D(0,j) = j
*
* • Recurrence!Relation:#
*   For each i = 1…M
*    For each j = 1…N
*                   {  D(i-1,j) + 1
*    D(i,j)= min    {  D(i,j-1) + 1
*                   {  D(i-1,j-1) + 2; if X(i) ≠ Y(j)
*                                   0; if X(i) = Y(j)
*
* • Termination:#
* D(N,M) is distance
*
*
* */
public int minDistance(String word1, String word2) {

    int m = word1.length();
    int n = word2.length();
    if  (n == 0) return m;
    if  (m == 0) return n;
    int [][]dp = new int[m+1][n+1];

    for(int i=0; i<=m; i++)  {
        dp[i][0] = i;
    }

    for(int j=0; j<=n; j++)  {
        dp[0][j] = j;
    }

    for(int i=1; i<=m; i++)  {
        for(int j=1; j<=n; j++)  {
            if (word1.charAt(i-1) == word2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = Math.min(dp[i-1][j-1],
                        Math.min(dp[i-1][j], dp[i][j-1]))+1 ;
            }
        }
    }


    return dp[m][n];
}

}
