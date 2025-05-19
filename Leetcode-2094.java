/*
    https://leetcode.com/problems/finding-3-digit-even-numbers/
*/

class Solution {
    /**
     * Time complexity : O(500*3) => O(1)
     * Space complexity : O(500) => O(1)
     */
    public int[] findEvenNumbers(int[] digits) {
        int[] frequency = new int[10];
        for (int i = 0; i < digits.length; i++) frequency[digits[i]]++;

        List<Integer> possibleNumbers = new ArrayList<>();

        for (int num = 100; num <= 999; num+=2) {
            if (isNumberPossible(frequency, num)) possibleNumbers.add(num);
        }

        int[] result = new int[possibleNumbers.size()];
        int index = 0;

        for (int i = 0; i < possibleNumbers.size(); i++) {
            result[i] = possibleNumbers.get(i);
        }
        
        return result;
    }

    private boolean isNumberPossible(int[] frequency, int number) {
        int[] digits = new int[10];
        
        while (number > 0) {
            int digit = number % 10;
            digits[digit]++;
            if (digits[digit] > frequency[digit]) return false;
            number = number / 10;
        }
        
        return true;
    }
}