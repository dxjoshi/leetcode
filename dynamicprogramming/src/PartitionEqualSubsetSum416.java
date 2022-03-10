/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
*/

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += nums[i];
        }
        if (sum%2 != 0) return false;
        sum = sum/2;
        int [][]dp = new int[n+1][sum+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=sum; j++) {
                if  (i==0|| j==0) {
                    dp[i][j] = 0;
                } else if (nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else if  (nums[i-1] == j){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i-1][j] == 1 || dp[i-1][j-nums[i-1]] == 1) ? 1 : 0;
                }
            }
        }
        return dp[n][sum] == 1;
    }
}
