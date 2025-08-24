/**
 * Time complexity : O(N*M * log(N*M))
 * Space complexity : O(N*M)
 */
class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = grid.length, cols = grid[0].length;
        Comparator<CellInfo> comparator = (info1, info2) -> Integer.compare(info1.time, info2.time);
        PriorityQueue<CellInfo> pq = new PriorityQueue<>(comparator);
        boolean[][] visited = new boolean[rows][cols];
        pq.add(new CellInfo(0, 0, 0));

        while (!pq.isEmpty()) {
            CellInfo cellInfo = pq.poll();
            int row = cellInfo.row, col = cellInfo.col;
            int time = cellInfo.time;
            if (visited[row][col]) continue;
            visited[row][col] = true;
            
            if (row == rows - 1 && col == cols - 1) return time;

            int neighbourVisitTime = time + 1;

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (isValid(newRow, newCol, rows, cols) && !visited[newRow][newCol]) {
                    if (grid[newRow][newCol] <= neighbourVisitTime) {
                        pq.add(new CellInfo(newRow, newCol, neighbourVisitTime));
                    } else {
                        int diff = grid[newRow][newCol] - time;
                        int actualVisitTime = time + diff + ((diff % 2) == 0 ? 1 : 0);
                        pq.add(new CellInfo(newRow, newCol, actualVisitTime));
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }

    private static class CellInfo {
        int row, col, time;

        public CellInfo(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}