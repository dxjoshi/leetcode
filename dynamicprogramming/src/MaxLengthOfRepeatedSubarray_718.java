public class MaxLengthOfRepeatedSubarray_718 {
//    https://leetcode.com/problems/maximum-length-of-repeated-subarray/

    // https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109039/Concise-Java-DP%3A-Same-idea-of-Longest-Common-Substring

    // dp[i][j] is the length of longest common subarray ending with nums[i-1] and nums[j-1]
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];

        int max = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
}
