/*
    https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int minDeletion(String s, int k) {
        int[] frequency = new int[26];
        int distinct = 0;

        for (char ch : s.toCharArray()) {
            if (frequency[ch - 'a'] == 0) distinct++;
            frequency[ch - 'a']++;
        }

        if (distinct <= k) return 0;

        Arrays.sort(frequency);
        int deletion = 0, index = 0;

        while (distinct > k) {
            if (frequency[index] != 0) {
                deletion+=frequency[index];
                distinct--;
            }
            index++;
        }

        return deletion;
    }
}