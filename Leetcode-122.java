/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) 
                totalProfit+=(prices[i] - prices[i-1]);
        }

        return totalProfit;
    }
}