## Popular Dynamic Programming questions' solution

### Questions    
- [Climbing Stairs](#climbing-stairs)
- [Min Cost Climbing Stairs](#min-cost-climbing-stairs)  
- [House Robber](#house-robber)             
- [House Robber II](#house-robber-II)           
- [Delete and Earn](#delete-and-earn)     
- [Triangle](#triangle)  
- [01 Matrix](#01-matrix)     
- [Integer Break](#integer-break)  
- [Maximum Sum Circular Subarray](#maximum-sum-circular-subarray)       
- [Maximum Length of Subarray With Positive Product](#maximum-length-of-subarray-with-positive-product)   
- [Best Sightseeing Pair](#Best Sightseeing Pair)    
- [Best Time to Buy and Sell Stock](#best-time-to-buy-and-sell-stock)           
- [Best Time to Buy and Sell Stock II](#best-time-to-buy-and-sell-stock-ii)               
- [Best Time to Buy and Sell Stock with Cooldown](#best-time-to-buy-and-sell-stock-with-cooldown)
- [Best Time to Buy and Sell Stock with Transaction Fee](#best-time-to-buy-and-sell-stock-with-transaction-fee)           
- [Longest Repeated Subsequence](#longest-repeated-subsequence)         

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

