public class MatrixChainMultiplication_GFG {
    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp=new int[N][N];
        for(int i=1;i<N;i++) dp[i][i]=0;

        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                int minSteps = Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    int steps=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    if(steps<minSteps) minSteps=steps;
                }
                dp[i][j] = minSteps;
            }
        }
        return dp[1][N-1];
    }
}
