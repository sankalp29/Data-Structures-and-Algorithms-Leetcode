/*
    https://leetcode.com/problems/rotate-image/
*/

class Solution {
    /**
     * Time complexity : O(N ^ 2)
     * Space complexity : O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(matrix, i);
        }
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private void reverse(int[][] matrix, int row) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            swap(matrix, row, start, row, end);
            start++;
            end--;
        }
    }
}