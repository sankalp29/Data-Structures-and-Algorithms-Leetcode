/*
    https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
*/

class Solution {
    /**
     * Time complexity : O(6*N) => O(N)
     * Space complexity : O(1)
     */
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (isEvenDigits(num)) count++;
        }

        return count;
    }

    private boolean isEvenDigits(int number) {
        int digits = 0;
        while (number > 0) {
            number = number / 10;
            digits++;
        }

        return (digits % 2) == 0;
    }
}