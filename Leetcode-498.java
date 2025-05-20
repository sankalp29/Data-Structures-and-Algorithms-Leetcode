/*
    https://leetcode.com/problems/diagonal-traverse/
*/

class Solution {
    /**
     * Time complexity : O(N*M)
     * Space complexity : O(1) (No extra space used to solve the problem)
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] diagonal = new int[n*m];
        int index = 0, direction = 1, row = 0, col = 0;
        
        while (row < n && col < m) {
            diagonal[index++] = mat[row][col];
            
            int nRow = row + ((direction == 1) ? -1 : 1);
            int nCol = col + ((direction == 1) ? 1 : -1);

            if (isValid(nRow, nCol, n, m)) {
                row = nRow;
                col = nCol;
            } else {
                if (direction == 1) {
                    if (nCol == m) row = row + 1;
                    else col = col + 1;
                    direction = -1;
                } else {
                    if (nRow == n) col = col + 1;
                    else row = row + 1;
                    direction = 1;
                }
            }
        }

        return diagonal;
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}