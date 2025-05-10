/*
    https://leetcode.com/problems/maximum-profit-from-trading-stocks/
*/

class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        return getMaximumProfitTabulationSpaceOptimised(present, future, budget);
    }

    /**
     * Time complexity : O(Budget*N)
     * Space complexity : O(Budget)
     */
    private int getMaximumProfitTabulationSpaceOptimised(int[] present, int[] future, int amount) {
        int n = present.length;
        int[] current = new int[amount+1];
        int[] next = new int[amount+1];

        for (int index = n-1; index >= 0; index--) {
            for (int budget = amount; budget >= 0; budget--) {
                if (present[index] > budget) {
                    current[budget] = next[budget];
                } else {
                    // Case 1: Pick
                    int pick = (future[index] - present[index]) + next[budget - present[index]];
                    // Case 2: Not pick
                    int notPick = next[budget];
                    current[budget] = Math.max(pick, notPick);
                }
            }

            for (int i = 0; i <= amount; i++) next[i] = current[i];
        }

        return current[amount];
    }

    /**
     * Time complexity : O(Budget*N)
     * Space complexity : O(Budget*N)
     */
    private int getMaximumProfitTabulation(int[] present, int[] future, int amount) {
        int n = present.length;
        int[][] dp = new int[n+1][amount+1];

        for (int index = n-1; index >= 0; index--) {
            for (int budget = amount; budget >= 0; budget--) {
                if (present[index] > budget) {
                    dp[index][budget] = dp[index+1][budget];
                } else {
                    // Case 1: Pick
                    int pick = (future[index] - present[index]) + dp[index+1][budget - present[index]];
                    // Case 2: Not pick
                    int notPick = dp[index+1][budget];
                    dp[index][budget] = Math.max(pick, notPick);
                }
            }
        }

        return dp[0][amount];
    }

    /**
     * Time complexity : O(Budget*N)
     * Space complexity : O(Budget*N) + O(N)
     */
    private int getMaximumProfitMemoized(int[] present, int[] future, int budget, int index, int[][] memo) {
        if (budget == 0 || index == present.length) return 0;

        if (memo[budget][index] != -1) return memo[budget][index];

        if (present[index] > budget) {
            return getMaximumProfit(present, future, budget, index+1);
        }
        
        // Case 1: Pick
        int pick = (future[index] - present[index]) + getMaximumProfit(present, future, budget - present[index], index+1);

        // Case 2: Not pick
        int notPick = getMaximumProfit(present, future, budget, index+1);

        return memo[budget][index] = Math.max(pick, notPick);
    }

    /**
     * Time complexity : O(2^N)
     * Space complexity : O(N)
     */
    private int getMaximumProfit(int[] present, int[] future, int budget, int index) {
        if (budget == 0 || index == present.length) return 0;

        if (present[index] > budget) {
            return getMaximumProfit(present, future, budget, index+1);
        }
        
        // Case 1: Pick
        int pick = (future[index] - present[index]) + getMaximumProfit(present, future, budget - present[index], index+1);

        // Case 2: Not pick
        int notPick = getMaximumProfit(present, future, budget, index+1);

        return Math.max(pick, notPick);
    }
}