/*
*
* 121. Best Time to Buy and Sell Stock
*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
* You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
* Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*
*
* */
public class L121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int profit = 0;
        int min = 0;
        int max = 0;
        int localProfit = 0;
        for (int i = 1; i<prices.length; i++) {
            if (prices[i] >= prices[min]) {
                max = i;
            } else {
                min = i;
            }

            if (min < max) {
                localProfit = prices[max] - prices[min];
            }
            profit = Math.max(profit, localProfit);

        }
        return profit;
    }
}
