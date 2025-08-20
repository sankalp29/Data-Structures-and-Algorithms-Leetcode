/**
 * Time complexity : O(N*M * log(base10)(number))
 * Space complexity : O(M) (M = cols)
 */
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] result = new int[cols];

        for (int i = 0; i < cols; i++) {
            int maxLength = -1;
            for (int j = 0; j < rows; j++) {
                maxLength = Math.max(maxLength, getLength(grid[j][i]));
            }
            result[i] = maxLength;
        }

        return result;
    }

    private int getLength(int number) {
        if (number == 0) return 1;
        int length = 0;
        if (number < 0) length++;

        while (number != 0) {
            number/=10;
            length++;
        }

        return length;
    }
}