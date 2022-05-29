## Popular Dynamic Programming questions' solution

|||
|---|---|
|[Climbing Stairs](#climbing-stairs)|[Maximum Product Subarray](#maximum-product-subarray)|
|[Min Cost Climbing Stairs](#min-cost-climbing-stairs)|[Longest Increasing Subsequence](#longest-increasing-subsequence)|
|[House Robber](#house-robber)|[Number of Longest Increasing Subsequence](#number-of-longest-increasing-subsequence)|
|[House Robber II](#house-robber-II)|[Longest Common Subsequence](#longest-common-subsequence)|
|[Delete and Earn](#delete-and-earn)|[Ones and Zeroes](#ones-and-zeroes)|
|[Triangle](#triangle)|[Edit Distance](#edit-distance)|
|[01 Matrix](#01-matrix)|[Maximum sum increasing subsequence](#maximum-sum-increasing-subsequence)|
|[Integer Break](#integer-break)|[Matrix Chain Multiplication](#matrix-chain-multiplication)|
|[Maximum Sum Circular Subarray](#maximum-sum-circular-subarray)|[Minimum Path Sum](#minimum-path-sum)|
|[Maximum Length of Subarray With Positive Product](#maximum-length-of-subarray-with-positive-product)|[Coin Change](#coin-change)|
|[Best Sightseeing Pair](#Best-Sightseeing-Pair)|[Partition Equal Subset Sum](#partition-equal-subset-sum)|
|[Best Time to Buy and Sell Stock](#best-time-to-buy-and-sell-stock)|[Minimum Cost to Cut a Stick](#minimum-cost-to-cut-a-stick)|
|[Best Time to Buy and Sell Stock II](#best-time-to-buy-and-sell-stock-ii)|[Egg Dropping Puzzle](#egg-dropping-puzzle)|
|[Best Time to Buy and Sell Stock with Cooldown](#best-time-to-buy-and-sell-stock-with-cooldown)|[Word Break](#word-break)|
|[Best Time to Buy and Sell Stock with Transaction Fee](#best-time-to-buy-and-sell-stock-with-transaction-fee)|[Palindromic patitioning](#palindromic-patitioning)|
|[Longest Repeated Subsequence](#longest-repeated-subsequence)| 

### Climbing Stairs     
- [https://leetcode.com/problems/climbing-stairs/](https://leetcode.com/problems/climbing-stairs/)      


            public int climbStairs(int n) {
                // if (n >= 0 && n <=2) return n;
                // return climbStairs(n-1) + climbStairs(n-2);
                if (n == 1 || n == 2) return n;
                int first = 1;
                int second = 2;
                for(int i=3; i<=n; i++) {
                    int temp = second;
                    second += first; 
                    first = temp;
                }
                return second;
            }

### Min Cost Climbing Stairs            
- [https://leetcode.com/problems/min-cost-climbing-stairs/](https://leetcode.com/problems/min-cost-climbing-stairs/)            


            // https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
            public int minCostClimbingStairs(int[] cost) {
                int n= cost.length;
                int[] dp = new int[n];
                dp[0] = cost[0];
                dp[1] = cost[1];
                for(int i=2; i<n; i++) {
                    dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
                }
                return Math.min(dp[n-1], dp[n-2]);
            }
            
            public int minCostClimbingStairs(int[] cost) {
                return Math.min(solve(cost, 0), solve(cost, 1));
            }
            
            public int solve(int[] cost, int i) {
                if (i >= cost.length) return 0;
                return Math.min(solve(cost, i+1), solve(cost, i+2)) + cost[i];
            }
            
### House Robber        
- [https://leetcode.com/problems/house-robber/](https://leetcode.com/problems/house-robber/)            


            public int rob(int[] nums) {
                int n = nums.length;
                int[] dp = new int[n+1];
                dp[1] = nums[0];
                for(int i=1; i<n; i++) {
                    dp[i+1] = Math.max(dp[i], nums[i] + dp[i-1]);
                }
                return dp[n];
            }
            
### House Robber II         
- [https://leetcode.com/problems/house-robber-ii/](https://leetcode.com/problems/house-robber-ii/)      


            public int rob(int[] nums) {
                    int n = nums.length;
                    if(n == 1) return nums[0];
                    return Math.max(houseRob(nums, 0, n - 2), houseRob(nums, 1, n - 1));
                }
            
            private int houseRob(int[] nums, int start, int end) {
                int prev = 0, curr = 0;
                for(int i = start; i <= end; i++) {
                    int value = Math.max(prev + nums[i], curr);
                    prev = curr;
                    curr = value;
                }
                return curr;
            }            
            
### Delete and Earn
- [https://leetcode.com/problems/delete-and-earn/](https://leetcode.com/problems/delete-and-earn/)   


            public int deleteAndEarn(int[] nums) {
                int n = 10001;
                int[] values = new int[n];
                for(int num : nums) values[num] += num;
                
                int take=0;
                int skip=0;
                for(int i=0; i<n; i++) {
                    int takei = values[i]+skip;
                    int skipi = Math.max(skip, take);
                    take = takei;
                    skip = skipi;
                }
                return Math.max(take, skip);
            }    
            
### Triangle            
- [https://leetcode.com/problems/triangle/](https://leetcode.com/problems/triangle/)


            public int minimumTotal(List<List<Integer>> triangle) {
                int[][]dp = new int[triangle.size()][triangle.size()];
                //Remember base case is just returning leaf nodes
                for (int i = 0; i < triangle.size(); i++){
                    dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
                }
        
                for (int row = triangle.size()-2; row >= 0; row--){
                    for (int pos = 0; pos < triangle.get(row).size(); pos++){
                        dp[row][pos] = triangle.get(row).get(pos) + Math.min(dp[row+1][pos+1], dp[row+1][pos]);
                    }
                }
        
                return dp[0][0];
            }                 
            
### 01 Matrix       
- [https://leetcode.com/problems/01-matrix/](https://leetcode.com/problems/01-matrix/)          


            public int[][] updateMatrix(int[][] mat) {
                // The distance of cells is up to (M+N)
                // First check the valid top and left cells for each cell -> Then check the bottom and right cell for each cell(start iterating from last cell of 2D array)
                int m = mat.length, n = mat[0].length, INF = m + n; 
                for (int r = 0; r < m; r++) {
                    for (int c = 0; c < n; c++) {
                        if (mat[r][c] == 0) continue;
                        int top = INF, left = INF;
                        if (r - 1 >= 0) top = mat[r - 1][c];
                        if (c - 1 >= 0) left = mat[r][c - 1];
                        mat[r][c] = Math.min(top, left) + 1;
                    }
                }
                for (int r = m - 1; r >= 0; r--) {
                    for (int c = n - 1; c >= 0; c--) {
                        if (mat[r][c] == 0) continue;
                        int bottom = INF, right = INF;
                        if (r + 1 < m) bottom = mat[r + 1][c];
                        if (c + 1 < n) right = mat[r][c + 1];
                        mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
                    }
                }
                return mat;
            }
   
### Integer Break           
- [https://leetcode.com/problems/integer-break/](https://leetcode.com/problems/integer-break/)


            public int integerBreak(int n) {
                //dp[i] means output when input = i, e.g. dp[4] = 4 (2*2),dp[8] = 18 (2*2*3)...
                if (n == 0) return 0;
                int[] dp = new int[n + 1];
                dp[0] = 1;
                for (int i = 1; i < n; i++) {
                    for (int j = i; j <= n; j++) {
                        dp[j] = Math.max(dp[j], dp[j - i] * i);
                    }
                }
                return dp[n];
            }     
            
### Maximum Sum Circular Subarray           
- [https://leetcode.com/problems/maximum-sum-circular-subarray/](https://leetcode.com/problems/maximum-sum-circular-subarray/)                   


            public int maxSubarraySumCircular(int[] nums) {
                int n = nums.length;
                int maxSoFar, maxEndingHere;
                for (int i=0; i<n; i++) {
                    for (int j=i; j<i+n-1; j++) {
                        int index = j % n;
                        maxEndingHere = Math.max(nums[index] + maxEndingHere, nums[index]);
                        maxSoFar = Math.max(maxEndingHere, maxSoFar);
                    }   
                }
                return maxSoFar;
            }
            
### Maximum Length of Subarray With Positive Product        
- [https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/](https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/)                    


            public int getMaxLen(int[] nums) {
                int positive = 0, negative = 0;    // length of positive and negative results
                int ans = 0;
                for(int x : nums) {
                    if(x == 0)  {
                        positive = 0;
                        negative = 0;
                    } else if(x > 0) {
                        positive++;
                        negative = negative == 0 ? 0  : negative+1;
                    } else {
                        int temp = positive;
                        positive = negative == 0 ? 0  : negative+1;
                        negative = temp+1;
                    }
                    ans = Math.max(ans, positive);
                }
                return ans;
            }
            
### Best Sightseeing Pair          
- [https://leetcode.com/problems/best-sightseeing-pair/](https://leetcode.com/problems/best-sightseeing-pair/)


            public int maxScoreSightseeingPair(int[] values) {
                int max = Integer.MIN_VALUE;
                int i = 0;
                int curr = values[i] + i;
                for(int j=1; j<values.length; j++) {
                    curr = values[i] + i;
                    max = Math.max(max, curr + values[j] - j);
                    if (values[j] + j > curr) {
                        i = j;
                    }
                }
                return max;
            }   
         
### Best Time to Buy and Sell Stock         
- [https://leetcode.com/problems/best-time-to-buy-and-sell-stock/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)      


            public int maxProfit(int[] prices) {
                if  (prices == null || prices.length == 0) return 0;
                int minPrice = Integer.MAX_VALUE;
                int profit = 0;
                for (int i=0; i<= prices.length-1; i++) {
                    minPrice = Math.min(prices[i], minPrice);
                    profit = Math.max(profit, prices[i] - minPrice);
                }
        
                return profit;    
            }   
                     
### Best Time to Buy and Sell Stock II          
- [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)        


            public int maxProfit(int[] prices) {
                int profit = 0;
                for (int i = 1; i < prices.length; i++) 
                    profit += Math.max(0, prices[i] - prices[i - 1]);
                return profit;
            }      

### Best Time to Buy and Sell Stock with Cooldown       
- [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)          


            public int maxProfit(int[] prices) {
                if(prices == null || prices.length == 0) return 0;
                
                int n = prices.length;
                int[] M = new int[n];
                int maxDiff = Integer.MIN_VALUE; // M[j - 2] - prices[j]
                for(int i = 0; i < n; i++){
                    if(i < 2) maxDiff = Math.max(maxDiff, -prices[i]);
                    if(i == 0) M[0] = 0;
                    else if(i == 1) M[1] = Math.max(prices[1] - prices[0], 0);
                    else{
                        M[i] = Math.max(M[i - 1], maxDiff + prices[i]);
                        maxDiff = Math.max(maxDiff, M[i - 2] - prices[i]);
                    }
                }
                        
                return M[n - 1];
            }

### Best Time to Buy and Sell Stock with Transaction Fee
- [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)                  


            public int maxProfit(int[] prices, int fee) {
                    if (prices.length <= 1) return 0;
                    int days = prices.length, buy[] = new int[days], sell[] = new int[days];
                    buy[0]=-prices[0];
                    for (int i = 1; i<days; i++) {
                        // keep the same as day i-1, or buy from sell status at day i-1
                        buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]); 
                        // keep the same as day i-1, or sell from buy status at day i-1
                        sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee); 
                    }
                    return sell[days - 1];
                }                                   
### Longest Repeated Subsequence	
- [https://leetcode.com/discuss/general-discussion/1274765/longest-repeated-subsequence-lrs](https://leetcode.com/discuss/general-discussion/1274765/longest-repeated-subsequence-lrs)          


            int LRS(string X, string Y) {           
                int m=X.length();
                int n=Y.length();
                int dp[m+1][n+1];
                
                // initialization
                for(int i=0;i<=m;i++)
                    dp[i][0]=0;   // Eg LCS of "abc" & "" = 0
                for(int j=0;j<=n;j++)
                    dp[0][j]=0;   // Eg LCS of "" & "abc" = 0
                
                for(int i=1;i<=m;i++) {
                    for(int j=1;j<=n;j++) {
                        if(X[i-1]==Y[j-1] && i!=j)     // this is the only extra condition
                            dp[i][j]=1+dp[i-1][j-1];
                        else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
                return dp[m][n];
            }

            String getSubsequence(int[][] dp) {
                string res = "";
                // Traverse dp[][] from bottom right
                int i = n, j = n;
                while (i > 0 && j > 0) {
                    // If this cell is same as diagonally adjacent cell just above it, then same characters are present at str[i-1] and str[j-1]. Append any of them to result.
                    if (dp[i][j] == dp[i-1][j-1] + 1) {
                       res = res + str[i-1];
                       i--;
                       j--;
                    } else if (dp[i][j] == dp[i-1][j]) { // Otherwise we move to the side that that gave us maximum result
                        i--;
                    } else  j--;
                }
                // Since we traverse dp[][] from bottom, we get result in reverse order.
                reverse(res.begin(), res.end());
                return res;
            }

### Maximum Product Subarray        
- [https://leetcode.com/problems/maximum-product-subarray/](https://leetcode.com/problems/maximum-product-subarray/)              


            public int maxProduct(int[] nums) {
                int len = nums.length;
                int res = nums[0];
                int lMin = nums[0];
                int lMax = nums[0];
                
                for(int i=1; i<len; i++) {
                    if (nums[i] <0) {
                        int temp = lMin;
                        lMin = lMax;
                        lMax = temp;
                    }
                    lMin = Math.min(nums[i], lMin*nums[i]);
                    lMax = Math.max(nums[i], lMax*nums[i]);
                    res = Math.max(res, lMax);
                }
                
                return res;
            }
            
### Longest Increasing Subsequence          
- [https://leetcode.com/problems/longest-increasing-subsequence/](https://leetcode.com/problems/longest-increasing-subsequence/)        


            public int lengthOfLIS(int[] nums) {
                int n = nums.length;
                int[] dp = new int[n];
                Arrays.fill(dp, 1);
                int max = 1;
                for(int i=1; i < n; i++){
                    for(int j=0; j <= i-1; j++){
                        if(nums[i] > nums[j])
                            dp[i] = Math.max(dp[i], 1 + dp[j]);
                    }
                    max = Math.max(max, dp[i]);
                }
                return max;
            }  
            

### Number of Longest Increasing Subsequence            
- [https://leetcode.com/problems/number-of-longest-increasing-subsequence/](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)                      


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
            
### Longest Common Subsequence                  
- [https://leetcode.com/problems/longest-common-subsequence/](https://leetcode.com/problems/longest-common-subsequence/)


            public int longestCommonSubsequence(String x, String y) {
               return solve(x, y);
            }
            
            public int solve(String x, String y) {
                int n = x.length();
                int m = y.length();
                int[][] dp = new int[n+1][m+1];
                
                for(int i=1; i<=n; i++) {
                    for(int j=1; j<=m; j++) {
                        if (x.charAt(i-1) == y.charAt(j-1)) {
                            dp[i][j] = dp[i-1][j-1] + 1;
                        } else {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                        }
                    }   
                }
                return dp[n][m];
            }                
            
### Ones and Zeroes     
- [https://leetcode.com/problems/ones-and-zeroes/](https://leetcode.com/problems/ones-and-zeroes/)          


            public int findMaxForm(String[] strs, int m, int n) {
                int[][] dp = new int[m+1][n+1];
                for(String str : strs) {
                    int ones = 0, zeros = 0;
                    for(int i = 0; i< str.length(); i++) {
                        if(str.charAt(i) == '1') {
                            ones++;
                        } else {
                            zeros++;
                        }
                    }
                    
                    for(int i= m; i>= zeros; i--) {
                        for(int j=n; j>=ones; j--) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                        }
                    }
                }
                return dp[m][n];
            }            
            
### Edit Distance       
- [https://leetcode.com/problems/edit-distance/](https://leetcode.com/problems/edit-distance/)        


            public int minDistance(String word1, String word2) {
                int m = word1.length();
                int n = word2.length();
                int[][] dp = new int[m+1][n+1];
                
                for(int i=1; i<=n; i++) {
                    dp[0][i] = i; 
                }
                
                for(int i=1; i<=m; i++) {
                    dp[i][0] = i; 
                }
                
                for(int i=1; i<=m; i++) {
                    for(int j=1; j<=n; j++) {
                        if (word1.charAt(i-1) == word2.charAt(j-1)) {
                            dp[i][j] = dp[i-1][j-1];
                        } else {
                            // Min of insert(i, j-1), delete(i-1, j), replace(i-1, j-1) 
                            dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                        }
                            
                    }    
                }
                return dp[m][n];
            }            
            
### Maximum sum increasing subsequence      
- [https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1](https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1)                      

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
            
### Matrix Chain Multiplication         
- [https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1](https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1)            


            static int matrixMultiplication(int N, int arr[]) {
                int[][] dp=new int[N][N];
                for(int i=1;i<N;i++) dp[i][i]=0;
                
                for(int i=N-1;i>=1;i--){
                    for(int j=i+1;j<N;j++){
                        int minSteps=Integer.MAX_VALUE;
                        
                        for(int k=i;k<j;k++){
                            int steps=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                            if(steps<minSteps) minSteps=steps;
                        }
                        dp[i][j]=minSteps;
                    }
                }
                return dp[1][N-1];
            }            
            
### Minimum Path Sum        
- [https://leetcode.com/problems/minimum-path-sum/](https://leetcode.com/problems/minimum-path-sum/)            


            public int minPathSum(int[][] grid) {
                int n = grid.length;
                int m = grid[0].length;
                int[][] dp = new int[n+1][m+1];
                
                dp[0][0] = grid[0][0];
                for(int i=1; i<n; i++) {
                    dp[i][0] = dp[i-1][0] + grid[i][0];
                }
                
                for(int i=1; i<m; i++) {
                    dp[0][i] = dp[0][i-1] + grid[0][i];
                }
                
                for(int i=1; i<n; i++) {
                    for(int j=1; j<m; j++) {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]; 
                    }
                }
                return dp[n-1][m-1];
            }
            
### Coin Change
- [https://leetcode.com/problems/coin-change/](https://leetcode.com/problems/coin-change/)                  


            public int coinChange(int[] coins, int amount) {
                int n = coins.length;
                int m = amount;
                int[][] dp = new int[n+1][m+1];
                
                for(int i=1; i<= m; i++) {
                    dp[0][i] = Integer.MAX_VALUE-1;
                }
                
                for(int i=1; i<=n; i++) {
                    for(int j=1; j<=m; j++) {
                        if (coins[i-1] <= j) {
                            dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                        } else {
                            dp[i][j] = dp[i-1][j];
                        }
                       
                    }
                }
                
                return dp[n][m] == Integer.MAX_VALUE-1 ? -1 : dp[n][m];
            }
            
### Partition Equal Subset Sum          
- [https://leetcode.com/problems/partition-equal-subset-sum/](https://leetcode.com/problems/partition-equal-subset-sum/)        


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
            
### Minimum Cost to Cut a Stick
- [https://leetcode.com/problems/minimum-cost-to-cut-a-stick/](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/)          


            public int minCost(int n, int[] cuts) {
               List<Integer> A = new ArrayList<>();
                for (int a : cuts) {
                    A.add(a);
                }
                A.add(0);
                A.add(n);
                Collections.sort(A);
                int k = A.size();
                int[][] dp = new int[k][k];
                for (int d = 2; d < k; ++d) {
                    for (int i = 0; i < k - d; ++i) {
                        dp[i][i + d] = 1000000000;
                        for (int m = i + 1; m < i + d; ++m) {
                            dp[i][i + d] = Math.min(dp[i][i + d], 
                                                    dp[i][m] + dp[m][i + d] + A.get(i + d) - A.get(i));
                        }
                    }
                }
                return dp[0][k - 1];
            }       

### Egg Dropping Puzzle    
- [https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1](https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1)      


            static int eggDrop(int n, int k)  {
                int[][] dp = new int[n+1][k+1];
                for(int i=1; i<=n; i++) {
                    dp[i][0] = 0;
                    dp[i][1] = 1;
                }
                
                for(int i=1; i<=k; i++) {
                    dp[1][i] = i;
                }
                
                for(int i=2; i<=n; i++) {
                    for(int j=2; j<=k; j++) {
                        dp[i][j] = Integer.MAX_VALUE;
                        for(int f=1; f<=j; f++) {
                            dp[i][j] = Math.min(dp[i][j], 
                            Math.max(dp[i-1][f-1], dp[i][j-f])+1);
                        
                        }
                    }
                }
                return dp[n][k];
            }
                        
### Word Break          
- [https://practice.geeksforgeeks.org/problems/word-break1352/1](https://practice.geeksforgeeks.org/problems/word-break1352/1)          


            public static int wordBreak(String A, ArrayList<String> B ) {
                boolean res = solve(A,B);
                return res==true ? 1 : 0;
            }
            
            static boolean dictionaryContains(String word, ArrayList<String> dictionary) {
                int size = dictionary.size();
                for (int i = 0; i < size; i++)
                    if (dictionary.get(i).compareTo(word) == 0)
                       return true;
                return false;
            }
             
            // Returns true if String can be segmented into space separated
            // words, otherwise returns false
            static boolean solve(String str, ArrayList<String> dict) {
                int size = str.length();
                if (size == 0)   return true;
             
                // Create the DP table to store results of subproblems. The value wb[i]
                // will be true if str[0..i-1] can be segmented into dictionary words,
                // otherwise false.
                boolean []wb = new boolean[size+1];
                
                for (int i=1; i<=size; i++) {
                    // if wb[i] is false, then check if current prefix can make it true.
                    // Current prefix is "str.substring(0, i)"
                    if (wb[i] == false && dictionaryContains( str.substring(0, i), dict))
                        wb[i] = true;
             
                    // wb[i] is true, then check for all subStrings starting from
                    // (i+1)th character and store their results.
                    if (wb[i] == true) {
                        // If we reached the last prefix
                        if (i == size)
                            return true;
             
                        for (int j = i+1; j <= size; j++) {
                            // Update wb[j] if it is false and can be updated
                            // Note the parameter passed to dictionaryContains() is
                            // subString starting from index 'i' and length 'j-i'
                            if (wb[j] == false && dictionaryContains(str.substring(i, j), dict))
                                wb[j] = true;
             
                            // If we reached the last character
                            if (j == size && wb[j] == true)
                                return true;
                        }
                    }
                }
             
                /* Uncomment these lines to print DP table "wb[]"
                 for (int i = 1; i <= size; i++)
                    System.out.print(" " +  wb[i]; */
             
                // If we have tried all prefixes and none of them worked
                return false;
            }

### Palindromic patitioning         
- [https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1](https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1)        


            static int palindromicPartition(String str) {
                int n = str.length();
                int[][] C = new int[n][n];
                boolean[][] P = new boolean[n][n];
                int i, j, k, L; // different looping variables
        
                // Every substring of length 1 is a palindrome
                for (i = 0; i < n; i++) {
                    P[i][i] = true;
                    C[i][i] = 0;
                }
        
                for (L = 2; L <= n; L++) {
                    for (i = 0; i < n - L + 1; i++) {
                        j = i + L - 1; // Set ending index
                        if (L == 2)
                            P[i][j] = (str.charAt(i) == str.charAt(j));
                        else
                            P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];

                        if (P[i][j] == true)
                            C[i][j] = 0;
                        else {
                            C[i][j] = Integer.MAX_VALUE;
                            for (k = i; k <= j - 1; k++)
                                C[i][j] = Integer.min(C[i][j],
                                                      C[i][k] + C[k + 1][j] + 1);
                        }
                    }
                }
                return C[0][n - 1];
            }
            
            static boolean isPalindrome(String str, int s, int e) {
                while (s<e) {
                    if (str.charAt(s++) != str.charAt(e--)) return false;
                }
                return true;
            }      
    
    
            
                                    