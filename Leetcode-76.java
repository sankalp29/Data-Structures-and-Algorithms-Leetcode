/*
    https://leetcode.com/problems/minimum-window-substring/
*/

class Solution {
    /**
     * Time complexity : O(N + M)
     * Space complexity : O(1)
     */
    public String minWindow(String s, String t) {
        int[] frequency = new int[128];
        int required = 0, n = s.length(), m = t.length();

        for (char ch : t.toCharArray()) {
            if (frequency[ch] == 0) required++;
            frequency[ch]++;
        }

        int left = 0, right = 0, minlength = Integer.MAX_VALUE;
        int startIndex = -1;

        while (right < n) {
            frequency[s.charAt(right)]--;
            if (frequency[s.charAt(right)] == 0) required--;

            while (required == 0) {
                int len = right - left + 1;
                if (len < minlength) {
                    startIndex = left;
                    minlength = len;
                }

                frequency[s.charAt(left)]++;
                if (frequency[s.charAt(left)] > 0) required++;
                left++;
            }

            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minlength);
    }
}