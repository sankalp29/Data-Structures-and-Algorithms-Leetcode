/*
    https://leetcode.com/problems/search-a-2d-matrix/
*/

class Solution {
    /**
     * Time complexity : O(log(m*n))
     * Space complexity : O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int midCell = left + (right - left) / 2;
            int[] index = getIndex(midCell, n);
            int cellValue = matrix[index[0]][index[1]];
            if (cellValue == target) return true;
            if (cellValue > target) right = midCell - 1;
            else left = midCell + 1;
        }

        return false;
    }

    private int[] getIndex(int cellNumber, int n) {
        return new int[] {cellNumber / n, cellNumber % n};
    }
}