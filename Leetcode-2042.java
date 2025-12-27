/*
    https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public boolean areNumbersAscending(String s) {
        int previous = -1, current = 0;
        for (char ch : s.toCharArray()) {
            if (isDigit(ch)) {
                current = current * 10 + (ch - '0');
            } else if (current != 0) {
                if (current <= previous) return false;
                previous = current;
                current = 0;
            }
        }

        if (current != 0 && current <= previous) return false;
        return true;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}