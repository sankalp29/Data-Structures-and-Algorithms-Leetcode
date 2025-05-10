/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return getMaxProfitTabulationSpaceOptimised(prices);
    }

    /**
     * Time complexity : O(2*N)
     * Space complexity : O(6) => O(1)
     */
    private int getMaxProfitTabulationSpaceOptimised(int[] prices) {
        int n = prices.length;
        int[] current = new int[2];
        int[] next = new int[2];
        int[] skipNext = new int[2];

        for (int index = n-1; index >= 0; index--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                if (canBuy == 0) { // Buy
                    int buy = -prices[index] + next[1 - canBuy];
                    int pass = next[canBuy];
                    current[canBuy] = Math.max(buy, pass);
                } else { // Sell
                    int sell = prices[index] + skipNext[1 - canBuy];
                    int pass = next[canBuy];
                    current[canBuy] = Math.max(sell, pass);
                }
            }

            for (int i = 0; i < 2; i++) {
                skipNext[i] = next[i];
                next[i] = current[i];
            }
        }

        return current[0];
    }

    /**
     * Time complexity : O(2*N)
     * Space complexity : (2*N)
     */
    private int getMaxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for (int index = n-1; index >= 0; index--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                if (canBuy == 0) { // Buy
                    int buy = -prices[index] + dp[index+1][1 - canBuy];
                    int pass = dp[index+1][canBuy];
                    dp[index][canBuy] = Math.max(buy, pass);
                } else { // Sell
                    int sell = prices[index] + dp[index+2][1 - canBuy];
                    int pass = dp[index+1][canBuy];
                    dp[index][canBuy] = Math.max(sell, pass);
                }
            }
        }

        return dp[0][0];
    }

    /**
     * Time complexity : O(N)
     * Space complexity : O(2*N + N) -> memo + recursion stack space
     */
    private int getMaxProfitMemoized(int[] prices, int index, int canBuy, int[][] memo) {
        if (index >= prices.length) return 0;

        if (memo[index][canBuy] != -1) return memo[index][canBuy];

        if (canBuy == 0) { // Buy
            int buy = -prices[index] + getMaxProfit(prices, index+1, 1 - canBuy);
            int pass = getMaxProfit(prices, index+1, canBuy);
            return memo[index][canBuy] = Math.max(buy, pass);

        } else { // Sell
            int sell = prices[index] + getMaxProfit(prices, index+2, 1 - canBuy);
            int pass = getMaxProfit(prices, index+1, canBuy);
            return memo[index][canBuy] = Math.max(sell, pass);
        }
    }

    /**
     * Time complexity : O(2^N)
     * Space complexity : O(N)
     */
    private int getMaxProfit(int[] prices, int index, int canBuy) {
        if (index >= prices.length) return 0;

        if (canBuy == 0) { // Buy
            int buy = -prices[index] + getMaxProfit(prices, index+1, 1 - canBuy);
            int pass = getMaxProfit(prices, index+1, canBuy);
            return Math.max(buy, pass);

        } else { // Sell
            int sell = prices[index] + getMaxProfit(prices, index+2, 1 - canBuy);
            int pass = getMaxProfit(prices, index+1, canBuy);
            return Math.max(sell, pass);
        }
    }
}