/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minStockPrice = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - minStockPrice;
            maxProfit = Math.max(maxProfit, profit);

            minStockPrice = Math.min(minStockPrice, prices[i]);
        }

        return maxProfit;
    }
}