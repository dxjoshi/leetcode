import java.util.Arrays;

/*
*
* 673. Number of Longest Increasing Subsequence
*
* Given an integer array nums, return the number of longest increasing subsequences.
*
* */
public class NumberofLongestIncreasingSubsequence673 {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;

        int[] length = new int[N];
        int[] count = new int[N];

        Arrays.fill(length,1);//each number is a subsequence
        Arrays.fill(count,1);//since each number is a subsequence, the LIS for a single element array is 1

        for(int i = 1 ; i < nums.length; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    if(1 + length[j] > length[i]){
                        length[i] = 1 + length[j];
                        count[i] = count[j];
                    }else if(1 + length[j] == length[i]){
                        count[i] += count[j];
                    }
                }
            }
        }

        int max = 0;
        for(int i: length){
            max = Math.max(i,max);
        }

        int ans = 0;
        for(int i = 0; i < N; ++i){
            if(length[i] == max){
                ans += count[i];
            }
        }

        return ans;
    }
}
