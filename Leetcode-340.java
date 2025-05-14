/*
    https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
*/

class Solution {
    /**
     * Time complexity : O(2*N) (because left and right can both traverse through the array)
     * Space complexity : O(1)
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> frequency = new HashMap<>();

        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            frequency.put(s.charAt(right), frequency.getOrDefault(s.charAt(right), 0) + 1);

            while (frequency.size() > k) {
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                if (frequency.get(s.charAt(left)) == 0) frequency.remove(s.charAt(left));
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}