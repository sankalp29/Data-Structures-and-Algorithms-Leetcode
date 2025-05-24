/*
    https://leetcode.com/problems/number-of-islands/
*/

class Solution {
    /**
     * Time complexity : O(M*N)
     * Space complexity : O(M*N)
     */
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int curRow, int curCol) {
        Stack<int[]> dfsStack = new Stack<>();
        dfsStack.add(new int[] {curRow, curCol});
        visited[curRow][curCol] = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!dfsStack.isEmpty()) {
            int[] node = dfsStack.pop();
            int row = node[0], col = node[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(newRow, newCol, grid) && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    dfsStack.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    private boolean isValid(int row, int col, char[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}