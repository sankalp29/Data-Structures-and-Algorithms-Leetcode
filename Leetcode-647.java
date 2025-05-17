/*
    https://leetcode.com/problems/palindromic-substrings/
*/

class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            // Count even odd length palindromes
            result+=expandAroundCentre(s, i, i);

            // Count even length palindromes
            result+=expandAroundCentre(s, i, i+1);
        }

        return result;
    }

    private int expandAroundCentre(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) break;
            count++;
            left--;
            right++;
        }
        return count;
    }
}