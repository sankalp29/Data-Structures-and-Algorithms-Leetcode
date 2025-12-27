/*
    https://leetcode.com/problems/spiral-matrix/
*/

class Solution {
    /**
     * Time complexity : O(N * M)
     * Space complexity : O(N * M) to return result, O(1) auxiliary space
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;

        while (top <= bottom && left <= right) {
            // Step 1 : Left to Right
            int col = left;
            while (col <= right) spiral.add(matrix[top][col++]);
            top++;

            // Step 2 : Top to Bottom
            int row = top;
            while (row <= bottom) spiral.add(matrix[row++][right]);
            right--;
            
            // Step 3 : Right to Left
            col = right;
            while (col >= left && top <= bottom) spiral.add(matrix[bottom][col--]);
            bottom--;

            // Step 4 : Bottom to Top
            row = bottom;
            while (row >= top && left <= right) spiral.add(matrix[row--][left]);
            left++;
        }

        return spiral;
    }
}