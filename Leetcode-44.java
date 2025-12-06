/*
    https://leetcode.com/problems/wildcard-matching/
*/

class Solution {
    public boolean isMatch(String s, String p) {
        /*
        Boolean[][] memo = new Boolean[s.length()][p.length()];
        return isMatch(s, 0, p, 0, memo);
        */
        return isMatchTabulationSpaceOptimised(s, p);
    }

    /**
     * Time complexity : O(N * M)
     * Space complexity : O(M)
     */
    private boolean isMatchTabulationSpaceOptimised(String s, String p) {
        boolean[] next = new boolean[p.length() + 1];
        next[p.length()] = true;
        
        for (int index2 = p.length() - 1; index2 >= 0; index2--) {
            if (p.charAt(index2) == '*') next[index2] = true;
            else break;
        }

        for (int index1 = s.length() - 1; index1 >= 0; index1--) {
            boolean[] current = new boolean[p.length() + 1];
            for (int index2 = p.length() - 1; index2 >= 0; index2--) {
                char ch = p.charAt(index2);

                if (ch == '*') {
                    current[index2] = next[index2] || current[index2 + 1];
                } else if (ch == '?') {
                    current[index2] = next[index2 + 1];
                } else {
                    if (s.charAt(index1) != ch) current[index2] = false;
                    else current[index2] = next[index2 + 1];
                }
            }
            next = current;
        }

        return next[0];
    }

    /**
     * Time complexity : O(N * M)
     * Space complexity : O(N * M)
     */
    private boolean isMatchTabulation(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        
        for (int index2 = p.length() - 1; index2 >= 0; index2--) {
            if (p.charAt(index2) == '*') dp[s.length()][index2] = true;
            else break;
        }

        for (int index1 = s.length() - 1; index1 >= 0; index1--) {
            for (int index2 = p.length() - 1; index2 >= 0; index2--) {
                if (p.charAt(index2) == '*') {
                    //     Match * with S char                  || End * matching, move ahead in P
                    dp[index1][index2] = dp[index1 + 1][index2] || dp[index1][index2 + 1];
                } else if (p.charAt(index2) == '?') {
                    dp[index1][index2] = dp[index1 + 1][index2 + 1];
                } else {
                    if (s.charAt(index1) != p.charAt(index2)) dp[index1][index2] = false;
                    else dp[index1][index2] = dp[index1 + 1][index2 + 1];
                }
            }
        }

        return dp[0][0];
    }

    /**
     * Time complexity : O(2 ^ N)
     * Space complexity : O(N)
     */
    private boolean isMatch(String s, int index1, String p, int index2, Boolean[][] memo) {
        if (index2 == p.length()) return index1 == s.length();
        if (index1 == s.length()) {
            for (int i = index2; i < p.length(); i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }

        if (memo[index1][index2] != null) return memo[index1][index2];

        if (p.charAt(index2) == '*') {
            //     Match * with S char               || End * matching, move ahead in P
            return memo[index1][index2] = isMatch(s, index1 + 1, p, index2, memo) || isMatch(s, index1, p, index2 + 1, memo);
        } else if (p.charAt(index2) == '?') {
            return memo[index1][index2] = isMatch(s, index1 + 1, p, index2 + 1, memo);
        } else {
            if (s.charAt(index1) != p.charAt(index2)) return memo[index1][index2] = false;
            return memo[index1][index2] = isMatch(s, index1 + 1, p, index2 + 1, memo);
        }
    }
}