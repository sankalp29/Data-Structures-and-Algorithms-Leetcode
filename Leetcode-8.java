/*
    https://leetcode.com/problems/string-to-integer-atoi/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int index = 0;
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            index = 1;
        } else if (s.charAt(0) == '+') {
            index = 1;
        }

        int number = 0, max = Integer.MAX_VALUE;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            int rem = number % 10;
            if (number > max / 10 || (number == max / 10 && digit > max % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
            index++;
        }

        return sign * number;
    }
}