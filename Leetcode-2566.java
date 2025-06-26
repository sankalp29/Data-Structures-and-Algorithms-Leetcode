/*
    https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
*/

class Solution {
    /**
     * Time complexity : O(1)
     * Space complexity : O(1)
     */
    public int minMaxDifference(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        char[] greatest = new char[n];
        char[] smallest = new char[n];
        for (int i = 0; i < n; i++) {
            greatest[i] = digits[i];
            smallest[i] = digits[i];
        }

        // Create greatest number
        int index = 0;
        while (index < digits.length && greatest[index] == '9') index++;
        if (index != digits.length) {
            char digit = digits[index];
            for (;index < digits.length; index++) {
                if (greatest[index] == digit) greatest[index] = '9';
            }
        }

        // Create smallest number
        char digit = smallest[0];
        index = 0;
        while (index < digits.length) {
            if (digits[index] == digit) smallest[index] = '0';
            index++;
        }

        return Integer.parseInt(new String(greatest)) - Integer.parseInt(new String(smallest));
    }
}