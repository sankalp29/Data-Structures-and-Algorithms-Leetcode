/*
    https://leetcode.com/problems/custom-sort-string/
*/

class Solution {
    /**
     * Time complexity : O(L1 + L2)
     * Space complexity : O(1)
     */
    public String customSortString(String order, String s) {
        int[] charCount = new int[26];
        
        for (char ch : s.toCharArray()) charCount[ch - 'a']++;

        StringBuilder result = new StringBuilder();

        // Append characters in order
        for (char ch : order.toCharArray()) {
            while (charCount[ch - 'a']-- > 0) result.append(ch);
        }

        // Append remaining characters (those not present in 'order' but present in 's')
        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (charCount[ch - 'a']-- > 0) result.append(ch);
        }

        return result.toString();
    }
}