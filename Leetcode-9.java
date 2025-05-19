/*
    https://leetcode.com/problems/palindrome-number/
*/

class Solution {
    /**
     * Time complexity : O(1)
     * Space complexity : O(1)
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int number = 0, current = x;

        /**
            x = 121
            current = 0
            rem = 1
            number = 121
         */

        while (current > 0) {
            int rem = current % 10;
            number = number * 10 + rem;
            current = current / 10;
        }

        return number == x;
    }
}