/*
    https://leetcode.com/problems/shortest-bridge/
*/

class Solution {
    /**
     * Time complexity : O(N^2)
     * Space complexity : O(N^2)
     */
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> bfsQueue = new LinkedList<>();
        boolean firstIslandVisited = false;
        
        for (int i = 0; i < n && !firstIslandVisited; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    markFirstIslandDFS(grid, i, j, visited, bfsQueue);
                    firstIslandVisited = true;
                    break;
                }
            }
        }

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int distance = 0;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size-- > 0) {
                int[] cell = bfsQueue.poll();
                int row = cell[0], col = cell[1];

                for (int[] direction : directions) {
                    int nRow = row + direction[0];
                    int nCol = col + direction[1];
                    if (isValid(nRow, nCol, n) && !visited[nRow][nCol]) {
                        if (grid[nRow][nCol] == 1) return distance;
                        bfsQueue.add(new int[] {nRow, nCol});
                        visited[nRow][nCol] = true;
                    }
                }
            }
            distance++;
        }

        return -1;
    }

    private void markFirstIslandDFS(int[][] grid, int row, int col, boolean[][] visited, Queue<int[]> bfsQueue) {
        if (!isValid(row, col, grid.length) || grid[row][col] == 0 || visited[row][col]) return;
        
        visited[row][col] = true;
        bfsQueue.add(new int[] {row, col});
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int[] direction : directions) {
            int nRow = row + direction[0];
            int nCol = col + direction[1];
            markFirstIslandDFS(grid, nRow, nCol, visited, bfsQueue);
        }
    }

    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}

