/*
*
* 300. Longest Increasing Subsequence
*
* Given an integer array nums, return the length of the longest strictly increasing subsequence.
* A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
*
* */
public class LongestIncreasingSubsequence300 {
    static int[][] dp = new int[2501][2501];
    static int[] arr = new int[2501];
    public int lengthOfLIS(int[] nums) {
        // recursive: TLE
        //return solve(nums, 0, Integer.MIN_VALUE);

        // recursive with Memo: TLE
        // for (int[] arr : dp) Arrays.fill(arr, -1);
        // return lisMemo(nums, 0, -1);

        // recursive with Memo Optimized: TLE
        // Arrays.fill(arr, -1);
        // return lisMemoOpt(nums, 0, -1);

        // TopDown
        //return lisTopDown(nums);
        //Binary Search
        return binarySearch(nums);
    }

    public int solve(int[] nums, int curr, int prev) {
        if (curr >= nums.length) return 0;     // When no elements left in arry return 0
        int dontTake = solve(nums, curr+1, prev);    // not taking the current number
        int take = 0;
        if (nums[curr] > prev) {
            take = 1+solve(nums, curr+1, nums[curr]);
        }
        return Math.max(take, dontTake);
    }

    public int lisMemo(int[] nums, int curr, int prevIdx) {
        if (curr >= nums.length) return 0;     // When no elements left in array return 0
        if (dp[curr][prevIdx+1] != -1) return dp[curr][prevIdx+1];

        int dontTake = solve(nums, curr+1, prevIdx);    // not taking the current number
        int take = 0;
        if (prevIdx == -1 || nums[curr] > nums[prevIdx]) {
            take = 1 + solve(nums, curr+1, nums[curr]);
        }
        dp[curr][prevIdx+1] = Math.max(take, dontTake);
        return dp[curr][prevIdx+1];
    }

    public int lisMemoOpt(int[] nums, int curr, int prevIdx) {
        if (curr >= nums.length) return 0;     // When no elements left in array return 0
        if (arr[prevIdx+1] != -1) return arr[prevIdx+1];

        int dontTake = solve(nums, curr+1, prevIdx);    // not taking the current number
        int take = 0;
        if (prevIdx == -1 || nums[curr] > nums[prevIdx]) {
            take = 1 + solve(nums, curr+1, nums[curr]);
        }
        arr[prevIdx+1] = Math.max(take, dontTake);
        return arr[prevIdx+1];
    }

    public int lisTopDown(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length, max = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int binarySearch(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
