/*
    https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
*/

class Solution {
    /**
     * Time complexity : O(2*N)
     * Space complexity : O(3) => O(1)
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        int left = 0, right = 0, answer = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
            
            while (charFrequency.size() > 2) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) charFrequency.remove(leftChar);
                left++;
            }

            answer = Math.max(answer, right - left + 1);
            right++;
        }

        return answer;
    }
}