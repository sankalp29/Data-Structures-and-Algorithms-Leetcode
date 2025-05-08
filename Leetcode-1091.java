/*
    https://leetcode.com/problems/shortest-path-in-binary-matrix/
*/

class Solution {
    /**
     * Time complexity : O(N^2)
     * Space complexity : O(N^2)
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int[][] distances = new int[n][n];
        for (int[] row : distances) Arrays.fill(row, Integer.MAX_VALUE);
        distances[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        // Breadth-first search to find the shortest distance to bottom-right cell
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int curDist = distances[row][col];
            if (row == n-1 && col == n-1) return curDist;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(newRow, newCol, n, n) && grid[newRow][newCol] == 0 && distances[newRow][newCol] > curDist + 1) {
                    distances[newRow][newCol] = curDist + 1;
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0  && col < cols;
    }
}