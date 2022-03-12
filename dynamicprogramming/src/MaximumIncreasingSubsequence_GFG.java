public class MaximumIncreasingSubsequence_GFG {
    public int maxSumIS(int arr[], int n) {
        int dp[] = new int[n];

        for(int i=0 ; i<n ; i++){

            dp[i] = arr[i];

            for(int j=0 ; j<i ; j++){
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i] , dp[j] + arr[i]);
            }
        }
        int ans = 0;
        for(int i=0 ; i<n ; i++){
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}
