public class EggDropping_GFG {
    static int eggDrop(int n, int k)
    {
        // Your code here
        int[][] dp = new int[k+1][n+1];

        for(int i=0; i<=k; i++)  {
            dp[i][0] = 0;
            dp[i][1] = i;       //base case for f floors and 1 egg
        }


        for(int i=0; i<=n; i++)  {
            dp[0][i] = 0;    //bc 0 floor and i eggs
            dp[1][i] = 1;    //bc 1 floor and i eggs
        }

        for(int i=2; i<=k; i++)  {
            for(int j=2; j<=n; j++)  {
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1; x<=i; x++) {

                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-x][j], dp[x-1][j-1])) ;
                }
            }
        }

        return dp[k][n];
    }

}
