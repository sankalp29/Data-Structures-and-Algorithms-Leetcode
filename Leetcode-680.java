/*
    https://leetcode.com/problems/valid-palindrome-ii/
*/


/**
 * Time complexity : O(N)
 * Space complexity : O(1)
*/
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        
        int n = s.length();        
        int left = 0, right = n-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return checkPalindrome(s, left+1, right) || checkPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}