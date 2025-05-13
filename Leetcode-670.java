/*
    https://leetcode.com/problems/maximum-swap/
*/

class Solution {
    /**
     * Optimal solution
     * Time complexity : O(10*N)
     * Space complexity : O(10) => O(1)
     */
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] lastOccurrence = new int[10];
        Arrays.fill(lastOccurrence, -1);

        // Set the last occurrence of each digit in the number
        for (int i = 0; i < digits.length; i++) lastOccurrence[digits[i] - '0'] = i;

        for (int i = 0; i < digits.length; i++) {
            int currentDigit = digits[i] - '0';
            for (int rightDigit = 9; rightDigit > currentDigit; rightDigit--) {
                if (lastOccurrence[rightDigit] > i) {
                    swap(digits, i, lastOccurrence[rightDigit]);
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    private void swap(char[] digits, int index1, int index2) {
        char temp = digits[index1];
        digits[index1] = digits[index2];
        digits[index2] = temp;
    }

    /**
     * Brute force
     * Time complexity : O(N^2)
     * Space complexity : O(N) (creating the string using StringBuilder)
     */
    /*
    public int maximumSwap(int num) {
        StringBuilder number = new StringBuilder(String.valueOf(num));
        int n = number.length();

        // Traverse each digit from left to right
        for (int i = 0; i < n; i++) {
            char currentDigit = number.charAt(i);
            char maxDigit = currentDigit;
            int maxDigitIndex = -1;

            // Look for the largest digit to the right of current position
            for (int j = i + 1; j < n; j++) {
                char rightDigit = number.charAt(j);
                if (rightDigit > maxDigit) {
                    maxDigit = rightDigit;
                    maxDigitIndex = j;
                } else if (maxDigitIndex != -1 && rightDigit == maxDigit) {
                    // Always prefer the last occurrence of maxDigit
                    maxDigitIndex = j;
                }
            }

            // If a larger digit was found, swap it with current digit
            if (maxDigitIndex != -1) {
                swap(number, i, maxDigitIndex);
                return Integer.parseInt(number.toString());
            }
        }

        return num; // The original number is the largest possible.
    }

    private void swap(StringBuilder number, int i, int j) {
        char temp = number.charAt(i);
        number.setCharAt(i, number.charAt(j));
        number.setCharAt(j, temp);
    }
    */
}