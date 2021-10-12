/*
*
* 309. Best Time to Buy and Sell Stock with Cooldown
*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
* Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
* After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
*
* */
public class BestTimetoBuyandSellStockwithCooldown309 {
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

}
