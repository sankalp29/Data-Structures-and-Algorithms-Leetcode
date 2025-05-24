/*
    https://leetcode.com/problems/reverse-integer/
*/

class Solution {
    /**
     * Time complexity : O(10) => O(1)
     * Space complexity : O(1)
     */
    public int reverse(int x) {
        int current = 0;

        while (x != 0) {
            int digit = x % 10;
            if (current > Integer.MAX_VALUE / 10 || (current == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (current < Integer.MIN_VALUE / 10 || (current == Integer.MIN_VALUE / 10 &&  digit < -8)) {
                return 0;
            }
            current = current * 10 + digit;
            x = x / 10;
        }

        return current;
    }
}