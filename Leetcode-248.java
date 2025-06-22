/*
    https://leetcode.com/problems/strobogrammatic-number-iii/
*/

class Solution {
    int count = 0;
    /**
     * Time complexity : O(N * 4^N * N)
     * Space complexity : O(N) (where N can be 15 at max, so effectively it's O(1))
     */
    public int strobogrammaticInRange(String low, String high) {
        int left = low.length(), right = high.length();
        
        // O(15)
        for (int n = left; n <= right; n++) {
            char[] number = new char[n];
            getValidNumbers(0, n-1, number, low, high, n);
        }

        return count;
    }

    private void getValidNumbers(int left, int right, char[] number, String low, String high, int n) {
        if (left > right) {
            if (isInRange(String.valueOf(number), low, high)) count++;
            return;
        }

        if (n == 1 || left != 0) {
            number[left] = '0'; number[right] = '0';
            getValidNumbers(left+1, right-1, number, low, high, n);
        }

        if (left != right) {
            number[left] = '6'; number[right] = '9';
            getValidNumbers(left+1, right-1, number, low, high, n);

            number[left] = '9'; number[right] = '6';
            getValidNumbers(left+1, right-1, number, low, high, n);
        }

        number[left] = '1'; number[right] = '1';
        getValidNumbers(left+1, right-1, number, low, high, n);

        number[left] = '8'; number[right] = '8';
        getValidNumbers(left+1, right-1, number, low, high, n);
    }

    private boolean isInRange(String number, String low, String high) {
        if (number.length() == low.length() && number.compareTo(low) < 0) {
            return false;
        }
        if (number.length() == high.length() && number.compareTo(high) > 0) {
            return false;
        }
        return true;
    }
}