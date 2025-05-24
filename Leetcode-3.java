/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(N)
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int length = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= left) {
                left = lastSeen.get(ch) + 1;
            }

            lastSeen.put(ch, right);
            length = Math.max(length, right - left + 1);

            right++;
        }

        return length;
    }
}