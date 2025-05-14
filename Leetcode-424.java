/*
    https://leetcode.com/problems/longest-repeating-character-replacement/
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];

        int left = 0, right = 0, maxLength = 0, maxOccurringFrequency = 0;

        while (right < s.length()) {
            frequency[s.charAt(right) - 'A']++;
            maxOccurringFrequency = Math.max(maxOccurringFrequency, frequency[s.charAt(right) - 'A']);

            int length = right - left + 1;
            while ((right - left + 1) - maxOccurringFrequency > k) {
                frequency[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    private int getMaxOccurringFrequency(int[] frequency) {
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            maxFreq = Math.max(maxFreq, frequency[i]);
        }

        return maxFreq;
    }
}