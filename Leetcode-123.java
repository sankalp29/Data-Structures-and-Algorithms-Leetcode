/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
*/

class Solution {
    /**
     * Time complexity : O(N*4)
     * Space complexity : O(10) => O(1)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[5];
        int[] dp = new int[5];
        for (int index = n-1; index >= 0; index--) {
            for (int tranId = 3; tranId >= 0; tranId--) {
                int buy = (tranId % 2 == 0) ? -prices[index] + next[tranId+1] : 0;
                int sell = (tranId % 2 == 1) ? prices[index] + next[tranId+1] : 0;
                int pass = next[tranId];

                dp[tranId] = Math.max(pass, Math.max(buy, sell));
            }

            for (int i = 0; i < dp.length; i++) next[i] = dp[i];
        }
        
        return dp[0];
    }
    
    /**
     * Time complexity : O(N*4)
     * Space complexity : O(N*5)
     */
    public int getMaxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];
        for (int index = n-1; index >= 0; index--) {
            for (int tranId = 3; tranId >= 0; tranId--) {
                int buy = (tranId % 2 == 0) ? -prices[index] + dp[index+1][tranId+1] : 0;
                int sell = (tranId % 2 == 1) ? prices[index] + dp[index+1][tranId+1] : 0;
                int pass = dp[index+1][tranId];

                dp[index][tranId] = Math.max(pass, Math.max(buy, sell));
            }
        }
        
        return dp[0][0];
    }

    /**
     * Time complexity : O(N*4)
     * Space complexity : O(N*4)
     */
    private int getMaxProfitMemoized(int[] prices, int index, int tranId, int[][] memo) {
        if (index == prices.length || tranId == 4) return 0;

        if (memo[index][tranId] != -1) return memo[index][tranId];

        int buy = (tranId % 2 == 0) ? -prices[index] + getMaxProfitMemoized(prices, index+1, tranId+1, memo) : 0;
        int sell = (tranId % 2 == 1) ? prices[index] + getMaxProfitMemoized(prices, index+1, tranId+1, memo) : 0;
        int pass = getMaxProfitMemoized(prices, index+1, tranId, memo);

        return memo[index][tranId] = Math.max(pass, Math.max(buy, sell));
    }

    /**
     * Time complexity : O(3^N)
     * Space complexity : O(N*4) + O(N) for memo and recursion stack space
     */
    private int getMaxProfitRecursive(int[] prices, int index, int tranId) {
        if (index == prices.length || tranId == 4) return 0;

        int buy = (tranId % 2 == 0) ? -prices[index] + getMaxProfitRecursive(prices, index+1, tranId+1) : 0;
        int sell = (tranId % 2 == 1) ? prices[index] + getMaxProfitRecursive(prices, index+1, tranId+1) : 0;
        int pass = getMaxProfitRecursive(prices, index+1, tranId);

        return Math.max(pass, Math.max(buy, sell));
    }
}