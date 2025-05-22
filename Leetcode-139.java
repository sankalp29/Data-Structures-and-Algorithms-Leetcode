/*
    https://leetcode.com/problems/word-break/
*/

class Solution {
    /**
     * Time complexity : O(N^2)
     * Space complexity : O(N)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    /**
     * Time complexity : O(N^2)
     * Space complexity : O(N + N) (recursion stack space)
     */
    private boolean canWordBeFormedMemoized(String s, int start, Set<String> words, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); i++) {
            if (words.contains(s.substring(start, end) && canWordBeFormedMemoized(s, end, words, memo))) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
    

    /**
     * Time complexity : O(2^N)
     * Space complexity : O(N)
     */
    private boolean canWordBeFormed(String s, Set<String> words) {
        if (s.length() == 0) return true;

        for (int i = 1; i <= s.length(); i++) {
            if (words.contains(s.substring(0, i))) {
                if (canWordBeFormed(s.substring(i), words)) return true;
            }
        }

        return false;
    }
}