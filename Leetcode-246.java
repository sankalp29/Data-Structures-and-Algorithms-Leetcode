/*
    https://leetcode.com/problems/strobogrammatic-number/
*/

class Solution {
    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public boolean isStrobogrammatic(String num) {
        final Map<Character, Character> STROBO_MAP = Map.of(
            '0', '0',
            '1', '1',
            '6', '9',
            '8', '8',
            '9', '6'
        );
        int left = 0, right = num.length() - 1;

        while (left <= right) {
            char lChar = num.charAt(left);
            char rChar = num.charAt(right);

            if (!STROBO_MAP.containsKey(lChar) || STROBO_MAP.get(lChar) != rChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
