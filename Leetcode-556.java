/*
    https://leetcode.com/problems/next-greater-element-iii/
*/

class Solution {
    /**
     * Time complexity : O(N) => O(1) because the length of the number array will be max 10
     * Space complexity : O(N) => O(1) because the length of the number array will be max 10
     */
    public int nextGreaterElement(int n) {
        char[] number = String.valueOf(n).toCharArray();
        
        int i = number.length - 2;
        while (i >= 0 && number[i] >= number[i+1]) {
            i--;
        }
        
        if (i < 0) return -1;
        
        int j = number.length - 1;
        while (number[j] <= number[i]) {
            j--;
        }

        swap(number, i, j);
        reverse(number, i+1);
        long result = Long.parseLong(new String(number));
        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }
    
    private void reverse(char[] number, int start) {
        int end = number.length - 1;
        while (start < end) {
            swap(number, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] number, int index1, int index2) {
        char temp = number[index1];
        number[index1] = number[index2];
        number[index2] = temp;
    }
}